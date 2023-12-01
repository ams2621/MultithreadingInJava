class HelloWorldPrinter implements Runnable // can run from a separate thread
{
    //thread is a task

    @Override
    public void run() {
        System.out.println("hello world " + Thread.currentThread().getName()); // code we want to do in parallel
    }
}

public class Basic {
    public static void main(String[] args) { // default main thread is created and every process has one thread
        System.out.println("I am Amisha " + Thread.currentThread().getName()); // main thread
HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter(); // create an object of task
Thread t = new Thread(helloWorldPrinter);// create an object of thread
        System.out.println("I am Amisha1 " + Thread.currentThread().getName());// main thread
        t.start(); // parallel thread
        System.out.println("I am Amisha2 " + Thread.currentThread().getName());// main thread // parallel thread as well

    }
}
