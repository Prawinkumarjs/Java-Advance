class EmployeeSalary{
    int empid;
    String empname;
    double salary;

    EmployeeSalary(int empid, String empname, double salary){
        this.empid = empid;
        this.empname = empname;
        this.salary = salary;
    }
    // here synchronized key word for synchronize
    public synchronized void updateSalary(String department, double amount){
        System.out.println(department + " Started updating Salary....");
        double temp = salary;
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        temp = temp + amount;
        salary = temp;
        System.out.println(department + " Updated Salary: " + salary);
    }
} 

class PayrollThread_RC extends Thread{
    EmployeeSalary employees;
    PayrollThread_RC(EmployeeSalary employees){
        this.employees = employees;

    }
    @Override
    public void run(){
        employees.updateSalary("Payroll Team", 3000);
    }
}

class AttendanceThread_RC extends Thread{
    EmployeeSalary employees;
    AttendanceThread_RC(EmployeeSalary employees){
        this.employees = employees;

    }
    @Override
    public void run(){
        employees.updateSalary("Attendance Team", -2000);
    }
}

class FinanceThread_RC extends Thread{
    EmployeeSalary employees;
    FinanceThread_RC(EmployeeSalary employees){
        this.employees = employees;

    }
    @Override
    public void run(){
        employees.updateSalary("Finance Team", 500);
    }
}



public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        EmployeeSalary employees = new EmployeeSalary(1001,"Raj",50000);
        PayrollThread_RC payroll  = new PayrollThread_RC(employees);
        AttendanceThread_RC attendance = new AttendanceThread_RC(employees);
        FinanceThread_RC finance = new FinanceThread_RC(employees);

        payroll.start();
        attendance.start();
        finance.start();
        
        payroll.join();
        attendance.join();
        finance.join();

        System.out.println("-----------------------------");
        System.out.println("Final Salary: " + employees.salary);
        System.out.println("-----------------------------");

    }
    
}
