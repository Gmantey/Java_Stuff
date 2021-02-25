package Example4;

import java.io.*;
import java.util.ArrayList;

public class PlayerList {
    // field
    ArrayList <Player> plylist = new ArrayList<>();

    // read from file
    public void readPlayer () throws IOException {

        File f = new File("nbaPlayers.txt");
        if (f.exists()){

            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);

            // Read line by line
            while (true){
                String line = bfr.readLine();
                if (line == null){
                    break;
                }
                String [] playerRead = line.split(" ", 5);

                Player player = new Player(playerRead[0], playerRead[1], playerRead[2],
                        Integer.parseInt(playerRead[3]), playerRead[4]);

                // Add the player Object to the playerList

                plylist.add(player);
            }
            bfr.close();
        }

    }
    public void championships (){

        for (int i = 0; i < plylist.size(); i++){

            if (plylist.get(i).getNbaChampcount() > 7){
                System.out.println(plylist.get(i).getFirstname() + " " + plylist.get(i).getLastname());
            }
        }

    }

    public void positionAllStar (String c) throws IOException {

        File nf = new File("Players.txt"); // will create the file if it does not exist
        FileOutputStream fos = new FileOutputStream(nf); // Overwrite mode
        PrintWriter pw = new PrintWriter(fos);

        for (int i = 0; i < plylist.size(); i++){

            if (plylist.get(i).getPosition().equals(c)){
                pw.println(plylist.get(i).getFirstname() + " " + plylist.get(i).getLastname());

                // Remove player
                plylist.remove(i); // requires an index
            }

        }

        pw.close();
        fos.close();

    }
    // Getters and Setters

    public ArrayList<Player> getPlylist() {
        return plylist;
    }

    public void setPlylist(ArrayList<Player> plylist) {
        this.plylist = plylist;
    }
}
