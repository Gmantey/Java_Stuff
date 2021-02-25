import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StockManipulator {
    // Method Read
    public static String[] readStocksFromFile(String filename) throws UnsupportedFileException {
        ArrayList<String> retString = new ArrayList<String>();
        int index = 0;
        File f = new File(filename);
        if (f.length() == 0){
            throw new UnsupportedFileException("No lines in File");
        }
        try {
            if (f.exists()) {
                FileReader fr = new FileReader(f);
                BufferedReader bfr = new BufferedReader(fr);
                while (true) {
                    String line = line = bfr.readLine();
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

    public static String[] fixReadStocks(String[] readStocks) {
        ArrayList<String> output = new ArrayList<String>();

        for (int i = 0; i < readStocks.length; i++) {
            String[] lineread = readStocks[i].split(" ");
            for (int j = i+1; j < readStocks.length; j++) {
                String[] lineread2 = readStocks[j].split(" ");

                if (lineread[0].equals(lineread2[0])) {
                  double change = Double.valueOf(lineread2[1]) + Double.valueOf(lineread[1]) ;
                  lineread[1] = String.valueOf(change);
                }
            }

            if (check(output, lineread[0])) {
                output.add(lineread[0]+" "+lineread[1]);
            }
        }

        return turnInto(output);
    }

    public static void writeFixedStocks(String[] fixedStocks, String filename) {
        File f = new File(filename);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fos); // Overwrite mod
        for (int i = 0; i < fixedStocks.length; i++) {
            pw.println(fixedStocks[i]);
        }
        pw.close();

    }

    public static boolean checkAlphabet(String x) {
        for (int i = 0; i < x.length(); i++) {
            if (!Character.isLetter(x.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean check(ArrayList<String> y, String x) {

        for (int i = 0; i < y.size(); i++) {
            String[] lineread = y.get(i).split(" ");
            if (lineread[0].equals(x)) {
                return false;
            }
        }
        return true;
    }
    public static String[] turnInto(ArrayList<String> x) {
        String [] output = new String[x.size()];

        for (int i = 0; i < x.size(); i++) {
            output[i] = x.get(i);
        }
        return output;
    }
}