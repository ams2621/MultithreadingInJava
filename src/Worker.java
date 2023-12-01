import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// producer and consumer with locks
public class Worker {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    // not able to call wait and notify on the locks

    public void produce() throws InterruptedException
    {
        lock.lock();
        System.out.println("producer method");
        //wait
        condition.await();
        System.out.println("Again Producer method");
        lock.unlock();
    }
    public void consume() throws InterruptedException
    {
Thread.sleep(2000);
lock.lock();
        System.out.println("Consumer method");
        Thread.sleep(3000);
        // notify
        condition.signal();
        lock.unlock();
    }
}
