import java.io.*;
import java.net.*;

public class TwoWayChatServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);

        System.out.println("===============================");
        System.out.println("          HRMS Server          ");
        System.out.println("===============================");
        System.out.println("Server Started....");
        System.out.println("Waiting for Employee....");

        Socket socket = server.accept();

        System.out.println();
        System.out.println("Employee Connected Successfully!");
        System.out.println("-------------------------------");

        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);


        // Receive message from Employee
        Thread receiveThread = new Thread(() -> {

            try {
                String message;

                while ((message = input.readLine()) != null) {

                    System.out.println();
                    System.out.println("Employee: " + message);

                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                }

            } catch (IOException e) {

                System.out.println();
                System.out.println("Employee disconnected");
            }
        });


        // Send message to Employee
        Thread sendThread = new Thread(() -> {

            try {

                BufferedReader keyboard =
                        new BufferedReader(
                                new InputStreamReader(System.in));

                String message;

                while (true) {

                    System.out.print("HR: ");

                    message = keyboard.readLine();

                    if (message == null) {
                        break;
                    }

                    output.println(message);

                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                }

            } catch (IOException e) {

                System.out.println("Error Sending message");
            }
        });


        receiveThread.start();
        sendThread.start();

        receiveThread.join();
        sendThread.join();


        socket.close();
        server.close();


        System.out.println("------------------------------------");
        System.out.println("      HRMS Chat Server Closed.      ");
        System.out.println("------------------------------------");
    }
}