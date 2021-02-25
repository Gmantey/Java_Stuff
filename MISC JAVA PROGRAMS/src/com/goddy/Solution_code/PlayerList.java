package com.goddy.Solution_code;

/*
-	Create an Arraylist of players objects who have their first name, last name
 teams,number of championships and position.

 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerList {

    public static void main(String[] args) throws IOException {

        ArrayList <Player> playerslist = new ArrayList<>();

        File f = new File("Playerlist.txt");
        if (f.exists()){
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            while (true){
                String line = bfr.readLine();
              
                if (line == null)
                    break;
                String[] playerread = line.split(" ", 5);

                Player player = new Player(playerread[0],playerread[1],
                        playerread[2], Integer.parseInt(playerread[3]) , playerread[4]);

                playerslist.add(player);
            }
        }

    }
}
