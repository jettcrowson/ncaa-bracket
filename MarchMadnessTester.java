public class MarchMadnessTester{  

    private static int runs = 1000000;

    public static void main(String[] args){
        MarchMadness tourney = new MarchMadness();
        Team[][] teams = tourney.getTeams();
    
        for(int i = 0; i < runs; i++){
            Team winner = tourney.play();
            for(int x = 0; x < 4; x++){
                for(int n = 0; n < 16; n++){
                    if(teams[x][n] == winner){
                        teams[x][n].win(6);
                    }
                }
            }
        }

        for(int x = 0; x < 4; x++){
            for(int n = 0; n < 16; n++){
                System.out.println(teams[x][n].getName() + ": " + " | " + teams[x][n].getWins(1) + " | " + teams[x][n].getWins(2) + " | " + teams[x][n].getWins(3) + " | " + teams[x][n].getWins(4) + " | " + teams[x][n].getWins(5) + " | " + teams[x][n].getWins(6));
            }
            System.out.println("\n");
        }
    
    }
}