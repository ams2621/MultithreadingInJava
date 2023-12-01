import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveActionExample extends RecursiveAction {

    private int simulatedWork;
    public SimpleRecursiveActionExample(int simulatedWork)
    {
        this.simulatedWork = simulatedWork;
    }
    @Override
    protected void compute() {
        // task is too large then we need to split it and execute it in parallel
        if(simulatedWork> 100)
        {
            System.out.println("Parallel execution and split the tasks" +simulatedWork);
            SimpleRecursiveActionExample simpleRecursiveActionExample = new SimpleRecursiveActionExample(simulatedWork/2);
            SimpleRecursiveActionExample simpleRecursiveActionExample1 = new SimpleRecursiveActionExample(simulatedWork/2);

            simpleRecursiveActionExample.fork(); // async method
            simpleRecursiveActionExample1.fork();

            simpleRecursiveActionExample.join();
            simpleRecursiveActionExample1.join();

//            invokeAll(simpleRecursiveActionExample,simpleRecursiveActionExample1); // wait for execution


        }

        else
        {
            System.out.println("Sequential Approach as task is small");
            System.out.println(simulatedWork);
        }
    }
}
