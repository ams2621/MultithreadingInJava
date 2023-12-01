import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Number implements Runnable
{
    int numToPrint;
    Number(int numToPrint)
    {
        this.numToPrint = numToPrint;
    }
    @Override
    public void run() {

        {
            System.out.println(numToPrint+ Thread.currentThread().getName());
        }
    }
}
public class PrintNumbersThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            Number numbers = new Number(i);
            executorService.execute(numbers);
        }
        }
    }
