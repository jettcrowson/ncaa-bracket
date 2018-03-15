import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader{

    public Team[][] readTeams(String path){

        Team[] teams = new Team[64];
        Team[][] split = new Team[4][16];

        try{
            
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            int i = 0;
            int teamIndex = 0;

            while((readLine = b.readLine()) != null){
                if(!(i == 0 || i == 17 || i == 18 ||  i == 35 || i == 36 || i == 53 || i == 54)) {
                    teams[teamIndex] = new Team(readLine);
                    teamIndex++;
                }
                i++;
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        for(int i = 0; i < 4; i++){
            int w = 0;
             for(int x = 0 + (16 * i); x < 16 + (16 * i); x++){
                 split[i][w] = teams[x];
                 w++;
             }
        }

        return split;

    }

}