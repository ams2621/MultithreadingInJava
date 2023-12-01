import java.util.ArrayList;
import java.util.List;

public class Processor {
    // wait and notify
    private List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private int value = 0;

    public void producer() throws InterruptedException {
        //0,1,2,3,4,5 insert
        synchronized (lock) {
            while (true) {
                if (list.size() == UPPER_LIMIT) {
                    System.out.println("Waiting for removing items");
                    value = 0;
                    lock.wait();
                } else {
                    System.out.println("Adding " + value);
                    list.add(value);
                    value++;
                    //call notify
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }

    }

    public void consumer() throws InterruptedException {
//0,1,2,3,4,5 remove
        synchronized (lock) {
            while (true) {
                if (list.size() == LOWER_LIMIT) {
                    System.out.println("Waiting for adding items");
                    lock.wait();
                } else {
                    System.out.println("Removing " + list.remove(list.size() - 1));
                    //call notify if in waiting state
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}
