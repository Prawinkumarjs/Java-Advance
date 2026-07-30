class DepositThread1 extends Thread{
    @Override
    public void run(){
        try{
            System.out.println("Deposit Started...");
            Thread.sleep(5000);
            System.out.println("Deposit Successful.");
        }
        catch (Exception e){
            Thread.currentThread().interrupt();
            // e.printStackTrace();
        }
    }
}

public class threadsleep {
    public static void main(String[] args) {
        DepositThread1 deposit = new DepositThread1();
        deposit.start();
    }
    
}
