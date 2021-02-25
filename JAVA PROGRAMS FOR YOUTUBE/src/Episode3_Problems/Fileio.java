package Episode3_Problems;

import java.io.*;

public class Fileio {


    public static void main(String[] args) throws IOException {

        File f = new File("testfile.txt");
        FileOutputStream fos = new FileOutputStream(f);
        PrintWriter pw = new PrintWriter (fos);
        pw.println("Hello there");
        pw.close();
        fos.close();

        // Reading from file
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        while (true) {
            String line = bfr.readLine();
            if (line == null)
                break;
            System.out.println(line);
        }
        bfr.close();


    }

    public void trycatch (){
        File f = new File("testfile.txt");
        FileReader fr = null;

        try {
            fr = new FileReader(f);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader bfr = new BufferedReader(fr);

        while (true) {
            String line = null;
            try {
                line = bfr.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (line == null)
                break;
            System.out.println(line);
        }

        try {
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
