import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopsticks {
    private int id;
    private Lock lock; //for some synchronization P0 and P1 tries to occupy C0
    //P0 if already occupied C0 then P1 has to wait for that chopstick
    public Chopsticks(int id)
    {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(Philosophers philosophers, State state) throws InterruptedException {
        // simulate the deadlock -- acquire the lock thread is not blocked infinitely
        if(lock.tryLock(10, TimeUnit.MILLISECONDS))
        {
            System.out.println(philosophers + " Picked up "+ state.toString() + " " +this);
            return true;
        }
        return false;
    }

    public void putDown(Philosophers philosophers, State state)
    {
        // philosopher will release the chopstick
        lock.unlock();
        System.out.println(philosophers + " put down "+state.toString()+ " "+ this);
    }

    public String toString()
    {
        return "Chopsticks "+ id;
    }
}
