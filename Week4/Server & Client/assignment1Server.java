import java.io.*;
import java.net.*;

public class assignment1Server {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);

        System.out.println("HRMS Server started...");
        System.out.println("Waiting for Client....");

        Socket socket = server.accept();

        System.out.println("Client Connected.");

        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);

        // Receive Employee ID
        String employeeId = input.readLine();

        System.out.println("Employee ID Received: " + employeeId);

        // Prepare employee details
        if (employeeId.equals("EMP1001")) {

            output.println("Employee Details");
            output.println("------------------------");
            output.println("Employee ID   : EMP1001");
            output.println("Employee Name : Rama");
            output.println("Department    : SAP");
            output.println("Status        : Active");
            output.println("------------------------");

        } else {

            output.println("Employee not found");

        }

        socket.close();
        server.close();
    }
}