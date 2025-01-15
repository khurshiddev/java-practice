package chapter_17;

import java.util.ArrayList;
import java.util.List;

public class FootballTeamTask {
    public static void main(String[] args) {
        Coach coach1 = new Coach("shevchenka", 5, "faqat olg'a");
        Coach coach2 = new Coach("Babayaga", 3, "faqat orga");
        Team team1 = new Team("Paxtakor", coach1);
        Team team2 = new Team("Bunyodkor", coach2);

        Player player1 = new Player("1","sssss","12");
        Player player2 = new Player("2","qqqqq","7");
        Player player3 = new Player("3","wwwww","22");
        Player player4 = new Player("4","eeeeee","31");

        Match match1 = new Match(team1, team2);
        match1.recordGoal("Paxtakot","sssss");
        match1.recordGoal("Paxtakot","sssss");
        match1.recordGoal("Paxtakot","qqqqq");
        match1.recordGoal("Bunyodkor","eeeeee");
        match1.recordGoal("Bunyodkor","eeeeee");
//        match1.recordGoal("Bunyodkor","qqqqq");

        System.out.println(match1.getMatchResult());
    }
}

class Player {
    private String id;
    private String name;
    private String position;
    private int goals;
    private int assists;

    public Player(String id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.goals = 0;
        this.assists = 0;
    }

    public void scoreGoal() {
        ++goals;
    }

    public String getId() {
        return id;
    }

    public void giveAssist() {
        ++assists;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", goals=" + goals +
                ", assists=" + assists +
                '}';
    }
}

// Coach Class
class Coach {
    private String name;
    private int experience;
    private String strategy;

    public Coach(String name, int experience, String strategy) {
        this.name = name;
        this.experience = experience;
        this.strategy = strategy;
    }

    public void changeStrategy(String newStrategy) {
        this.strategy = newStrategy;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", strategy='" + strategy + '\'' +
                '}';
    }

}

// Team Class
class Team {
    private String name;
    private List<Player> players;
    private Coach coach;

    public Team(String name, Coach coach) {
        this.name = name;
        this.players = new ArrayList<>();
        this.coach = coach;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerId) {
        players.removeIf(player -> player.getId().equals(playerId));
    }
//    List<Player> getPlayers(){
//        return players;
//    }

    public void listPlayers() {
        System.out.println(players);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                ", coach=" + coach +
                '}';
    }
}

// Match Class
class Match {
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    List<Player> playersList;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        playersList = new ArrayList<>();
    }


    public void recordGoal(String teamName, String playerId) {
        if (homeTeam.getName().equals(teamName)) {
            homeScore++;
            for (Player player : playersList) {
                if (player.getId().equals(playerId)) {
                    player.scoreGoal();
                    return;
                }
            }
        } else if (awayTeam.getName().equals(teamName)) {
            awayScore++;
            for (Player player : playersList) {
                if (player.getId().equals(playerId)) {
                    player.scoreGoal();
                    return;
                }
            }
        }
    }


    public String getMatchResult() {
        if (homeScore > awayScore) {
            System.out.println("Home Team Wins");
        } else if (homeScore < awayScore) {
            System.out.println("Away Team Wins");
        } else if (homeScore == awayScore) {
            System.out.println("Draw");
        }
        return "";
    }


}


