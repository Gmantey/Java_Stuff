package com.goddy.MISC;

import java.util.Scanner;
import java.io.*;

public class TextEditor {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


    }

    public int Greetings(String filename) throws IOException {
        int option = 0;
        File f = new File(filename);
            if (f.exists()) {
                System.out.println("The file " + filename + " currently contains the following:");
                FileReader fr = new FileReader(f);
                BufferedReader bfr = new BufferedReader(fr);
                System.out.println("------------");
                // Reads the File
                while (true) {
                    String line = bfr.readLine();
                    if (line == null)
                        break;
                    System.out.println(line);
                }
                bfr.close();
                System.out.println("------------");
                System.out.printf("Which edit mode would you like?\n1. Overwrite\n2. Append\n");
                 option = input.nextInt();
                input.nextLine();

            } else {
                System.out.println("Sorry the file you entered does not exist!");
            }

        return option;

    }
    public void mode (int option, File f) throws FileNotFoundException {

        System.out.printf("How many lines would you like to write?\n");
        int lines = input.nextInt();
        input.nextLine();

        if (option == 1) {
            // Overwrite
            FileOutputStream fos = new FileOutputStream(f); // Overwrite mode

            System.out.printf("Please enter " + lines + " line(s):\n");
            // Writes to
            PrintWriter pw = new PrintWriter(fos);

            for (int i = 0; i < lines; i++) {
                pw.println(input.nextLine());
            }
            pw.close();
        } else if (option == 2){
            FileOutputStream fos = new FileOutputStream(f , true);
            System.out.printf("Please enter " + lines + " line(s):\n");
            // Writes to File
            PrintWriter pw = new PrintWriter(fos);
            for (int i = 0; i < lines; i++) {
                pw.println(input.nextLine());
            }
            pw.close();
        }
    }

    public void filecontents (File f, String filename) throws IOException {
        System.out.println("The file " + filename + " now contains:");
        System.out.println("------------");
        // Reads the File
        FileReader fr2 = new FileReader(f);
        BufferedReader bfr2 = new BufferedReader(fr2);
        while (true) {
            String line = bfr2.readLine();
            if (line == null)
                break;
            System.out.println(line);
        }
        bfr2.close();
        System.out.println("------------");
        System.out.println("Thank you for using the program!");
    }

}