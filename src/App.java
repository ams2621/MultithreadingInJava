public class App {
    public static void main(String[] args) {
        Processor processor  = new Processor();

        Thread t1 = new Thread(() -> {
            try {
                processor.producer();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                processor.consumer();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}
