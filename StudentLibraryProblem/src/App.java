import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {

        Student[] student = null;
        Book[] books = null;

        ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUM_OF_STUDENTS);

        try {
            books = new Book[Constants.NUM_OF_BOOKS];
            student = new Student[Constants.NUM_OF_STUDENTS];

            for(int i =0; i<Constants.NUM_OF_BOOKS;++i)
            {
                books[i] = new Book(i+1);
            }

            for(int i =0; i<Constants.NUM_OF_STUDENTS;++i)
            {
                student[i] = new Student(i+1, books);
                executorService.execute(student[i]);
            }
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
        }
        finally {
            executorService.shutdown();
        }
    }
}
