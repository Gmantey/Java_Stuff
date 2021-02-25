import java.io.*;
import java.util.ArrayList;

/**
 * Project 5 -- Simple Chat Server
 *
 * @author Godfred Mantey , L01
 * @author Huy Pham, L01
 * @version April 27, 2020
 */
public class ChatFilter {
    ArrayList<String> words = new ArrayList<>();

    public ChatFilter(String badWordsFileName) {
        File f = new File(badWordsFileName);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            // Reads the File
            while (true) {
                String line = bfr.readLine();
                if (line == null)
                    break;
                words.add(line);
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String filter(String msg) {

        String[] word = msg.split(" ");
        String complete = "";
        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < words.size(); j++) {
                // implement the editing
                if (word[i].toLowerCase().equals(words.get(j).toLowerCase())) {
                    word[i] = replace(word[i].length());
                }
            }
        }
        for (int i = 0; i < word.length; i++) {
            complete += word[i] + " ";
        }
        //return complete.trim();
        return complete.trim();
    }

    public String replace(int length) {
        String len = "";
        for (int i = 0; i < length; i++) {
            len += "*";
        }
        return len;
    }

    public ArrayList<String> getWords() {
        return words;
    }
}
//version2.0