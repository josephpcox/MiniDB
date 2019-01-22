/**
 * @author joseph cox U00594912
 */
public class Coach {
    // instance vars
    private String id, season, first_name, last_name, season_win, season_loss, playoff_win, playoff_loss, team;
    private int netWins;

    /**
     * @param String id
     * @param String season
     * @param String first_name
     * @param String last_name
     * @param String season_win
     * @param String season_loss
     * @param String playoff_win
     * @param String playoff_loss
     * @param String team
     * @return Object-Default Constructor Takes 9 argumets total to construct object
     */
    public Coach(String id, String season, String first_name, String last_name, String season_win,
                 String season_loss, String playoff_win, String playoff_loss, String team) {
        this.id = id;                                 //1 9 arguments total + 1 calculated variable
        this.season = season;                         //2
        this.first_name = first_name;                 //3
        this.last_name = last_name;                   //4
        this.season_win = season_win;                 //5
        this.season_loss = season_loss;               //6
        this.playoff_win = playoff_win;               //7
        this.playoff_loss = playoff_loss;             //8
        this.team = team;                             //9

        this.netWins = (Integer.parseInt(this.season_win) - Integer.parseInt(this.season_loss)) + (Integer.parseInt(this.playoff_win) - Integer.parseInt(this.playoff_loss));
    }

    /**
     * @param void
     * @return String id
     */
    public String get_id() {
        return this.id;
    }

    /**
     * @param void
     * @return String season
     */
    public String get_season() {
        return this.season;
    }

    /**
     * @param void
     * @return String first_name
     */
    public String getFirst_name() {
        return this.first_name;
    }

    /**
     * @param void
     * @return String lastname
     */
    public String getLast_name() {
        return this.last_name;
    }

    /**
     * @return String season_win
     */
    public String getSeason_win() {
        return this.season_win;
    }

    public String getPlayoff_win() {
        return this.playoff_win;
    }

    /**
     * @param void
     * @return String seaon_loss
     */
    public String getSeason_loss() {
        return this.season_loss;
    }

    /**
     * @param void
     * @return String playoff_loss
     */
    public String getPlayoff_loss() {
        return this.getPlayoff_loss();
    }

    /**
     * @param void
     * @return String team
     */
    public String get_team() {
        return this.team;
    }

    /**
     * @param void
     * @return int net wins
     */
    public int getNet_wins() {
        return this.netWins;
    }

    /**
     * @return String that contains all the instince variables
     */
    public String toString() {
        return (id + "\t" + season + "\t" + first_name + "\t" + last_name + "\t" + season_win + "\t"
                + season_loss + " \t" + playoff_win + " \t" + playoff_loss + "\t" + team);
    }
}