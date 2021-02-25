import java.io.*;

public class Fileio {


    public static void main(String[] args) throws IOException {


        File f =  new File("testfile.txt");
        FileOutputStream fos = new FileOutputStream(f,true); // append mode
        PrintWriter pw = new PrintWriter(fos);

        pw.println("Hello There Buddy");

        pw.close();
        fos.close();

        // Reading from a file
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        while (true) {

            String line = bfr.readLine();
            if (line == null){
                break;
            }
            System.out.println(line);

        }
        bfr.close();

    }
    // Try Catch
    public void trycatch (){

        File f = new File("testfile2.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);

            while (true){
            String line = null;
            line = bfr.readLine();

            if (line == null){
                break;
            }
            System.out.println(line);
        }

            bfr.close();
        }catch (IOException e ){
            e.printStackTrace();
        }


    }



}
