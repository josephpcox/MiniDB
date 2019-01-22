import java.util.*;
import java.lang.*;
import java.io.*;

public class P1 {

    /* Define data structures for holding the data here */
    ArrayList<Coach> coaches;
    ArrayList<Team> teams;

    public P1() {
        /* initialize the data structures */
        coaches = new ArrayList<Coach>();
        teams = new ArrayList<Team>();

    }

    public boolean isInteger(String input) {
        try {

            int num = Integer.parseInt(input);
            if (num >= 0) {
                return true;

            } else {
                Exception e = new Exception();
                throw e;
            }

        }
        catch (Exception e) {
            System.out.println("A non-negartive integer must be entered here.");
            return false;
        }
    }

    public void run() {
        CommandParser parser = new CommandParser();

        System.out.println("The mini-DB of NBA coaches and teams");
        System.out.println("Please enter a command. Enter 'help' for a list of commands.");
        System.out.println();
        System.out.print("> ");

        Command cmd = null;
        while ((cmd = parser.fetchCommand()) != null) {
            //System.out.println(cmd);
            int index = 0;
            boolean result = false;

            if (cmd.getCommand().equals("help")) {
                result = doHelp();

                /* You need to implement all the following commands */
            }
            else if (cmd.getCommand().equals("add_coach")) {
                System.out.print("------------------------\n\n");
                String id = " ";
                String season = " ";
                String first_name = " ";
                String last_name = " ";
                String s_wins = " ";
                String s_loss = " ";
                String p_wins = " ";
                String p_loss = " ";
                String team = " ";
                // checking the data is correct before entering a new coach into database.
                boolean valid = true;


                try {
                    // Make sure that the alphanumeric id is call caps
                    id = cmd.getParameters()[0].toUpperCase(); // capital letters at the end
                    season = cmd.getParameters()[1];
                    first_name = cmd.getParameters()[2];
                    last_name = cmd.getParameters()[3];

                    // find the index of the '+' character returns -1 if the char is not in the string
                    index = first_name.indexOf('+');

                    // clean the + sign from the parameters last_name and first_name
                    if (index != -1) {
                        first_name = first_name.replace('+', ' ');
                    }
                    index = last_name.indexOf('+');
                    if (index != -1) {
                        last_name = last_name.replace('+', ' ');
                    }


                    s_wins = cmd.getParameters()[4];
                    s_loss = cmd.getParameters()[5];
                    p_wins = cmd.getParameters()[6];
                    p_loss = cmd.getParameters()[7];
                    team = cmd.getParameters()[8].toUpperCase(); // should be capital letters
                    // make sure that the length of the alphanumaric id is of length 6 or less


                    if (id.length() > 6) {
                        valid = false;
                        System.out.println("id character length must be less than 7, the Current Length: " + season.length() + ".");
                    }

                    // make sure that the season date is integer and is of length 4
                    if (season.length() > 4 || this.isInteger(season) == false) {
                        valid = false;
                        System.out.println("Season character length must be less than 4," + "the current character " +
                                "length: " + season.length() + ".");
                    }

                    // make sure that the seaon wins are a positve integer
                    if (this.isInteger(s_wins) == false) {
                        valid = false;
                        System.out.println("Season wins must be a positive integer.");
                    }
                    // make sure that the seaons loss is a positive integer
                    if (this.isInteger(s_loss) == false) {
                        valid = false;
                        System.out.println("Season losses must be a positive integer.");
                    }
                    // make sure that the playoff wins is a positive integer
                    if (this.isInteger(p_wins) == false) {
                        valid = false;
                        System.out.println("Playoff wins must be a positive integer.");
                    }
                    // make sure that the playoff loss is a positive integer
                    if (this.isInteger(p_loss) == false) {
                        valid = false;
                        System.out.println("Playoff losses must be a positive integer.");
                    }
                }
                catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("Caught index out of bounds exception, either too many parameters, or too few" +
                            "parameters were entered.\n Enter in the data properly. Data is staralized. New coach" +
                            " entry not allowed");
                    id = " ";
                    season = " ";
                    first_name = " ";
                    last_name = " ";
                    s_wins = " ";
                    s_loss = " ";
                    p_wins = " ";
                    p_loss = " ";
                    team = " ";
                    valid = false;
                }
                // make sure that the data is clean before creating a new coach
                if (valid == true) {
                    Coach newCoach = new Coach(id, season, first_name, last_name, s_wins, s_loss, p_wins, p_loss, team);
                    // Make sure that the new coach was successfully entered in the database
                    if (coaches.add(newCoach)) {
                        System.out.println("New coach entered successfully.");
                    }
                } else {
                    System.out.println("New Coach entery failed, try again.");
                }


            }
            else if (cmd.getCommand().equals("add_team")) {

                System.out.print("------------------------\n\n");
                String id = " ";
                String location = " ";
                String name = " ";
                String league = " ";
                boolean valid = true;
                try {
                    id = cmd.getParameters()[0];
                    location = cmd.getParameters()[1];
                    name = cmd.getParameters()[2];
                    league = cmd.getParameters()[3];
                    // Checking the data is correct before a new team is entered into the database.
                    if (id.length() > 6) {
                        System.out.println("id character length must be less than 7, the Current Length: " + id.length() + ".");
                        valid = false;
                    }

                    // find the index of the '+' character returns -1 if the char is not in the string
                    // this is to clean the + sign from the location and name parameters
                    index = location.indexOf("+");
                    if (index != -1) {
                        location = location.replace('+', ' ');
                    }

                    index = name.indexOf('+');
                    if (index != -1) {
                        name = name.replace('+', ' ');
                    }
                    if (league.length() > 1 && Character.isAlphabetic(league.charAt(0))){
                        valid = false;
                        System.out.println("Either the character is not alphabetical or League character length is too long." +
                                "league must be less than 2, the Current Length: " + id.length() + ".");
                    }


                }
                catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("Caught index out of bounds exception,either too many parmaters or too few parameters were entered." +
                            "\n Enter in the data properly. Data is staralized. New Team entry is not allowed.");
                    valid = false;
                    id = " ";
                    location = " ";
                    name = " ";
                    league = " ";
                }

                if (valid == true) {
                    Team newTeam = new Team(id, location, name, league);
                    if (teams.add(newTeam)) {
                        System.out.println("New team entered successfully.");
                    } else {
                        System.out.println("New team entry failed, try again.");
                    }
                }

            }
            else if (cmd.getCommand().equals("print_coaches")) {
                // enhanced for loop form the arraylist java class
                System.out.print("------------------------\n\n");
                for (Coach c : coaches) {
                    System.out.println((c.toString() + "\n"));
                }

            }
            else if (cmd.getCommand().equals("print_teams")) {
                System.out.print("------------------------\n\n");
                for (Team t : teams) {
                    System.out.println(t.toString() + "\n");
                }
            }
            else if (cmd.getCommand().equals("coaches_by_name")) {
                System.out.print("------------------------\n\n");
                try {
                    String coach_name = cmd.getParameters()[0];
                    index = coach_name.indexOf('+');
                    if (index != -1) {
                        // must remove the '+' from the query if it exists
                        coach_name = coach_name.replace('+', ' ');

                    }
                    // use enhance for loop to find the coach by last name
                    boolean found = false;
                    for (Coach c : coaches) {
                        if (c.getLast_name().equals(coach_name)) {
                            System.out.println(c.toString() + "\n");
                            found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("This coach is not in the database, check your spelling, or add the coach to " +
                                "the database");
                    }

                } catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("You entered too many arguments, or too few arguments for this command.");

                }

            }
            else if (cmd.getCommand().equals("teams_by_city")) {
                System.out.print("------------------------\n\n");
                try {
                    String team_city = cmd.getParameters()[0];
                    index = team_city.indexOf('+'); // remove the '+' from the query if one exists
                    if (index != -1) {
                        team_city = team_city.replace('+', ' ');
                    }
                    boolean found = false;
                    for (Team t : teams) {
                        if (t.get_location().equals(team_city)) {
                            System.out.println(t.toString());
                            found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("This city does not have a team in the database, check the spelling or add a team " +
                                "with this city to the databse");
                    }
                }
                catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("You entered too many arguments, or too few arguments for this command.");
                }

            }
            else if (cmd.getCommand().equals("load_coaches")) {
                //System.out.println(new File(".").getAbsolutePath());
                System.out.print("------------------------\n\n");
                try {
                    Scanner read = new Scanner(new File(cmd.getParameters()[0]));
                    // Make sure that there is a next to parse
                    while (read.hasNext()) {
                        // read the file line by line
                        String line = read.nextLine();
                        // strore all of the comma seperated valuse into a string array
                        String[] args = line.split(","); // remove all the commas from the input

                        // There should be 9 arguments total from 0 - 8, this will not consider any arguments past
                        // the first 9
                        //System.out.print("\n\n\n" + args[0] + "\n\n\n");
                        if (args[0].toLowerCase().equals("coachid")) {
                            continue; // skip this line becase this is not actuall data
                        }
                        Coach newCoach = new Coach(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
                        coaches.add(newCoach);
                    }
                    System.out.println("Batch load is successful.");

                }
                catch (IOException | ArrayIndexOutOfBoundsException exception) {
                    System.out.println("There was an error with reading the input file, or too many parameters were passed " +
                            "to this function.");
                    System.out.println("Make sure the file is spelled correctly, batch load failed, plase try again.");
                }

            }
            else if (cmd.getCommand().equals("load_teams")) {
                System.out.print("------------------------\n\n");
                try {
                    Scanner read = new Scanner(new File(cmd.getParameters()[0]));
                    // make sure that there is a next to parse
                    while (read.hasNext()) {
                        // read the file line by line
                        String line = read.nextLine();
                        // store all the comma seperated values into a string array
                        String[] args = line.split(",");// remove all the commas from the arguments
                        if (args[0].toLowerCase().equals("team")) {
                            continue; // the first line can then be skipped because it is not actual data
                        }

                        // There should only be 4 arguments, pass the first four into the constructor
                        Team newTeam = new Team(args[0], args[1], args[2], args[3]);
                        teams.add(newTeam);
                    }
                    System.out.println("Batch load successful");
                }
                catch (IOException | ArrayIndexOutOfBoundsException exception) {
                    System.out.println("There was an error with reading the input file, or too many parameters were passed" +
                            "to this function ");
                    System.out.println("Make sure that the file is spelled corrcetly, batch load failed.");
                }

            }
            else if (cmd.getCommand().equals("best_coach")) {

                try {
                    String seasonNum = cmd.getParameters()[0];
                    ArrayList<Coach> bestList = new ArrayList<>();

                    // put all the coahes regarding a particular season in best list
                    for (int i = 0; i < coaches.size(); i++) {
                        if (coaches.get(i).get_season().equals(seasonNum)) {
                            bestList.add(coaches.get(i));
                        }
                    }
                    // linear search for the best coach of the season
                    index = 0;
                    for (int i = 0; i < bestList.size(); i++) {
                        if (bestList.get(i).getNet_wins() > bestList.get(index).getNet_wins()) {
                            index = i;
                        }

                    }
                    System.out.println(bestList.get(index).toString());


                } catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("Too many arguments for this function.");
                    System.out.println("Make sure everything is spelled correctly");
                }

                /*TODO search_coaches*/
            }
            else if (cmd.getCommand().equals("search_coaches")) {
                String [] args = cmd.getParameters();
                ArrayList<Coach> matched_cocaches = new ArrayList<>(coaches);
                for(int i = 0; i<args.length;i++){
                    String [] params = args[i].split("=");
                    params[0] = params[0].trim();
                    params[1] = params[1].replace('+', ' ').trim();
                    for (Iterator<Coach> iterator = matched_cocaches.iterator(); iterator.hasNext(); ) {
                        Coach c = iterator.next();
                        switch (params[0]) { // we need to consider all 9 arguments
                            case "first_name": // 1
                                if (!c.getFirst_name().equals(params[1])) {
                                    iterator.remove();
                                }

                                break;

                            case "last_name": // 2
                                if (!c.getLast_name().equals(params[1])) {
                                    iterator.remove();
                                }
                                break;

                            case "season": // 3
                                if(!c.get_season().equals(params[1])) {
                                    iterator.remove();
                                }
                                 break;

                            case "Coach_ID": // 4
                                if(!c.get_id().toUpperCase().equals(params[1])) {
                                    iterator.remove();
                                }
                                break;

                            case "season_wins": // 5
                                if(!c.getSeason_win().equals(params[1])) {
                                    iterator.remove();
                                }
                                break;

                            case "season_losses": // 6
                                if(!c.getSeason_loss().equals(params[1])) {
                                    iterator.remove();
                                }
                                break;

                            case "playoff_wins": // 7
                                if(!c.getPlayoff_win().equals(params[1])) {
                                    iterator.remove();
                                }
                                break;

                            case "playoff_losses": // 8
                                if(!c.getPlayoff_loss().equals(params[1])) {
                                    iterator.remove();
                                }
                                break;

                            case "team": // 9
                                if(!c.get_team().equals(params[1])) {
                                    iterator.remove();
                                }
                                break;




                        }


                    }
                }
                for(Coach c  : matched_cocaches){
                    System.out.println(c.toString());
                }


            }
            else if (cmd.getCommand().equals("exit")) {
                System.out.println("Leaving the database, goodbye!");
                break;
            }
            else if (cmd.getCommand().equals("")) {
            }
            else {
                System.out.println("Invalid Command, try again!");
            }

            if (result) {
                // ...
            }

            System.out.print("> ");
        }
    }

    private boolean doHelp() {
        System.out.println("add_coach ID SEASON FIRST_NAME LAST_NAME SEASON_WINS ");
        System.out.println("EASON_LOSS PLAYOFF_WIN PLAYOFF_LOSS TEAM - add new coach data");
        System.out.println("add_team ID LOCATION NAME LEAGUE - add a new team");
        System.out.println("print_coaches - print a listing of all coaches");
        System.out.println("print_teams - print a listing of all teams");
        System.out.println("coaches_by_name NAME - list info of coaches with the specified name");
        System.out.println("teams_by_city CITY - list the teams in the specified city");
        System.out.println("load_coaches FILENAME - bulk load of coach info from a file");
        System.out.println("load_teams FILENAME - bulk load of team info from a file");
        System.out.println("best_coach SEASON - print the name of the coach with the most netwins in a specified season");
        System.out.println("search_coaches field=VALUE - print the name of the coach satisfying the specified conditions");
        System.out.println("exit - quit the program");
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new P1().run();
    }


}
