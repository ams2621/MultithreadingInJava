import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable
{
    private int id;
public Task(int id)
{
    this.id = id;
}
    @Override
    public void run() {
        System.out.println("Task with id "+ id +" Thread ID "+ Thread.currentThread().getName());
        long duration = (long) (Math.random() * 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SingleThreadExecutorExample {
    public static void main(String[] args) {

        //if single thread terminates new one takes its place
        // single thread executes tasks sequentially
        ExecutorService  executorService = Executors.newSingleThreadExecutor();
        for(int i =0;i<5;i++)
        {
            executorService.execute(new Task(i));
        }
    }
}
