import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    // avoid thread starvation -- all the threads are executed by executor service, avoiding deadlock using tryLock()
    // tryLock acquire lock for a small period of time
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = null;
        Philosophers[] philosophers = null;
        Chopsticks[] chopsticks = null;
        try {
            philosophers = new Philosophers[Constants.NUM_OF_PHILOSOPHERS];
         chopsticks = new Chopsticks[Constants.NUM_OF_CHOPSTICKS];

         for(int i =0; i<Constants.NUM_OF_CHOPSTICKS;++i)
         {
             chopsticks[i] = new Chopsticks(i);
         }
         executorService = Executors.newFixedThreadPool(Constants.NUM_OF_PHILOSOPHERS);
            for(int i =0; i<Constants.NUM_OF_PHILOSOPHERS;++i)
            {
                philosophers[i] = new Philosophers(i, chopsticks[i],chopsticks[(i+1)%Constants.NUM_OF_CHOPSTICKS]);
                executorService.execute(philosophers[i]);
            }
            Thread.sleep(Constants.STIMULATION_RUNNING_TIME);
            for (Philosophers philosophers1 : philosophers)
            {
                philosophers1.setFull(true);
            }
        }
        finally {
executorService.shutdown();
while (!executorService.isTerminated())

{
    Thread.sleep(1000);
}
for(Philosophers philosophers1 : philosophers)
{
    System.out.println(philosophers1 +" eat "+philosophers1.getEatingCounter() +" times!");
}
        }

    }
}
