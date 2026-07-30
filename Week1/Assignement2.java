class TicketBookingThread extends Thread{
    @Override
    public void run(){
        try{
            // System.out.println("------------------------------------------");
            System.out.println("Ticket Booking Started....");
            System.out.println("Passenger Name: Prawin");
            System.out.println("Train No: 12666");
            System.out.println("Source: Chennai");
            System.out.println("Destination: Bodianayakanur");
            Thread.sleep(2000);
            
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Ticket Booking Completed!!!");
        System.out.println("------------------------------------------");
        
    }
}

class PaymentThread extends Thread{
    @Override
    public void run(){
        try{
            // System.out.println("------------------------------------------");
            System.out.println("\nPayment is Processing...");
            Thread.sleep(5000);

        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Ticket Fare: 200");
        System.out.println("Payment Done!!!");
        System.out.println("------------------------------------------");
    }
}

class SeatAllocationThread extends Thread{
    @Override
    public void run(){
    
          try{
            System.out.println("\nSeat Allocation Started...");
            System.out.println("Coach No: S2");
            System.out.println("Seat No: 11");
            Thread.sleep(2000);
            
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Seat Allocated Successfully!!!");
        System.out.println("------------------------------------------");
    }
}

class TicketGenerationThread extends Thread{
    @Override
    public void run(){
        // System.out.println("------------------------------------------");
        try{
            System.out.println("\nTicket Generation Started...");
            System.out.println("Generating E-Ticket");
            System.out.println("Ticket Generated Successfully...");
            Thread.sleep(2000);

        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        // System.out.println("------------------------------------------");
    }
}

public class Assignement2 {
    public static void main(String[] args) throws InterruptedException {

        TicketBookingThread tickbook = new TicketBookingThread();
        PaymentThread payment = new PaymentThread();
        SeatAllocationThread seatalloc = new SeatAllocationThread();
        TicketGenerationThread tickgen = new TicketGenerationThread();

        System.out.println("============================================");
        System.out.println("         Railway Reservation System         ");
        System.out.println("============================================");

        System.out.println();
        tickbook.start();
        tickbook.join();

        payment.start();
        System.out.println("\nDuring Payment Thread Alive: " + payment.isAlive());
        payment.join();
        System.out.println("\nAfter Payment Thread Alive: " + payment.isAlive());
        System.out.println("------------------------------------------");
            

        seatalloc.start();
        seatalloc.join();
        
        tickgen.start();
        tickgen.join();

        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("*******Ticket Booked Successfully*******");
        System.out.println("------------------------------------------");

        System.out.println();
        System.out.println();

        System.out.println("============================================");
        System.out.println("         Railway Reservation System         ");
        System.out.println("============================================");
        System.out.println("Passenger Name:     Prawin");
        System.out.println("Train No      :     12666");
        System.out.println("Source        :     Chennai");
        System.out.println("Destination   :     Bodianayakanur");
        System.out.println("Ticket Fare   :     200");
        System.out.println("Coach No      :     S2");
        System.out.println("Seat No       :     11");
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("*******Thank you:) Enjoy Your Journey*******");
        System.out.println("--------------------------------------------");

        
    }
}