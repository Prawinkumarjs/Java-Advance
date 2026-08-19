import java.io.*;
import java.net.*;

public class TwoWayChatClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        System.out.println("=======================================");
        System.out.println("           HRMS Chat Client");
        System.out.println("=======================================");
        System.out.println("Connected to HRMS Chat Server");
        System.out.println("---------------------------------------");


        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);


        // Receive message from HR
        Thread receiveThread = new Thread(() -> {

            try {

                String message;

                while ((message = input.readLine()) != null) {

                    System.out.println();
                    System.out.println("HR: " + message);

                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                }

            } catch (IOException e) {

                System.out.println();
                System.out.println("Server Disconnected");
            }
        });


        // Send message to HR
        Thread sendThread = new Thread(() -> {

            try {

                BufferedReader keyboard =
                        new BufferedReader(
                                new InputStreamReader(System.in));

                String message;

                while (true) {

                    System.out.print("Employee: ");

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


        System.out.println("------------------------------------");
        System.out.println("      HRMS Client Chat Closed.      ");
        System.out.println("------------------------------------");
    }
}