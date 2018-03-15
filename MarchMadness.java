public class MarchMadness{

        private Reader reader = new Reader();
        private Team[][] teams = reader.readTeams("./ncaa_data_2018.csv");

    public Team[][] getTeams(){
        return teams;
    }

    public Team[][] round1(){

        Team[][] winners = new Team[4][8];

        for(int i = 0; i < 4; i++){
            for(int x = 0; x < 8; x++){
                Team team1 = teams[i][x];
                Team team2 = teams[i][teams[i].length - 1 - x];
                winners[i][x] = playGame(team1, team2) ? team1 : team2;
                winners[i][x].win(1);
            }
        }

        return winners;

    }

    public Team[][] round2(){

        Team[][] newTeams = round1();
        Team[][] winners = new Team[4][4];

        for(int i = 0; i < 4; i++){
            for(int x = 0; x < 4; x++){
                Team team1 = newTeams[i][x];
                Team team2 = newTeams[i][newTeams[i].length - 1 - x];
                winners[i][x] = playGame(team1, team2) ? team1 : team2;
                winners[i][x].win(2);
            }
        }

        return winners;

    }

    public Team[][] round3(){

        Team[][] newTeams = round2();
        Team[][] winners = new Team[4][2];

        for(int i = 0; i < 4; i++){
            for(int x = 0; x < 2; x++){
                Team team1 = newTeams[i][x];
                Team team2 = newTeams[i][newTeams[i].length - 1 - x];
                winners[i][x] = playGame(team1, team2) ? team1 : team2;
                winners[i][x].win(3);
            }
        }

        return winners;

    }

    public Team[] round4(){

        Team[][] newTeams = round3();
        Team[] winners = new Team[4];

        for(int i = 0; i < 4; i++){
                Team team1 = newTeams[i][0];
                Team team2 = newTeams[i][1];
                winners[i] = playGame(team1, team2) ? team1 : team2;
                winners[i].win(4);
        }

        return winners;

    }

    public Team[] round5(){

        Team[] newTeams = round4();
        Team[] winners = new Team[2];

        for(int i = 0; i < 2; i++){
            Team team1 = newTeams[i];
            Team team2 = newTeams[newTeams.length - 1 - i];
            winners[i] = playGame(team1, team2) ? team1 : team2;
            winners[i].win(5);
        }

        return winners;

    }

    public Team play(){

        Team[] newTeams = round5();

        return playGame(newTeams[0], newTeams[1]) ? newTeams[0] : newTeams[1];

    }

    public boolean playGame(Team opponent1, Team opponent2){
        
        double power1 = opponent1.getPower();
        double power2 = opponent2.getPower();
        double odds = 1 / (1 + Math.pow(10,-(power1 - power2)*30.464/400));
        double rand = Math.random();
        return rand <= odds ? true : false; 

    }
}
