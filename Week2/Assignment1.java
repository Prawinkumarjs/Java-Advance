package Week2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DepositTask implements Runnable{
    @Override 
    public void run(){
        System.out.println(Thread.currentThread().getName() + " -> Deposit Successfully");
    }
}

class WithdrawTask implements Runnable{
    @Override 
    public void run(){
        System.out.println(Thread.currentThread().getName() + " -> Withdraw Successfully");
    }
}

class BalanceEnquiryTask implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " -> Balance Enquiry");
    }
}

class MiniStatementTask implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " -> MiniStatement");
    }
}

public class Assignment1 {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.execute(new BalanceEnquiryTask());
        executor.execute(new MiniStatementTask());
        executor.shutdown();
        
    }
    
}
