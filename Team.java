public class Team{
    
    private String name;
    private double power;
    private int seed;
    private int[] wins = new int[]{0,0,0,0,0,0};

    public Team(String team){

        String[] teamInfo = team.split(",");
        this.name = teamInfo[0];
        this.power = Double.parseDouble(teamInfo[1]);
        this.seed = Integer.parseInt(teamInfo[2]);

    }

    public String getName(){
        return name;
    }

    public double getPower(){
        return power;
    }

    public int getSeed(){
        return seed;
    }

    public int getWins(int round){
        return wins[round - 1];
    }

    public void win(int round){
        wins[round - 1] += 1;
    }

}