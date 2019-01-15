
/**
 * @author Joseph Cox
 * 
 */
import java.util.Scanner;

public class Coach{
    private String id;
    private int season;
    private String firstName;
    private String lastName;
    private String teamName;
    private int seasonWin;
    private int seasonLoss;
    private int playoffWin;
    private int playoffLoss;
    private int netWins;

    /**
     * @param String this is to make it not a defalut constructor
     * @return void
     * This is a defalut constructor that will automaticly create a new coach 
     * Following System promps.
     */
    public Coach(String purpose){
        Scanner scan = new Scanner(System.in);
        String stringTemp;
        boolean valid = false;

        // data validation 
        while(valid == false){

            // id
            System.out.println("Enter ID: ");
            stringTemp = scan.nextLine();
            if(stringTemp.length()>=7){
                System.out.print("ERROR: ID MUST BE LESS THAN SIX CHARACTERS LONG, TRY AGAIN.");
                continue;
            }
            this.id = stringTemp;
            
            // year of the season
            System.out.println("Enter the four digit year of the season: ");
            stringTemp = scan.nextLine();
            if(stringTemp.length()>4){
                System.out.println("ERROR: THE SEASON MUST A FOUR DIGIT YEAR, TRY AGAIN. ");
                continue;
            }
            this.season = Short.valueOf(stringTemp);
            
            // coaches first name
            System.out.println("Enter the first name of the coach: ");
            this.firstName = scan.nextLine();

            // coaches last name 
            System.out.println("Enter the last name of the coach: ");
            this.lastName = scan.nextLine();

            // team of the coach
            System.out.println("Enter the name of the team: ");
            this.teamName = scan.nextLine();

            // number of regular seasons wins for the coach 
            System.out.println("Enter the number of regular season wins for this coach: ");
            stringTemp = scan.nextLine();
            if(Integer.valueOf(stringTemp)<0){
                System.out.println("ERROR: THE NUMBER OF WINS FOR A COACH CANNOT BE NEGATIVE");
                continue;
            }
            this.seasonWin = Short.valueOf(stringTemp);

            // number of regular season losses for the coach
            System.out.println("Enter the number of regular season losses for this coach: ");
            stringTemp = scan.nextLine();
            if(Integer.valueOf(stringTemp)<0){
                System.out.println("ERROR: THE NUMBER OF LOSSES FOR A COACH CANNOT BE NEGATIVE");
                continue;
            }
            this.seasonLoss = Short.valueOf(stringTemp);

            // number of playoff wins for the coach 
            System.out.println("Enter the number of playoff wins for this coach: ");
            stringTemp = scan.nextLine();
            if(Integer.valueOf(stringTemp)<0){
                System.out.println("ERROR: THE NUMBER OF PLAYOFF WINS FOR A COACH CANNOT BE NEGATIVE");
                continue;
            }
            this.playoffWin = Integer.valueOf(stringTemp);

            // playoff losses for the coach
            System.out.println("Enter the number of playoff losses for this coach: ");
            stringTemp = scan.nextLine();
            if(Integer.valueOf(stringTemp)<0){
                System.out.println("ERROR: THE NUMBER OF PLAYOFF LOSSES FOR A COACH CANNOT BE NEGATIVE");
                continue;
            }
            this.playoffLoss = Short.valueOf(stringTemp);
            this.netWins = (this.seasonWin+this.playoffWin) - (this.seasonLoss + this.playoffLoss);
            valid = true;
            
        }
    }
    /**
     * @param void
     * @return void
     * Default Constructor 
     */
    public Coach(){    
    }

    /**
     * @param void
     * @return String id this returns the id of the coach.
     */
    public String getID(){
        return this.id;
    }
    /**
     * @param void
     * @return short season this returns the 4 digit year of the season.
     */
    public int getSeason(){
        return this.season;
    }
    /**
     * @param void
     * @return String firstName this returns the first name of the coach.
     */
    public String getFirstName(){
        return this.firstName;
    }
    /**
     * @param void
     * @return String lastName this returns the last name of the coach.
     */
    public String getLastName(){
        return this.lastName;
    }
    /**
     * @param void
     * @return String teamName this returns the name of the team of the coach. 
     */
    public String getTeamName(){
        return this.teamName;
    }
    /**
     * @param void
     * @return short seasonWin this returns the total wins for the coach.
     */
    public int getSeasonWin(){
        return this.seasonWin;
    }
    /**
     * @param void
     * @return short seasonLoss this returns the total losses for the coach. 
     * 
     */
    public int getSeasonLoss(){
        return this.seasonLoss;
    }
    /**
     * @param void
     * @return short playoffWin this returns the total number of playoff wins for the coach.
     */
    public int getPlayoffWin(){
        return this.playoffWin;
    }
    /**
     * 
     * @return short playoffLoss this returns the total number of playoff loss for the coach.
     */
    public int getPlayoffLoss(){
        return this.playoffLoss;
    }
    /**
     * @param void 
     * @return shor the amount of net wins a coach has (season wins + playoff wins) - (season loss + playoff loss) 
     */
    public int getNetWins(){
        return this.netWins;
    }
    /**
     * @return String this method puts all of the variables in a single string with spaces
     *         and no new lines.
     * 
     */
    public String toString(){
        return this.id + "," +this.season +","+ this.firstName +","+ this.lastName + "," + 
               this.teamName + "," + this.seasonWin + ","+ this.seasonLoss + "," + this.playoffWin +
               this.playoffLoss;  
    }
    /**
     * 
     * @param toCopy This is the coach object that a deep copy is to be made from
     * @return void
     */
    public void deepCopy(Coach toCopy){
        this.id = toCopy.getID();
        this.season = toCopy.getSeason();
        this.firstName = toCopy.getFirstName();
        this.lastName = toCopy.getLastName();
        this.teamName = toCopy.getTeamName();
        this.seasonWin = toCopy.getSeasonWin();
        this.seasonLoss = toCopy.getSeasonLoss();
        this.playoffWin = toCopy.getPlayoffWin();
        this.playoffLoss = toCopy.getPlayoffLoss();
        
    }

}