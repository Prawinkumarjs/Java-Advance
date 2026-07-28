/**
 * creatingthreads
 */
public class creatingthreads extends Thread {
    @Override
    public void run(){
        System.out.println("-----------------");
        System.out.println("Employee Registration Started...");
        System.out.println("Employee Name: Sethu");
        System.out.println("Employee ID: emp001");
        System.out.println("Department: SAP");
        System.out.println("Employee Registered Successfully.");
        System.out.println("----------------");
    }

    public static void main(String[] args) {
        creatingthreads  registration = new creatingthreads();
        registration.start();
    }

    
}