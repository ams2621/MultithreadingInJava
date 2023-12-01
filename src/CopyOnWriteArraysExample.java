import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class ReadList implements Runnable
{
    private List<Integer> list;
    public ReadList(List<Integer> list)
    {
        this.list  = list;
    }
    public void run()
    {
        while (true)
        {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(list);
        }
    }


}

class WriteList implements Runnable
{
    private List<Integer> list;
    private Random random;
    public WriteList(List<Integer> list)
    {
        this.list  = list;
        this.random = new Random();
    }
    public void run()
    {
        while (true)
        {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            list.set(random.nextInt(list.size()), random.nextInt(10));
        }
    }


}

public class CopyOnWriteArraysExample {
    //synchronized version of list faster than vector
private List<Integer> list;
public CopyOnWriteArraysExample()
{
    this.list = new CopyOnWriteArrayList<>();
    this.list.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0));
}
public void stimulate()
{
    Thread thread1 = new Thread(new WriteList(list));
    Thread thread2 = new Thread(new WriteList(list));
    Thread thread3 = new Thread(new WriteList(list));
    Thread thread4 = new Thread(new ReadList(list));
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
}


    public static void main(String[] args) {
CopyOnWriteArraysExample copy = new CopyOnWriteArraysExample();

copy.stimulate();
    }
}
