package com.goddy.Homework7;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Homework 7 - SearchEngine
 * <p>
 * Handles the reading and writing of the correct roster
 *
 * @author Godfred Mantey, LO1
 * @version March 9, 2020
 */
public class SearchEngine {
    public static void main(String[] args) throws UnsupportedRosterException, FileNotFoundException, IOException {

        String inputFile;
        String outputFile;
        Scanner input = new Scanner(System.in);
        ArrayList<Player> player = new ArrayList<Player>();
        PlayerList playerList = new PlayerList(player);

        // Prompts the user for the nae of the input and output files
        System.out.println("Please enter the name of the input file:");
        inputFile = input.nextLine();
        System.out.println("Please enter the name of the output file:");
        outputFile = input.nextLine();

        playerList = readFile(inputFile);
        player = findPlayer(playerList);
        writeFile(player, outputFile);
    }

    static PlayerList readFile(String fileName) throws UnsupportedRosterException, FileNotFoundException, IOException {
        ArrayList<Player> playerfound = new ArrayList<Player>();
        File f = new File(fileName);
        int[] positioncheck = new int[5];
        if (f.exists()) {
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            while (true) {
                String line = bfr.readLine();
                if (line == null)
                    break;
                String[] playerline = line.split(" ", 10);
                String[] skill = playerline[playerline.length - 1].split(",");
                ArrayList<String> skills = new ArrayList<String>();

                for (int i = 0; i < skill.length; i++) {
                    skills.add(skill[i]);
                }
                positioncheck = checkroster(playerline[2], positioncheck);

                if (Integer.parseInt(playerline[3]) > 100 || Integer.parseInt(playerline[4]) > 100 ||
                        Integer.parseInt(playerline[5]) > 100 || Integer.parseInt(playerline[6]) > 100 ||
                        Integer.parseInt(playerline[7]) > 100 || Integer.parseInt(playerline[8]) > 100) {
                    throw new UnsupportedRosterException("Range is too big");
                }
                Player player = new Player(playerline[0], playerline[1],
                        playerline[2], Integer.parseInt(playerline[3]),
                        Integer.parseInt(playerline[4]),
                        Integer.parseInt(playerline[5]), Integer.parseInt(playerline[6]),
                        Integer.parseInt(playerline[7]),
                        Integer.parseInt(playerline[8]), skills);
                playerfound.add(player);
            }
            bfr.close();
        } else {
            throw new UnsupportedRosterException(""); // Changed it from a file not found Exception
        }
        if (positioncheck[0] == 0 || positioncheck[1] == 0 || positioncheck[2] == 0
                || positioncheck[3] == 0 || positioncheck[4] == 0) {
            throw new UnsupportedRosterException("Not all position in file");
        }
        PlayerList playerList = new PlayerList(playerfound);
        return playerList;
    }

    static int[] checkroster(String position, int[] positioncheck) {

        switch (position) {

            case "PG":
                positioncheck[0]++;
                break;
            case "SG":
                positioncheck[1]++;
                break;
            case "SF":
                positioncheck[2]++;
                break;
            case "PF":
                positioncheck[3]++;
                break;
            case "C":
                positioncheck[4]++;
                break;
        }
        return positioncheck;
    }

    static ArrayList<Player> findPlayer(PlayerList list) {
        ArrayList<Player> playerfound = new ArrayList<Player>();
        playerfound.add(list.findPG());
        playerfound.add(list.findSG());
        playerfound.add(list.findSF());
        playerfound.add(list.findPF());
        playerfound.add(list.findC());
        return playerfound;
    }

    static void writeFile(ArrayList<Player> startup, String output) throws IOException,
            UnsupportedRosterException {

        File f = new File(output);
        FileOutputStream fos = new FileOutputStream(f);
        PrintWriter pw = new PrintWriter(fos); // Overwrite mode
        for (int i = 0; i < 5; i++) {
            pw.println(startup.get(i).getFirstName() + " "
                    + startup.get(i).getLastName() + " " +
                    startup.get(i).getPosition() + " " +
                    startup.get(i).getTotalAttribute());
        }
        pw.close();

    }
}




