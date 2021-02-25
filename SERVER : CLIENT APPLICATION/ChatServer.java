import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Project 5 -- Simple Chat Server
 *
 * @author Godfred Mantey , L01
 * @version April 27, 2020
 */
@SuppressWarnings("ALL")
final class ChatServer {
    private static int uniqueId = 0;
    private final List<ClientThread> clients = new ArrayList<>();
    private final int port;

    // updated the constructor
    private ChatServer(int port) {
        this.port = port;
    }

    /*
     * This is what starts the ChatServer.
     * Right now it just creates the socketServer and adds a new ClientThread to a list to be handled
     */
    private void start() {

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                Runnable r = new ClientThread(socket, uniqueId++);
                Thread t = new Thread(r);
                clients.add((ClientThread) r);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
     *  > java ChatServer
     *  > java ChatServer portNumber
     *  If the port number is not specified 1500 is used
     */
    public static void main(String[] args) {
        int portNum = 0;
        if (args.length == 1) {
            portNum = Integer.parseInt(args[0]);
        }
        ChatServer server = new ChatServer(portNum); // Included the textfile name
        System.out.println("=============");
        System.out.println("Server Online!");
        System.out.println("=============");
        server.start();
    }


    /**
     * This is a private class inside of the ChatServer
     * A new thread will be created to run this every time a new client connects.
     *
     * @author Godfred Mantey , L01
     * @version April 27, 2020
     */
    private final class ClientThread implements Runnable {
        Socket socket;
        ObjectInputStream sInput;
        ObjectOutputStream sOutput;
        int id;
        String username;
        ChatMessage cm;

        private ClientThread(Socket socket, int id) {
            this.id = id;
            this.socket = socket;
            try {
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                sInput = new ObjectInputStream(socket.getInputStream());
                username = (String) sInput.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        /*
         * This is what the client thread actually runs.
         */
        @Override
        public void run() {
            // Read the username sent to you by client
            System.out.println(username + " has logged in");
            try {
                sOutput.writeObject("=============");
                sOutput.writeObject("Welcome to the chat server");
                sOutput.writeObject("=============");

            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {

                try {
                    cm = (ChatMessage) sInput.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

                if (cm.getType() == 1) {
                    try {
                        broadcast(username + " " + this.id  + " has logged out");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    close();
                    remove_client(this.id);
                    break;
                } else if (cm.getType() == 0) {
                    try {
                        broadcast(username + ": " + cm.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (cm.getType() == 2) {
                    String message2 = cm.getMessage().replaceAll(cm.getRecipient(), "");
                    message2 = message2.replaceAll("/msg", "");
                    message2 = message2.trim();
                    directMessage(cm.getRecipient(), message2);
                } else if (cm.getType() == 3) {
                    writeMessage("Currently connected users:");
                    for (int i = 0; i < clients.size(); i++) {
                        if (clients.get(i).username.equals(this.username)) {
                            continue;
                        }
                        writeMessage(clients.get(i).username);
                    }
                }
            }
        }

        // WriteMessage Method
        private boolean writeMessage(String message) {
            if (!socket.isConnected()) {
                return false;
            } else {
                try {
                    sOutput.flush();
                    sOutput.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        // Close Method
        private void close() {
            try {
                sOutput.flush();
                sOutput.close();
                sInput.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void directMessage(String username1, String message) {
            // Client cannot send a message to themselves
            while (username1.equals(this.username)) {
                writeMessage("You can't direct message yourself! Please try again!");
                return;
            }

            for (int i = 0; i < clients.size(); i++) {
                if (username1.equals(clients.get(i).username)) {
                    clients.get(i).writeMessage(this.username + ": " + message);
                    writeMessage(this.username + ": " + message);
                    System.out.println(this.username + ": " + message);
                    break;
                }
            }
        }
    }

    // Broadcast Method
    private synchronized void broadcast(String message) throws IOException {

        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).writeMessage(message);
        }
        System.out.println(message);

    }

    // Remove Method
    private synchronized void remove_client(int id) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).id == id) {
                clients.remove(clients.get(i));
            }
        }
        return;
    }
}
//version2.0
