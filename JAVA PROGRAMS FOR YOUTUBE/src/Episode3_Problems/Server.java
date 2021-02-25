package Episode3_Problems;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4242);
        System.out.println("Waiting for a client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Make the buffered reader and writer
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        writer.flush();

        String message = reader.readLine();
        System.out.println("Received from client: " + message);
        String response = message.replaceAll(",", "_");
        writer.write(response);

        writer.newLine();
        writer.flush();

        System.out.println("Sent to the client: " + response);
        writer.close();
        reader.close();

    }

}
