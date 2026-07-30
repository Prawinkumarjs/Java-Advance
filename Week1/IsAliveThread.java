class employee extends Thread{
    @Override
    public void run(){
        try{
            System.out.println("Employee Registration Started....");
            Thread.sleep(5000);
            System.out.println("Employee Registration Completed...");
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

public class IsAliveThread {
    public static void main(String[] args) throws InterruptedException {
        employee emp = new employee();

        // Before starting thread
        System.out.println("Before Start(): " + emp.isAlive());
        emp.start();

        // Give the thread a little time to start
        Thread.sleep(1000);

        // while the thread is running
        System.out.println("After Start(): " + emp.isAlive());
        emp.join();

        //wait untill the thread finishes
        System.out.println("After Completion: " + emp.isAlive());
    }
    
}
