package Week2;
import java.util.concurrent.*;

class PayrollTask implements Runnable{
    private String empid;
    private String empname;

    PayrollTask(String empid, String empname){
        this.empid = empid;
        this.empname = empname;
    }
    @Override
    public void run() {
        // System.out.println("-------------------------------------");
        System.out.println("Thread Name : " + Thread.currentThread().getName());
        System.out.println("Processing Salary...");
    
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Employee ID    : " + empid);
        System.out.println("Employee Name  : " + empname);
        System.out.println("Salary Processed Successfully.");
        System.out.println("------------------------------------");
    }
}

public class Executor_fw_Multiple_Thread_pool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new PayrollTask("EMP001","RAJ"));
        executor.execute(new PayrollTask("EMP002","AJAY"));
        executor.execute(new PayrollTask("EMP003","ARYA"));
        executor.execute(new PayrollTask("EMP004","ANU"));
        executor.execute(new PayrollTask("EMP005","ANITHA"));
        executor.shutdown();
    }
    
}
