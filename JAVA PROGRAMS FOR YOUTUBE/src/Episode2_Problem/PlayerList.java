package Episode2_Problem;

import java.io.*;
import java.util.ArrayList;

public class PlayerList {
    ArrayList <Player> plylist = new ArrayList<>();

    public void readPlayer () throws IOException {

        // Reading from the file
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
                Player player = new Player(playerRead[0], playerRead[1],playerRead[2],
                        Integer.parseInt(playerRead[3]), playerRead[4]);
                // Add the player Object to the playerList

                plylist.add(player);
            }
            bfr.close();
        }

    }
    public void positionAllstar (String c) throws IOException {

        File nf = new File("Players.txt");
        FileOutputStream fos = new FileOutputStream(nf); // Overwrite mode
        PrintWriter pw = new PrintWriter(fos);

        for (int i = 0; i < plylist.size(); i++){
            if (plylist.get(i).getPosition().equals(c)){
                pw.println(plylist.get(i).getFirstname() + " "
                        + plylist.get(i).getLastname());
                plylist.remove(i);
            }
        }
        pw.close();
        fos.close();

    }
    public void championships (){

        for (int i = 0; i < plylist.size(); i++){
            if (plylist.get(i).getNbaChampcount() > 6){
                System.out.println(plylist.get(i).getFirstname() + " "
                        + plylist.get(i).getLastname());
            }
        }



    }

    public ArrayList<Player> getPlylist() {
        return plylist;
    }

    public void setPlylist(ArrayList<Player> plylist) {
        this.plylist = plylist;
    }
}
