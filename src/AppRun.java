public class AppRun {
    public static void main(String[] args) {
        Worker worker = new Worker();

        Thread t1 = new Thread(() -> {
            try {
                worker.produce();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                worker.consume();
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
