class Numbers implements Runnable
{
int numToPrint;
    Numbers(int numToPrint)
    {
        this.numToPrint = numToPrint;
    }
    @Override
    public void run() {

        {
            System.out.println(numToPrint+ Thread.currentThread().getName());
        }
    }
}
public class PrintNumbers {
    // one thread to print 1 , then second thread print 2....we can even use thread pools
    public static void main(String[] args) {
        System.out.println("Start!!! "+ Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            Numbers numbers = new Numbers(i);
            Thread thread = new Thread(numbers);
            thread.start();
        }
        System.out.println("Finish!!! "+ Thread.currentThread().getName());
    }
}
