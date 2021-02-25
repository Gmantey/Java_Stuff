package Lab12;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4242);
        System.out.println("Waiting for the client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.flush();

        int firstnum = reader.read();
        int secondnum = reader.read();
        int mode = reader.read();
        int answer = 0;

        switch (mode){
            case 1: answer = firstnum + secondnum;
                break;
            case 2: answer = firstnum - secondnum;
                break;
            case 3: answer = firstnum * secondnum;
                break;
            case 4: answer = firstnum / secondnum;
                break;
        }
        writer.write(answer);
        writer.newLine();
        writer.flush();
        writer.close();
        reader.close();


    }
}
