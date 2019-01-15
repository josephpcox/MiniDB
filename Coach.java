
/**
 * @author Joseph Cox
 * 
 */
import java.util.Scanner;

public class Coach{
    private String id;
    private short season;
    private String firstName;
    private String lastName;
    private String teamName;
    private short seasonWin;
    private short seasonLoss;
    private short playoffWin;
    private short playoffLoss;

    /**
     * @param nil 
     * @return nil
     * This is a defalut constructor that will automaticly create a new coach 
     * Following System promps.
     */
    public Coach(){
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
            if(Short.valueOf(stringTemp)<0){
                System.out.println("ERROR: THE NUMBER OF WINS FOR A COACH CANNOT BE NEGATIVE");
                continue;
            }
            this.seasonWin = Short.valueOf(stringTemp);

            // number of regular season losses for the coach
            System.out.println("Enter the number of regular season losses for this coach: ");
            stringTemp = scan.nextLine();
            if(Short.valueOf(stringTemp)<0){
                System.out.println("ERROR: THE NUMBER OF LOSSES FOR A COACH CANNOT BE NEGATIVE");
                continue;
            }
            this.seasonLoss = Short.valueOf(stringTemp);

            // number of playoff wins for the coach 
            System.out.println("Enter the number of playoff wins for this coach: ");
            stringTemp = scan.nextLine();
            if(Short.valueOf(stringTemp)<0){
                System.out.println("ERROR: THE NUMBER OF PLAYOFF WINS FOR A COACH CANNOT BE NEGATIVE");
                continue;
            }
            this.playoffWin = Short.valueOf(stringTemp);

            // playoff losses for the coach
            System.out.println("Enter the number of playoff losses for this coach: ");
            stringTemp = scan.nextLine();
            if(Short.valueOf(stringTemp)<0){
                System.out.println("ERROR: THE NUMBER OF PLAYOFF LOSSES FOR A COACH CANNOT BE NEGATIVE");
                continue;
            }
            this.playoffLoss = Short.valueOf(stringTemp);
            valid = true;
            
        }
    }

    /**
     * @return String id this returns the id of the coach.
     */
    public String getID(){
        return this.id;
    }
    /**
     * 
     * @return short season this returns the 4 digit year of the season.
     */
    public short getSeason(){
        return this.season;
    }
    /**
     * 
     * @return String firstName this returns the first name of the coach.
     */
    public String getFirstName(){
        return this.firstName;
    }
    /**
     * 
     * @return String lastName this returns the last name of the coach.
     */
    public String getLastName(){
        return this.lastName;
    }
    /**
     * 
     * @return String teamName this returns the name of the team of the coach. 
     */
    public String teamName(){
        return this.teamName;
    }
    /**
     * 
     * @return short seasonWin this returns the total wins for the coach.
     */
    public short getSeasonWin(){
        return this.seasonWin;
    }
    /**
     * 
     * @return short seasonLoss this returns the total losses for the coach. 
     * 
     */
    public short getSeasonLoss(){
        return this.seasonLoss;
    }
    /**
     * 
     * @return short playoffWin this returns the total number of playoff wins for the coach.
     */
    public short getPlayoffWin(){
        return this.playoffWin;
    }
    /**
     * 
     * @return short playoffLoss this returns the total number of playoff loss for the coach.
     */
    public short getPlayoffLoss(){
        return this.playoffLoss;
    }
    /**
     * @return String this method puts all of the variables in a single string with spaces
     *         and no new lines.
     * TODO add commas to the toString method
     */
    public String toString(){
        return this.id + "," +this.season +","+ this.firstName +","+ this.lastName + "," + 
               this.teamName + "," + this.seasonWin + ","+ this.seasonLoss + "," + this.playoffWin +
               this.playoffLoss;  
    }

}