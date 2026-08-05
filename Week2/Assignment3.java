package Week2;

import java.util.concurrent.*;

class EmployeeProfilesTask implements Callable <String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(1000);
        return"""
                --------------------------------------------
                EMPLOYEE PROFILE REPORT
                --------------------------------------------
                Employee ID   : EMP101
                Employee Name : Rohit Sharma
                Department    : Software Development
                Designation   : Java Developer
                Experience    : 3 Years
                """;
    }
}

class ProjectAllocationTask implements Callable <String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(3000);
        return"""
                --------------------------------------------
                PROJECT ALLOCATION REPORT
                --------------------------------------------
                Project Name  : HRMS Automation
                Role          : Backend Developer
                Manager       : Rithika Singh
                Duration      : 6 Months
                """;
    }
}

class TrainingHistoryTask implements Callable <String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(4000);
        return"""
                --------------------------------------------
                TRAINING HISTORY REPORT
                --------------------------------------------
                1. Core Java           - Completed
                2. Spring Boot         - Completed
                3. SQL Fundamentals    - Completed
                4. Microservices       - In Progress

                """;
    }
}

class AssetAllocationTask implements Callable <String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(5000);
        return"""
                --------------------------------------------
                ASSET ALLOCATION REPORT
                --------------------------------------------
                Laptop            : Dell Latitude 5440
                Employee ID Card  : Allocated
                Access Card       : Active
                Headset           : Issued
                """;

    }
}

class PerformanceRatingTask implements Callable <String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(6000);
        return"""
                --------------------------------------------
                PERFORMANCE RATING REPORT
                --------------------------------------------
                Attendance    : 98%
                Task Completion : 95%
                Teamwork      : Excellent
                Overall Rating: 4.8 / 5
                Promotion Status: Eligible
                """;
    }
}


public class Assignment3 {
    public static void main(String[] args) throws Exception{

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future <String> employee = executor.submit(new EmployeeProfilesTask());
        Future <String> project = executor.submit(new ProjectAllocationTask());
        Future <String> training  = executor.submit(new TrainingHistoryTask());
        Future <String> asset  = executor.submit(new AssetAllocationTask());
        Future <String> performance = executor.submit(new PerformanceRatingTask());
        
        // System.out.println("""
        //                     ========== HRMS EMPLOYEE DASHBOARD ==========
        //                     Submitting Employee Tasks...

        //                     Generating Employee Profile...
        //                     Allocating Project...
        //                     Fetching Training History...
        //                     Checking Asset Allocation...
        //                     Calculating Performance Rating...
        //                     """);
                        
        System.out.println(" ========== HRMS EMPLOYEE DASHBOARD ==========");
        System.out.println("Generating Employee Profile...");                    
        System.out.println(employee.get());
        System.out.println("Allocating Project...");
        System.out.println(project.get());
        System.out.println("Fetching Training History...");
        System.out.println(training.get());
        System.out.println("Checking Asset Allocation...");
        System.out.println(asset.get());
        System.out.println("Calculating Performance Rating...");
        System.out.println(performance.get());
        System.out.println("""
                            --------------------------------------------
                            All reports generated successfully.
                            ExecutorService shutdown completed.
                            """);

        executor.shutdown();
    }
    
}
