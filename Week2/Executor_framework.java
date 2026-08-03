package Week2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class EmployeeRegistration_Exe implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " -> Employee Registration");
    }
}

class AttendanceProcessing_Exe implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " -> Attendance Processing");
    }
}

class PayrollProcessing_Exe implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " -> Payroll Processing");
    }
}

class EmailNotification_Exe implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " -> Email Notification");
    }
}



public class Executor_framework {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new EmployeeRegistration_Exe());
        executor.execute(new PayrollProcessing_Exe());
        executor.execute(new AttendanceProcessing_Exe());
        executor.execute(new EmailNotification_Exe());
        // Shutdown the executor after submitting all tasks
        executor.shutdown();

    }
    
}
