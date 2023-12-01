import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Processors implements Callable<String>
{
private int id;
public Processors(int id)
{
    this.id = id;
}
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "id "+ id;
    }
}


public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            // future object stores the result
            Future<String> stringFuture= executorService.submit(new Processors(i+1));
            list.add(stringFuture);
        }

        for(Future<String> f: list)
        {
            try {
                System.out.println(f.get()); // retrieve the result
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}