class DepositJoin extends Thread{
    @Override
    public void run(){
        try{
                Thread.sleep(3000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Deposit Completed");
    }
}

class WithdrawJoin extends Thread{
    @Override
    public void run(){
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Withdraw completed");
    }
}

public class threadjoin {
    public static void main(String[] args) {
        DepositJoin deposit = new DepositJoin();
        WithdrawJoin withdraw = new WithdrawJoin();

        deposit.start();
        withdraw.start();

        // wait untill both threads finish
        try {
            deposit.join();
            withdraw.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("---------------------------");
        System.out.println("Displaying Final Balance...");
        System.out.println("---------------------------");
    }
    
}
