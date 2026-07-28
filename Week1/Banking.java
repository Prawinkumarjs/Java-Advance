class DepositThread extends Thread{
    public void run(){
        System.out.println("Deposit: $50000 Successfully.");
    }
}

class WithdrawThread extends Thread{
    public void run(){
        System.out.println("Withdraw: $8000 Successfully.");
    }
}

class BalanceThread extends Thread{
    public void run(){
        System.out.println("Current Balance: $9999999999");
    }
}

public class Banking {
    public static void main(String[] args) {
        DepositThread deposit = new DepositThread();
        WithdrawThread withdraw = new WithdrawThread();
        BalanceThread balance = new BalanceThread();

        deposit.start();
        withdraw.start();
        balance.start();
        
    }
    
}
