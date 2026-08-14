import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("HRMS Server started...");
        System.out.println("Waiting for Client....");

        Socket socket = server.accept();
        System.out.println("Client Connected.");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
        String employeeId = input.readLine();
        System.out.println("Employee ID Received: " + employeeId);
        output.println("Employee " + employeeId + " is Active");
        socket.close();
        server.close();

    }   
    
}
