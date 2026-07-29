class DepositBank implements Runnable{
    @Override
    public void run(){
        System.out.println("Amount Deposited Successfully...");
    }
}
class WithdrawBank implements Runnable{
    @Override
    public void run(){
        System.out.println("Amount Withdraw Successfully...");
    }
}

class BalanceEnquiryBank implements Runnable{
    @Override
    public void run(){
        System.out.println("Your Bank Balance is $ XXXXXX.XX");
    }
}

class MiniStatementBank implements Runnable{
    @Override
    public void run(){
        System.out.println("MiniStatement is Generating....");
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        DepositBank depositbank = new DepositBank();
        WithdrawBank withdrawbank = new WithdrawBank();
        BalanceEnquiryBank balancebank = new BalanceEnquiryBank();
        MiniStatementBank ministmtbank = new MiniStatementBank();

        Thread deposit = new Thread(depositbank);
        Thread withdraw = new Thread(withdrawbank);
        Thread balance = new Thread(balancebank);
        Thread ministmt = new Thread(ministmtbank);

        deposit.start();
        withdraw.start();
        balance.start();
        ministmt.start();

    }
    
}
