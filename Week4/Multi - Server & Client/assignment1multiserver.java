import java.io.*;
import java.net.*;

class ClientLeaveHandler extends Thread{
    private Socket socket;
    ClientLeaveHandler (Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try{
            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            String employeeid = input.readLine();
            System.out.println(Thread.currentThread().getName() + " Processing " + employeeid);
            output.println("Employee " + employeeid + " is leave request success");
            socket.close();
        }
        catch(Exception e){
            System.out.println(Thread.currentThread());
        }
    }
}

public class assignment1multiserver {
    public static void main(String[] args) throws Exception {
     ServerSocket server = new ServerSocket(5000);
     System.out.println("HRMS Leave Server Started.....");
     while (true) {
        Socket socket = server.accept();
        System.out.println("Client Connected");
        ClientLeaveHandler handler = new ClientLeaveHandler(socket);
        handler.start();
     }   
    }
    
}
