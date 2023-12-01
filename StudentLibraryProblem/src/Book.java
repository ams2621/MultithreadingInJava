import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

    //every book has a lock every student acquires it
    private int id;
    private Lock lock;

    public Book(int id)
    {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public void read(Student student) throws InterruptedException
    {
// other sol use lock, lock.lock() then use lock.unlock()

        if(lock.tryLock(10, TimeUnit.MINUTES)) {// student read that book for 10 min to avoid thread starvation and if success then he reads that book for 2 sec
            System.out.println(student + "starts reading " + this);
            Thread.sleep(2000);
            System.out.println(student + "has finished reading " + this);
        }

    }

    @Override
    public String toString() {
        return "Book" + id;
    }
}
