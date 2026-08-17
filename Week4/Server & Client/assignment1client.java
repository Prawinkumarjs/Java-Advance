import java.io.*;
import java.net.*;

public class assignment1client {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);

        // Send Employee ID
        output.println("EMP1001");

        // Receive complete response
        String response;

        System.out.println("HRMS Server Response:");

        while ((response = input.readLine()) != null) {
            System.out.println(response);
        }

        socket.close();
    }
}