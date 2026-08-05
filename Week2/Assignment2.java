package Week2;
import java.util.concurrent.*;

class AccountDetailsTask implements Callable<String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(1000);
        return"""
                ------------------------------------
                        CUSTOMER PROFILE
                ====================================
                Account No        : 11223344
                Customer Name     : Prawin
                Account Type      : Savings Account
                Account Status    : Active
                Branch            : Chennai
                Available Balance : $87,654.32
            
                """;
    }
}

class DepositHistoryTask implements Callable <String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(3000);
        return"""
                ------------------------------------
                    DEPOSIT TRANSACTION HISTORY
                ====================================
                01-08-2026     : $10,000
                03-08-2026     : $5,500
                05-08-2026     : $20,000
                ------------------------------------
                Total Deposits : $35,500

                """;
    }
}

class WithdrawalHistoryTask implements Callable <String>{
    @Override
    public String call()throws Exception{
        Thread.sleep(4000);
        return"""
                -----------------------------------
                       WITHDRAWAL HISTORY 
                ===================================
                02-08-2026        : $2,000
                04-08-2026        : $1,500
                05-08-2026        : $5,000
                ----------------------------------
                Total Withdrawals : $8,500
                """;
    }
}

class LoanDetailsTask implements Callable <String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(5000);
        return"""
                -----------------------------------
                        LOAN DETAILS 
                ===================================
                Loan Type      : Home Loan
                Loan Amount    : $15,00,000
                Outstanding    : $9,75,000
                EMI            : $18,500
                Loan Status    : Active
                """;
    }
}

public class Assignment2 {
    public static void main(String[] args) throws Exception {
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future <String> account = executor.submit(new AccountDetailsTask());
        Future <String> deposit = executor.submit(new DepositHistoryTask());
        Future <String> withdraw = executor.submit(new WithdrawalHistoryTask());
        Future <String>  loan = executor.submit(new LoanDetailsTask());

        System.out.println("================================");
        System.out.println("            ABC BANK");
        System.out.println("================================");
        System.out.println();
        System.out.println(account.get());
        System.out.println(deposit.get());
        System.out.println(withdraw.get());
        System.out.println(loan.get());
        System.out.println("""
                            ==================================
                            All reports generated successfully.
                            ExecutorService shutdown completed.""");
        executor.shutdown();

    }
    
}
