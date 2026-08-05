package Week2;

import java.util.concurrent.*;

class EmployeeProfileTask implements Callable <String>{

    @Override
    public String call() throws Exception{
        Thread.sleep(1000);
        return """
                ----------------------------------
                Employee Profile
                ----------------------------------
                Employee ID       : EMP101
                Employee Name     : Prawin
                Department        : SAP
                Status            : Active
                ----------------------------------
                """;
    }
}


class PayrollReportTask implements Callable <String>{

    @Override
    public String call() throws Exception{
        Thread.sleep(1000);
        return """
                ----------------------------------
                Payroll Report
                ----------------------------------
                Basic Salary     : 20000
                HRA              :  5000
                Net Salary       : 25000
                ----------------------------------
                """;
    }
}

class AttedanceReportTask implements Callable <String>{

    @Override
    public String call() throws Exception{
        Thread.sleep(1000);
        return """
                ----------------------------------
                Attendance Report
                ----------------------------------
                Working Days     : 30
                Present          : 29
                Leave            : 1
                ----------------------------------
                """;
    }
}

class LeaveReportTask implements Callable <String>{

    @Override
    public String call() throws Exception{
        Thread.sleep(1000);
        return """
                ----------------------------------
                Leave Report
                ----------------------------------
                Casual Leave   : 3
                Sick Leave     : 2
                Balance        : 8
                ----------------------------------
                """;
    }
}



public class Multiple_Parallel_Callable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future <String> employee = executor.submit(new EmployeeProfileTask());
        Future <String> payroll = executor.submit(new PayrollReportTask());
        Future <String> attendance = executor.submit(new AttedanceReportTask());
        Future <String> leave = executor.submit(new LeaveReportTask());

        System.out.println(employee.get());
        System.out.println(payroll.get());
        System.out.println(attendance.get());
        System.out.println(leave.get());
        executor.shutdown();
        
    }
    
}
