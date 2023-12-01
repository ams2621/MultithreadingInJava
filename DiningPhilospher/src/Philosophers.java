import java.util.Random;

public class Philosophers implements Runnable{

    private int id;
    private volatile boolean full; // value is always written to the main memory rather than thread's caches so that updated value is read by individual threads
    private Chopsticks leftChopsticks;
    private Chopsticks rightChopsticks;
    private Random random;
    private int eatingCounter;
// picks left then right ....puts down right then left chopsticks

    public Philosophers(int id, Chopsticks leftChopsticks, Chopsticks rightChopsticks)
            // every philosopher is the thread in application
    {
        this.id = id;
        this.leftChopsticks = leftChopsticks;
        this.rightChopsticks = rightChopsticks;
        this.random = new Random();
    }
    @Override
    public void run() {

        try {
            while (!full)
            {
                think();

                if(leftChopsticks.pickUp(this,State.LEFT))
                {
                    if(rightChopsticks.pickUp(this,State.RIGHT))
                    {
                        eat();
                        rightChopsticks.putDown(this,State.RIGHT);
                    }
                    leftChopsticks.putDown(this,State.LEFT);
                }
            }
        } catch (InterruptedException e) {
         e.printStackTrace();
        }

    }
    private void think() throws InterruptedException
    {
        System.out.println(this + " is thinking....");
        //the philosopher thinks for a random amount of time 0 to 1000
        Thread.sleep(random.nextInt(1000));
    }
    private void eat() throws InterruptedException
    {
        System.out.println(this + " is eating....");

        eatingCounter++;
        //the philosopher eats for a random amount of time 0 to 1000
        Thread.sleep(random.nextInt(1000));
    }
    public void setFull(boolean full)
    {
        this.full = full;
    }
    public boolean isFull()
    {
       return this.full;
    }
    public int getEatingCounter()
    {
        return this.eatingCounter;
    }
    public String toString()
    {
        return "Philosopher.." +id;
    }
}
