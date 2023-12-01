import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskAssigned implements Runnable
{
private int id;
public TaskAssigned(int id)
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



public class FixedThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i =0;i<50;i++)
        {
            executorService.execute(new TaskAssigned(i+1));
        }
        // stopping executor
        // we prevent executor to execute any further tasks
        executorService.shutdown();

        //terminate actual running tasks
        try {
if(!executorService.awaitTermination(1000,TimeUnit.MILLISECONDS))
{
    executorService.shutdownNow();
}
        } catch (InterruptedException e) {
          executorService.shutdownNow();
        }
    }
}
