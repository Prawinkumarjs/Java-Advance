package Week3;

import java.lang.reflect.*;

class Customer{
    private String customerId;
    private String customerName;
    private String phoneNumber;

    public void displayCustomer(){

    }
    public void updateCustomer(){

    }
}

class Account {
    int accountno;
    String accounttype;
    double balance;

    public void deposit(){

    }
    public void withdraw(){

    }
    public void viewbalance(){

    }
}

class Loan{
    int loanid;
    float interestrate;
    double loanamount;

    public void calculateEMI(){

    }
    public void displayLoan(){

    }
}

class Transaction{
    int transactionid;
    String transactiontype;
    double amount;

    public void debit(){

    }
    public void credit(){

    }
    public void displayTransaction(){

    }
}

public class Assignment2 {
    public static void main(String[] args) {
        Class<Account> ac = Account.class;
        Class<Customer> cus = Customer.class;
        Class<Transaction> trans = Transaction.class;
        Class<Loan> loan = Loan.class;

        
        System.out.println("------------------------------");
        System.out.println("Class Name: " + cus.getName());
        System.out.println();
        System.out.println("Fields Names: ");
        System.out.println();
        Field[] cusfields = cus.getDeclaredFields();
        for(Field cusfield : cusfields){
            System.out.println(cusfield.getName());
        }
        System.out.println();
        System.out.println("Methods Names: ");
        System.out.println();
        Method[] cusmethods = cus.getDeclaredMethods();
        for (Method cusmethod : cusmethods){
            System.out.println(cusmethod.getName());
        }
        System.out.println("-----------------------------");



        System.out.println("------------------------------");
        System.out.println("Class Name: " + ac.getName());
        System.out.println();
        System.out.println("Fields Names: ");
        System.out.println();
        Field[] acfields = ac.getDeclaredFields();
        for(Field acfield : acfields){
            System.out.println(acfield.getName());
        }
        System.out.println();
        System.out.println("Methods Names: ");
        System.out.println();
        Method[] acmethods = ac.getDeclaredMethods();
        for (Method acmethod : acmethods){
            System.out.println(acmethod.getName());
        }
        System.out.println("-----------------------------");



        System.out.println("------------------------------");
        System.out.println("Class Name: " + trans.getName());
        System.out.println();
        System.out.println("Fields Names: ");
        System.out.println();
        Field[] transfields = trans.getDeclaredFields();
        for(Field transfield : transfields){
            System.out.println(transfield.getName());
        }
        System.out.println();
        System.out.println("Methods Names: ");
        System.out.println();
        Method[] transmethods = trans.getDeclaredMethods();
        for (Method transmethod : transmethods){
            System.out.println(transmethod.getName());
        }
        System.out.println("-----------------------------");



        System.out.println("------------------------------");
        System.out.println("Class Name: " + loan.getName());
        System.out.println();
        System.out.println("Fields Names: ");
        System.out.println();
        Field[] loanfields = loan.getDeclaredFields();
        for(Field loanfield : loanfields){
            System.out.println(loanfield.getName());
        }
        System.out.println();
        System.out.println("Methods Names: ");
        System.out.println();
        Method[] loanmethods = loan.getDeclaredMethods();
        for (Method loanmethod : loanmethods){
            System.out.println(loanmethod.getName());
        }
        System.out.println("-----------------------------");


    }
    
}
