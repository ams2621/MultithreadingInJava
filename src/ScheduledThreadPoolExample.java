import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarketUpdator implements Runnable
{

    @Override
    public void run() {
        System.out.println("updating stock market from web");
    }
}
public class ScheduledThreadPoolExample {
    // no need to deal with synchronization and timer using executors and executor service is powerful
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new StockMarketUpdator(),1,5, TimeUnit.SECONDS);
    }
}
