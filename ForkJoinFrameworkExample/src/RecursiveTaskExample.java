import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

class Working extends RecursiveTask<Integer>
{
private int num;

public Working(int num)
{
    this.num = num;
}
    @Override
    protected Integer compute() {
        if(num > 100)
        {
            System.out.println("Parallel Execution so split the task "+ num);
            Working working = new Working(num/2);
            Working working1 = new Working(num/2);

            // add the task to thread pool
            working.fork();
            working1.fork();

            // wait for these task to get finished
            int subSolution = 0;
            subSolution += working.join();
            subSolution += working1.join();
            return subSolution;
        }
        else {
            // problem is too small -- we can use sequential
            System.out.println("Sequential Execution so split the task "+ num);
            return 2*num;
        }

    }
}

public class RecursiveTaskExample

    {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Working working = new Working(200);
        System.out.println(forkJoinPool.invoke(working));
    }
}

