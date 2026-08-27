package Assignment;

class BankAccount {

    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    public synchronized boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }

        if (balance < amount) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public static boolean transfer(BankAccount from, BankAccount to, double amount) {
        if (from == null || to == null || from == to || amount <= 0) {
            return false;
        }

        BankAccount first;
        BankAccount second;

        if (from.accountNumber.compareTo(to.accountNumber) < 0) {
            first = from;
            second = to;
        } else {
            first = to;
            second = from;
        }

        synchronized (first) {
            synchronized (second) {
                if (from.balance < amount) {
                    return false;
                }

                from.balance -= amount;
                to.balance += amount;
                return true;
            }
        }
    }

    @Override
    public String toString() {
        return accountNumber + " -> Balance: " + balance;
    }
}


class Transaction {

    enum TransactionType {
        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        BALANCE_ENQUIRY
    }

    private String transactionId;
    private String accountNumber;
    private TransactionType transactionType;
    private double amount;
    private String targetAccountNumber;

    public Transaction(String transactionId, String accountNumber, TransactionType transactionType, double amount) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Transaction(String transactionId, String accountNumber, TransactionType transactionType, double amount, String targetAccountNumber) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.targetAccountNumber = targetAccountNumber;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }

    @Override
    public String toString() {
        return transactionId + " | " + accountNumber + " | " + transactionType + " | Amount: " + amount;
    }
}

class TransactionProcessor {

    private BankAccount account1;
    private BankAccount account2;

    private int successfulTransactions = 0;
    private int failedTransactions = 0;

    public TransactionProcessor(BankAccount account1, BankAccount account2) {
        this.account1 = account1;
        this.account2 = account2;
    }

    public BankAccount findAccount(String accountNumber) {
        if (account1.getAccountNumber().equals(accountNumber)) {
            return account1;
        }

        if (account2.getAccountNumber().equals(accountNumber)) {
            return account2;
        }

        return null;
    }

    private synchronized void incrementSuccessful() {
        successfulTransactions++;
    }

    private synchronized void incrementFailed() {
        failedTransactions++;
    }

    public void processTransaction(Transaction transaction) {
        String threadName = Thread.currentThread().getName();
        BankAccount account = findAccount(transaction.getAccountNumber());

        if (account == null) {
            incrementFailed();
            System.out.println(threadName + " | " + transaction.getTransactionId() + " | FAILED | Account not found");
            return;
        }

        switch (transaction.getTransactionType()) {

            case DEPOSIT:
                if (account.deposit(transaction.getAmount())) {
                    incrementSuccessful();
                    System.out.println(threadName + " | " + transaction.getTransactionId() + " | SUCCESS | DEPOSIT | Amount: " + transaction.getAmount() + " | Balance: " + account.getBalance());
                } else {
                    incrementFailed();
                    System.out.println(threadName + " | " + transaction.getTransactionId() + " | FAILED | DEPOSIT | Amount: " + transaction.getAmount());
                }
                break;

            case WITHDRAW:
                if (account.withdraw(transaction.getAmount())) {
                    incrementSuccessful();
                    System.out.println(threadName + " | " + transaction.getTransactionId() + " | SUCCESS | WITHDRAW | Amount: " + transaction.getAmount() + " | Balance: " + account.getBalance());
                } else {
                    incrementFailed();
                    System.out.println(threadName + " | " + transaction.getTransactionId() + " | FAILED | WITHDRAW | Amount: " + transaction.getAmount() + " | Reason: Insufficient Balance");
                }
                break;

            case BALANCE_ENQUIRY:
                incrementSuccessful();
                System.out.println(threadName + " | " + transaction.getTransactionId() + " | SUCCESS | BALANCE ENQUIRY | Balance: " + account.getBalance());
                break;

            case TRANSFER:
                BankAccount targetAccount = findAccount(transaction.getTargetAccountNumber());

                if (targetAccount == null) {
                    incrementFailed();
                    System.out.println(threadName + " | " + transaction.getTransactionId() + " | FAILED | TRANSFER | Target account not found");
                    break;
                }

                if (BankAccount.transfer(account, targetAccount, transaction.getAmount())) {
                    incrementSuccessful();
                    System.out.println(threadName + " | " + transaction.getTransactionId() + " | SUCCESS | TRANSFER | " + account.getAccountNumber() + " -> " + targetAccount.getAccountNumber() + " | Amount: " + transaction.getAmount());
                } else {
                    incrementFailed();
                    System.out.println(threadName + " | " + transaction.getTransactionId() + " | FAILED | TRANSFER | Reason: Insufficient Balance");
                }
                break;
        }
    }

    public void displaySummary() {
        System.out.println("\n========== TRANSACTION SUMMARY ==========");
        System.out.println("Successful Transactions: " + successfulTransactions);
        System.out.println("Failed Transactions: " + failedTransactions);
        System.out.println("=========================================");
    }

    public void displayFinalBalances() {
        System.out.println("\n========== FINAL BALANCES ==========");
        System.out.println(account1.getAccountNumber() + " : " + account1.getBalance());
        System.out.println(account2.getAccountNumber() + " : " + account2.getBalance());
        System.out.println("===================================");
    }
}


class TransactionTask implements Runnable {

    private Transaction transaction;
    private TransactionProcessor processor;

    public TransactionTask(Transaction transaction, TransactionProcessor processor) {
        this.transaction = transaction;
        this.processor = processor;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            processor.processTransaction(transaction);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}


public class BankApplication {

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("ACC101", 10000);
        BankAccount account2 = new BankAccount("ACC102", 5000);

        TransactionProcessor processor = new TransactionProcessor(account1, account2);

        System.out.println("========== INITIAL BALANCES ==========");
        System.out.println(account1);
        System.out.println(account2);

        Transaction t1 = new Transaction("T001", "ACC101", Transaction.TransactionType.DEPOSIT, 10000);
        Transaction t2 = new Transaction("T002", "ACC101", Transaction.TransactionType.WITHDRAW, 3000);
        Transaction t3 = new Transaction("T003", "ACC102", Transaction.TransactionType.DEPOSIT, 5000);
        Transaction t4 = new Transaction("T004", "ACC101", Transaction.TransactionType.WITHDRAW, 4000);
        Transaction t5 = new Transaction("T005", "ACC101", Transaction.TransactionType.WITHDRAW, 50000);
        Transaction t6 = new Transaction("T006", "ACC101", Transaction.TransactionType.BALANCE_ENQUIRY, 0);

        Transaction t7 = new Transaction("T007", "ACC101", Transaction.TransactionType.TRANSFER, 2000, "ACC102");
        Transaction t8 = new Transaction("T008", "ACC102", Transaction.TransactionType.TRANSFER, 1000, "ACC101");

        Thread thread1 = new Thread(new TransactionTask(t1, processor), "Transaction-1");
        Thread thread2 = new Thread(new TransactionTask(t2, processor), "Transaction-2");
        Thread thread3 = new Thread(new TransactionTask(t3, processor), "Transaction-3");
        Thread thread4 = new Thread(new TransactionTask(t4, processor), "Transaction-4");
        Thread thread5 = new Thread(new TransactionTask(t5, processor), "Transaction-5");
        Thread thread6 = new Thread(new TransactionTask(t6, processor), "Transaction-6");
        Thread thread7 = new Thread(new TransactionTask(t7, processor), "Transaction-7");
        Thread thread8 = new Thread(new TransactionTask(t8, processor), "Transaction-8");

        System.out.println("\n========== PROCESSING TRANSACTIONS ==========");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
            Thread.currentThread().interrupt();
        }

        processor.displaySummary();
        processor.displayFinalBalances();
    }
}