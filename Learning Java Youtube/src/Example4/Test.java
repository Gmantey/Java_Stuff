package Example4;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        PlayerList playerList = new PlayerList();
        playerList.readPlayer();
        playerList.championships();

    }


}
