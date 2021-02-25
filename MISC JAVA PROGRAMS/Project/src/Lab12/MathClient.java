package Lab12;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MathClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 4242);
        Scanner scan  = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.flush();

        System.out.println("Enter the First Value:");
        int firstNum = scan.nextInt();
        scan.nextLine();
        writer.write(firstNum);

        System.out.println("Enter the Second Value:");
        int lastNum = scan.nextInt();
        scan.nextLine();
        writer.write(lastNum);

        System.out.println("Enter the Mode:");
        int mode = scan.nextInt();
        scan.nextLine();
        writer.write(mode);
        writer.newLine();
        writer.flush();

        int answer = reader.read();
        System.out.printf("Response from the server: %d\n", answer);
        writer.close();
        reader.close();
    }
}
