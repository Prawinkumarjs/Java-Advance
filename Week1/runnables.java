class EmployeeRegistration implements Runnable{
    @Override
    public void run(){
        System.out.println("------------------------------");
        System.out.println("EmpID: 100");
        System.out.println("EmpName: Jack");
        System.out.println("Department: English");
        System.out.println("Registered successfully......");
        System.out.println("------------------------------");
    }
}

public class runnables {
    public static void main(String[] args) {
        EmployeeRegistration emp = new EmployeeRegistration();
        Thread thread = new Thread(emp);
        thread.start();
    }
}
