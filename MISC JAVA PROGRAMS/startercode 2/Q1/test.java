import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws UnsupportedFileException {
        String[] answer = readStocksFromFile("fixed1.txt");
        for (int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }
    public static String[] readStocksFromFile(String filename) throws UnsupportedFileException {
        ArrayList<String> retString = new ArrayList<String>();
        int index = 0;
        File f = new File(filename);
        try {
            if (f.exists()) {
                FileReader fr = new FileReader(f);
                BufferedReader bfr = new BufferedReader(fr);
                while (true) {
                    String line = bfr.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] lineread = line.split(" ");
                    if (lineread.length > 2) {
                        throw new UnsupportedFileException("Too Many Words");
                    }
                    if (lineread[0].length() > 4 || checkAlphabet(lineread[0])) {
                        System.out.println(lineread[0] + checkAlphabet(lineread[0]));
                        throw new UnsupportedFileException("Incorrect Stock Name");
                    }
                    retString.add(line);
                }
                bfr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return turnInto(retString);
    }

    public static boolean checkAlphabet (String x){
        for (int i = 0; i < x.length(); i++) {
            if (!Character.isLetter(x.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static String[] turnInto(ArrayList<String> x) {
        String [] output = new String[x.size()];

        for (int i = 0; i < x.size(); i++) {
            output[i] = x.get(i);
        }
        return output;
    }
}