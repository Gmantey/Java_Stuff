import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4242);
        Scanner scan = new Scanner(System.in);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        writer.flush();
        System.out.println("What do you want to send to the server?: ");
        String response = scan.nextLine();

        writer.write(response);
        writer.newLine();
        writer.flush();


        System.out.println("Sent to server: " + response);
        String s1 = reader.readLine();
        System.out.println("Received from Server: " + s1);
        writer.close();
        reader.close();
    }
}
