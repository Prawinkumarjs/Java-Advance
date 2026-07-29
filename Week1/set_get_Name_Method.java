class EmployeeThread1 extends Thread{
    @Override
    public void run(){
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }
}
public class set_get_Name_Method {
    public static void main(String[] args) {
        EmployeeThread1 emp = new EmployeeThread1();
        emp.setName("Employee Registration Thread");
        emp.start();
    }
    
}









// | Method                   | Purpose                                 |
// | ------------------------ | --------------------------------------- |
// | `setName(String)`        | Assigns a custom name to a thread.      |
// | `getName()`              | Returns the thread's name.              |
// | `Thread.currentThread()` | Returns the currently executing thread. |
// | `start()`                | Starts the thread and invokes `run()`.  |
