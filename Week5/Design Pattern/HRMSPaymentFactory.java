interface Payment{
    void processPayment(double amount);
}

class SalaryPayment implements Payment{
    public void processPayment( double amount){
        System.out.println("Salary Payment done!");
        System.out.println("Salary: " + amount);
    }
}

class BonusPayment implements Payment{
    public void processPayment(double amount){
        System.out.println("Bonus Payment done!");
        System.out.println("Bonus: " + amount);
    }
}

class ReimbursementPayment implements Payment{
    public void processPayment(double amount){
        System.out.println("Reimbursement Payment done!");
        System.out.println("Reimbursement: " + amount);
    }
}

class PaymentFactory{
    public Payment createPayment(String type){
        if("SALARY".equalsIgnoreCase(type)){
            return new SalaryPayment();
        }
        else if ("BONUS".equalsIgnoreCase(type)){
            return new BonusPayment();
        }
        else if ("REIMBURSEMENT".equalsIgnoreCase(type)){
            return new ReimbursementPayment();
        }
        throw new IllegalArgumentException("Invalid employee type: " + type);
    }
}

public class HRMSPaymentFactory {
    public static void main(String[] args) {
        PaymentFactory factory = new PaymentFactory();
        Payment emp1 = factory.createPayment("SALARY");
        emp1.processPayment(30000);
        Payment emp2 = factory.createPayment("BONUS");
        emp2.processPayment(5000);
        Payment emp3 = factory.createPayment("REIMBURSEMENT");
        emp3.processPayment(3000);
    }
    
}
