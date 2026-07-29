class EmployeeThread extends Thread{
    @Override
    public void run(){
        System.out.println("Welcome");
    }
}

public class start_vs_run {
    public static void main(String[] args) {
        EmployeeThread thread = new EmployeeThread();
        thread.run();    // Normal method call
        thread.start();  // Creates a new thread and then calls run()
    }
    
}
