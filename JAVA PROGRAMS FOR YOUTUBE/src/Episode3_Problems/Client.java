package Episode3_Problems;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 4242);
        Scanner scan = new Scanner(System.in);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        write.flush();

        System.out.printf("What do you want to send to the server?: ");
        String response = scan.nextLine();

        write.write(response);
        write.newLine();
        write.flush();

        System.out.println("Sent to server: " + response);
        String s1 = reader.readLine();
        System.out.println("Received from Server: " + s1);
        write.close();
        reader.close();

    }
}
