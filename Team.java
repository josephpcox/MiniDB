import java.util.Scanner;

public class Team{
    private String id;
    private String location;
    private String name;
    private char league;

    /**
     * This is the empty constructor, it validates the id to have less then 7 characters 
     * and it sets all of the class instance vaiables.
     */
    public Team(){
        String temp;
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        while(valid == false){
            // validate to the specs given in the assignemnt.
            System.out.println("Enter ID:");
            temp = scan.nextLine();
            if(temp.length()>=7){
                System.out.print("ERROR: ID MUST BE LESS THAN SIX CHARACTERS LONG, TRY AGAIN.");
                continue;
            }
            this.id = temp.toUpperCase();

            System.out.println("Enter Location:");
            this.location = scan.nextLine();

            System.out.println("Enter Name");
            this.name = scan.nextLine();

            System.out.println("Enter League");
            
            // this reads in the next character of the scan next line
            this.league = scan.nextLine().charAt(0);
            valid = true;
            System.out.print("Team was sucessfully added");
        }

    }
    /**
     * 
     * @return String id returns the coaches ID.
     */
    public String getID(){
        return this.id;
    }
    /**
     * 
     * @return String location this returns the location of the team.
     */
    public String getLocation(){
        return this.location;
    }

    /**
     * 
     * @return String name this returns the team's name.
     */
    public String getName(){
        return this.name;
}

    /**
     * 
     * @return char this returns the character representing the league.
     */
    public char getLeague(){
        return this.league;
    }
    /**
     * @return String this returns the string of all the instance variables seperated by
     *         a comma.
     */
    public String toString(){
        return this.id + "," + this.location + "," + this.name + "," + this.league;
    }
}