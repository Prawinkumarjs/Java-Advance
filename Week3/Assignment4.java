package Week3;
import java.io.*;

class LeaveRequestSystem implements Serializable{
    private String requestid;
    private String empid;
    private String empname;
    private String leavetype;
    private String noofdays;
    // private String status;
    private transient String status;
    
    LeaveRequestSystem(String requestid, String empid,
                        String empname, String leavetype,
                        String noofdays, String status)
    {
        this.requestid = requestid;
        this.empid = empid;
        this.empname = empname;
        this.leavetype = leavetype;
        this.noofdays = noofdays;
        this.status = status;
    }  
    public void displayleaverequest(){
        System.out.println("Request ID       : " + requestid);
        System.out.println("Employee ID      : " + empid);
        System.out.println("Employee Name    : " + empname);
        System.out.println("Leave Type       : " + leavetype);
        System.out.println("Number of Days   : " + noofdays);
        System.out.println("Status           : " + status);
        System.out.println();
    }                  
}

public class Assignment4 {
    public static void main(String[] args) throws Exception {

        LeaveRequestSystem leave1 = new LeaveRequestSystem("LR001", "EMP001", "RAM", "SICK", "3", "APPROVED");
        LeaveRequestSystem leave2 = new LeaveRequestSystem("LR002", "EMP002", "SAM", "CASUAL", "2", "PENDING");
        LeaveRequestSystem leave3 = new LeaveRequestSystem("LR003", "EMP003", "RIYA", "SICK", "5", "APPROVED");
        
        // serialization
        ObjectOutputStream output =  new ObjectOutputStream(new FileOutputStream("Leave.ser"));
        output.writeObject(leave1);
        output.writeObject(leave2);
        output.writeObject(leave3);
        output.close();

        // deserialization
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("Leave.ser"));
        LeaveRequestSystem savedLeave1 = (LeaveRequestSystem) input.readObject();
        LeaveRequestSystem savedLeave2 =(LeaveRequestSystem) input.readObject();
        LeaveRequestSystem savedLeave3 = (LeaveRequestSystem) input.readObject();
        input.close();

        System.out.println("---------------------------------");
        System.out.println("Leave Data Retrieved");
        System.out.println("---------------------------------");

        savedLeave1.displayleaverequest();
        savedLeave2.displayleaverequest();
        savedLeave3.displayleaverequest();

        System.out.println("---------------------------------");
    }
    
}
