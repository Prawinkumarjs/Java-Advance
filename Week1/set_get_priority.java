class EmployeePriority extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getPriority());
    }
}

public class set_get_priority {
    public static void main(String[] args) {
        EmployeePriority emppr = new EmployeePriority();
        emppr.setPriority(8);
        emppr.start();

        
    }
    
}


// this is not used in production
// 1  -> lower prior
// 5  -> default
// 10 -> high