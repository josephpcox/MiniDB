/**
 * @author Jospeh Cox
 * 1/19/19
 */
public class Team {
    private String id, location, name, league;

    /**
     * @param location
     * @param name
     * @param league
     * @return Team Object-Create a team object
     */
    public Team(String id, String location, String name, String league) {
        this.id = id;
        this.location = location;
        this.name = name;
        this.league = league;

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
     * @return String location
     */
    public String get_location() {
        return this.location;
    }

    public String get_name() {
        return this.name;
    }

    /**
     * @param void
     * @return String league
     */
    public String get_league() {
        return this.league;
    }

    /**
     * @param void
     * @return a string contains all the instance variables
     */
    public String toString() {
        return this.id + " " + this.location + "  " + this.name + "  " + this.league;
    }


}