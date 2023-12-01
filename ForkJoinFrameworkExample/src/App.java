import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {

        System.out.println(   Runtime.getRuntime().availableProcessors());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SimpleRecursiveActionExample simpleRecursiveActionExample = new SimpleRecursiveActionExample(800);
        simpleRecursiveActionExample.invoke();

    }
}
