class Payroll implements Runnable{
    @Override 
    public void run(){
        System.out.println("Payroll Processing Started");
    }
}

class Attendance implements Runnable{
    @Override
    public void run(){
        System.out.println("Attendance Marked");
    }
}

class EmailNotification implements Runnable{
    @Override
    public void run(){
        System.out.println("Email Notification Send");
    }
}

public class Mutliple_runnable {
    public static void main(String[] args) {
        Payroll paymentPayroll = new Payroll();
        Attendance attend = new Attendance();
        EmailNotification emailnotify = new EmailNotification();

        Thread payment = new Thread(paymentPayroll);
        Thread Attend = new Thread(attend);
        Thread email = new Thread(emailnotify);

        payment.start();
        Attend.start();
        email.start();
    }
    
}
