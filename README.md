# NCAA BRACKET 2018

Predict the 2018 NCAA Men's Basketball Tournament.

## Data

The data analysts at [FiveThirtyEight](http://fivethirtyeight.com/) have crunched the numbers and determined a **Power Rating** for every team in the tournament this year. This number is an estimation of the strength of a given team, and we can use a formula to predict what percentage of the time a team will win over another team. The teams, power ratings, regions, and seeds are located in `ncaa_data_2018.csv`.

## Predicting the Tournament

Your job is to determine the chances for each team to win the entire tournament. You will use a [Monte Carlo Simulation](http://www.solver.com/monte-carlo-simulation-overview#What_is_Monte_Carlo_Simulation) of the tournament, basically by simulating each of the 63 games based on the team power ratings lots and lots of times and collecting the results.

### Setting up the Bracket

Open `bracket_2018.pdf`. Make sure to set up the initial state of the tournament correctly. Teams are separated into one of 4 regions: East, West, South, and Midwest. Each of the teams in a region is given a seed. The lower the seed, the better the team (usually). The teams are pitted based on their seed, a 1 seed always plays a 16 seed first, and then would play the winner of the 8 vs. 9 seed matchup, and so on. You must carefully set up your program to create these specific matchups and not others. The winners of each region meet in the Final Four, with the South playing the West and the East playing the Midwest. The winners of those two games then play for the National Championship.

### Predicting a Game

To determine the odds of Team A winning a game against Team B you can use a formula based on the two teams' power ratings `PRa` and `PRb`: 

![Winning Percentage](https://braceyourself.io/public/img/wp_ab.gif)

`WPab` will be a number in the range [0, 1]. To determine the winner of a game in a given turn of the simulation compare this number to a random number `r`. If `r` is <= `WPab` then Team A wins the game. Otherwise Team B wins the game. For example, if Team A would beat Team B 75% of the time, the random number 0.3676376 would predict a win by Team A and the random number .818228 would predict a win by Team B. This process will result in Team A winning approximately 75% of the simulated matchups with Team B.

### Challenge

Generate a formatted html file with your predictions for each team in a table. 