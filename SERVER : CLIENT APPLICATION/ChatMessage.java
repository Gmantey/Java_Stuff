import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project 5 -- Simple Chat Server
 *
 * @author Godfred Mantey , L01
 * @author Huy Pham, L01
 * @version April 27, 2020
 */

final class ChatMessage implements Serializable {
    private static final long serialVersionUID = 6898543889087L;
    // Here is where you should implement the chat message object.
    // Variables, Constructors, Methods, etc.
    private String message;
    private String recipient;
    private int type;

    public ChatMessage(String message, int type, String recipient) {
        this.type = type;
        this.recipient = recipient;
        this.type = type;
    }

    // Test Constructor

    public ChatMessage(String message) {
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss");
        ChatFilter chatFilter = new ChatFilter("badwords.txt");
        String newmessage = chatFilter.filter(message); // Filtered the words before broadcasting it

        this.message = newmessage + " [" + dateFormatter.format(date) + "]";
    }

    // Getter Methods
    public String getMessage() {
        return message;
    }

    public int getType() {
        if (message.contains("/logout")) {
            type = 1;
        } else if (message.contains("/msg")) {
            type = 2;
        } else if (message.contains("/list")) {
            type = 3;
        } else {
            type = 0;
        }
        return type;
    }

    public String getRecipient() {
        if (message.contains("/msg")) {
            String[] elements = getMessage().split(" ");
            recipient = elements[1];
        }
        return recipient;
    }
}
//version2.0