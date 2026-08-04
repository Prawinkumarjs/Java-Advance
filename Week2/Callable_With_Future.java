package Week2;
import java.util.concurrent.*;

class EmployeeReport implements Callable<String>{

    @Override
    public String call() throws Exception{
        Thread.sleep(100);
        return """
                ------------------------------
                Employee Report
                Employee ID    : EMP001
                Employee Name  : Prawin
                Department     : SAP
                Status         : Active
                ------------------------------
                """;
    }
}

public class Callable_With_Future{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> report = executor.submit(new EmployeeReport());
        System.out.println("Generating Report...");
        System.out.println(report.get());
        executor.shutdown();   
    } 
}



// What is Callable?

// Callable is an interface used to execute a task that returns a value.

// Unlike Runnable, it can:

// Return a value
// Throw checked exceptions


// | Runnable                                 | Callable                     |
// | ---------------------------------------- | ---------------------------- |
// | `run()`                                  | `call()`                     |
// | Returns nothing (`void`)                 | Returns a value (`T`)        |
// | Cannot return data                       | Can return data              |
// | Used with `execute()`                    | Used with `submit()`         |
// | Cannot throw checked exceptions directly | Can throw checked exceptions |
