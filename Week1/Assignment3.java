class BankAccount{
    int acnum;
    String cusname;
    double balance;
    double initialBalance;

    BankAccount(int acnum, String cusname, double balance){
        this.acnum = acnum;
        this.cusname = cusname;
        this.balance = balance;
        this.initialBalance = balance;
}
    
    
    // // Assynchronize  ==================
    // public void updateBalance(String transactionName, double amount){
    //     System.out.println(transactionName + " Started updating Balance...");
    //     double temp = balance;
    //     try{
    //         Thread.sleep(1000);
    //     }
    //     catch(InterruptedException e){
    //         Thread.currentThread().interrupt();
    //     }
    //     temp = temp + amount;
    //     balance = temp;
    //     System.out.println(transactionName + " Updated Balance: " + balance);
    // }
    
    // Synchronize  =================
    public synchronized void updateBalance(String transactionName, double amount){
        System.out.println(transactionName + " Started updating Balance...");
        double temp = balance;
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        temp = temp + amount;
        balance = temp;
        System.out.println(transactionName + " Updated Balance: " + balance);
    }
    
}

class depositThread extends Thread{

    BankAccount bAccount;
    depositThread(BankAccount bAccount){
        this.bAccount = bAccount;
    }

    @Override
    public void run(){
        bAccount.updateBalance("Deposit Thread", 5000);
    
    }
}

class withDrawThread extends Thread{
    BankAccount bAccount;
    withDrawThread(BankAccount bAccount){
        this.bAccount = bAccount;
    }

    @Override
    public void run(){
        bAccount.updateBalance("Withdraw Thread", -15000);
    
    }
}

class interestThread extends Thread{
    BankAccount bAccount;
    interestThread(BankAccount bAccount){
        this.bAccount = bAccount;
    }

    @Override
    public void run(){
        bAccount.updateBalance("Interest Thread", 1000);
    
    }
}

public class Assignment3 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bAccount = new BankAccount(12345, "Prawin", 50000);
        depositThread deposit = new depositThread(bAccount);
        withDrawThread withdraw = new withDrawThread(bAccount);
        interestThread interest = new interestThread(bAccount);

        deposit.start();
        withdraw.start();
        interest.start();

        deposit.join();
        withdraw.join();
        interest.join();

        System.out.println();

        System.out.println("========================================");
        System.out.println("          Welcome to ABC Bank");
        System.out.println("========================================");
        System.out.println();
        System.out.println("             Receipt");
        System.out.println();

        System.out.println("Account Number      : " + bAccount.acnum);
        System.out.println("Customer Name       : " + bAccount.cusname);
        System.out.println("Initial Balance     : " + bAccount.initialBalance);
        System.out.println("Deposit             : +5000");
        System.out.println("Withdraw            : -15000");
        System.out.println("Interest            : +1000");

        System.out.println("----------------------------------------");
        System.out.println("Available Balance   : " + bAccount.balance);
        System.out.println("========================================");

        
    }
    
}
