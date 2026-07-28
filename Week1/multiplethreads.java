class HRThread extends Thread{
    @Override
    public void run(){
        System.out.println("HR");
        for(int i = 1; i <= 3; i++){
            System.out.println("HR: Register Employee...");
        }
    }
}

class PayrollThread extends Thread{
    @Override
    public void run(){
        System.out.println("Salary");
        for (int i = 1; i <= 3; i++){
            System.out.println("Payroll: Processing Salary...");
        }
    }
}

class AttendanceThread  extends Thread{
    @Override
    public void run(){
        System.out.println("Daily Attendance");
        for(int i = 1; i <= 3; i++){
            System.out.println("Attendance: Processing Attendance");
        }
    }
}

public class multiplethreads {
    public static void main(String[] args) {
        HRThread hr = new HRThread();
        PayrollThread salary = new PayrollThread();
        AttendanceThread attendance = new AttendanceThread();

        hr.start();
        salary.start();
        attendance.start();
        
    }
    
}
