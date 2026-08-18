package Week4.Chat;
import java.io.*;
import java.net.*;

// public class ChatClient {
//     public static void main(String[] args) throws Exception{
//         Socket socket = new Socket("localhost",5000);
//         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//         PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
//         BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//         while (true) {
//             System.out.print("Employee: ");
//             String messsage = keyboard.readLine();
//             if(messsage.equalsIgnoreCase("exits")){
//                 break;
//             }
//             String reponse = input.readLine();
//             System.out.println(reponse);
//         }
//         socket.close();
//     }
    
// }



public class ChatClient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        BufferedReader input =
                new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

        PrintWriter output =
                new PrintWriter(socket.getOutputStream(), true);

        BufferedReader keyboard =
                new BufferedReader(
                        new InputStreamReader(System.in));

        while (true) {

            System.out.print("Employee: ");
            String message = keyboard.readLine();

            if (message.equalsIgnoreCase("exit")) {
                output.println("exit");
                break;
            }

            // Send message to server
            output.println(message);

            // Receive HR response
            String response = input.readLine();

            System.out.println(response);
        }

        socket.close();
    }
}