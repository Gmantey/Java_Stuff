import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Project 5 -- Simple Chat Server
 *
 * @author Godfred Mantey , L01
 * @version April 27, 2020
 */
final class ChatClient {
    private ObjectInputStream sInput;
    private ObjectOutputStream sOutput;
    private Socket socket;

    private final String server;
    private final String username;
    private final int port;

    private ChatClient(String server, int port, String username) {
        this.server = server;
        this.port = port;
        this.username = username;
    }

    /*
     * This starts the Chat Client
     */
    private boolean start() {
        //ChatMessage chatMessage = new ChatMessage();
        // Create a socket
        try {
            socket = new Socket(server, port);
        } catch (IOException e) {
            System.out.println("Server is offline");
        }

        // Create your input and output streams
        try {
            sInput = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());

        } catch (IOException | NullPointerException e) {
            System.out.println("Goodbye!");
        }
        // Send the UserName
        try {
            sOutput.flush();
            sOutput.writeObject(username);
        } catch (IOException | NullPointerException e) {
            System.out.println("Please wait until the server opens!");
        }

        // This thread will listen from the server for incoming messages
        Runnable r = new ListenFromServer();
        Thread t = new Thread(r);
        t.start();

        return true;
    }


    /*
     * This method is used to send a ChatMessage Objects to the server
     */
    private void sendMessage(ChatMessage msg) {
        try {
            sOutput.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * To start the Client use one of the following command
     * > java ChatClient
     * > java ChatClient username
     * > java ChatClient username portNumber
     * > java ChatClient username portNumber serverAddress
     *
     * If the portNumber is not specified 1500 should be used
     * If the serverAddress is not specified "localHost" should be used
     * If the username is not specified "Anonymous" should be used
     */
    public static void main(String[] args) {
        // Get proper arguments and override defaults
        String username = "Anonymous";
        int port = 1500;
        String serverAddress = "localhost";

        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                username = args[0];
            }
            if (i == 1) {
                port = Integer.parseInt(args[1]);
            }
            if (i == 2) {
                serverAddress = args[2];
            }
        }
        // Create your client and start it
        ChatClient client = new ChatClient(serverAddress, port, username);
        client.start();

        // Send an empty message to the server

        Scanner in = new Scanner(System.in);

        while (true) {
            String message = in.nextLine();
            ChatMessage ms = new ChatMessage(message);
            client.sendMessage(ms);
        }

    }


    /**
     * This is a private class inside of the ChatClient
     * It will be responsible for listening for messages from the ChatServer.
     * ie: When other clients send messages, the server will relay it to the client.
     *
     * @author Godfred Mantey , L01
     * @author Huy Pham, L01
     * @version April 27, 2020
     */
    private final class ListenFromServer implements Runnable {
        public void run() {
            try {
                while (true) {
                    String msg = null;
                    msg = (String) sInput.readObject();
                    System.out.println(msg);
                }
            } catch (IOException | ClassNotFoundException | NullPointerException e) {
                System.out.println("Successfully logged out");
            }
        }
    }
}
//version2.0