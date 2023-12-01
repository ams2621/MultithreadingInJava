import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
// singleton pattern
enum Downloader
{
    INSTANCE;
    private Semaphore semaphore = new Semaphore(3,true); // 3 threads will do one time control access to web server
    public void download()
    {
        try
        {
            semaphore.acquire();
            downloadData();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
    }

    private void downloadData()
    {
        try{
            System.out.println("Downloading data from web");
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
public class SemaphoreExample {
    public static void main(String[] args) {
        // create multiple threads
        ExecutorService executorService = Executors.newCachedThreadPool();

for(int i =0;i<12;i++)
{
    executorService.execute(new Runnable() {
        @Override
        public void run() {
            Downloader.INSTANCE.download();
        }
    });
}
    }
}
