import java.util.*;
import java.io.*;

public class P1 {
	
    /* Define data structures for holding the data here */
    Vector<Coach> coachList;
    Vector<Team> teamList;
    
    public P1() {
    }
  
    /**
     * 
     * @param i int index you want to find the left child for
     * @return integer that represents the index of the left child 
     */
    public int getLeftChild(int i){
        return (2 * i +1);
    }
    /**
     * 
     * @param i int index you want to find the right child for
     * @return integer that represents the index of the right child 
     */
    public int getRightChild(int i){
        return (2 * i + 2);
    }
    /**
     * 
     * @param coach x
     * @param coach y 
     * Swap the contents of the two coaches 
     */
    public void swapChildren(Coach x, Coach y){
        Coach temp = new Coach();
        temp.deepCopy(x);
        x.deepCopy(y);
        y.deepCopy(x);

    }
    /**
     * 
     * @param pos position idex
     * @return boolean, returns true is the given index is a leaf
     */
    public boolean isLeaf(int pos){
        int size = coachList.size();
        if(pos >=(size/2)&& pos <= size) return true;
        return false;
    }

    public void maxHeapify(int pos){
        if(this.isLeaf(pos)) return;

        if(coachList.get(pos).getNetWins()< coachList.get(this.getLeftChild(pos)).getNetWins()
        || coachList.get(pos).getNetWins()< coachList.get(this.getRightChild(pos)).getNetWins()){

            if(coachList.get(this.getLeftChild(pos)).getNetWins()>coachList.get(this.getRightChild(pos)).getNetWins()){
                this.swapChildren(coachList.get(pos), coachList.get(this.getLeftChild(pos)));
                this.maxHeapify(this.getLeftChild(pos));
            }
            else{
                this.swapChildren(coachList.get(pos),coachList.get(this.getRightChild(pos)));
            }
        }
        
    }
    
    public void run() {
        CommandParser parser = new CommandParser();
        this.coachList = new Vector<>();
        this.teamList = new Vector<>();
        System.out.println("The mini-DB of NBA coaches and teams");
        System.out.println("Please enter a command.  Enter 'help' for a list of commands.");
        System.out.println();
        System.out.print("> "); 
        Scanner scan = new Scanner(System.in);
        Command cmd = null;
        String name = " ";
        int index = 0;
        int i = 0; // counter for the loops 

        while ((cmd = parser.fetchCommand()) != null) {
            //System.out.println(cmd);
            
            boolean result=false;
            
            if (cmd.getCommand().equals("help")) {
                result = doHelp();

		    /* You need to implement all the following commands */
            } 
            else if (cmd.getCommand().equals("add_coach")) {
                Coach newCoach = new Coach("To add a new coach to the vecor");
                this.coachList.add(newCoach);
                this.maxHeapify(0); // maxheapify starting at the root;
                
            } 
            else if (cmd.getCommand().equals("add_team")) {
                Team newTeam = new Team();
                this.teamList.add(newTeam);
        	
            } 
            else if (cmd.getCommand().equals("print_coaches")) {
                for(i = 0; i<this.coachList.size();i++){
                    System.out.println(this.coachList.get(i).toString());
                }
            } 
            else if (cmd.getCommand().equals("print_teams")) {
                for(i = 0; i<teamList.size();i++){
                    System.out.println(this.teamList.get(i).toString());
                }

            } 
            else if (cmd.getCommand().equals("coaches_by_name")) {
                name = scan.next();
                index = name.indexOf('+');
                if(index!=-1){
                    name = name.replace('+', ' ');
                }
                else{
                    for(i = 0; i<this.coachList.size();i++){
                        if(name.equals(this.coachList.get(i).getLastName())){
                            System.out.println(this.coachList.get(i).toString());
                        }
                    }

                }

            } 
            else if (cmd.getCommand().equals("teams_by_city")){
                name = scan.next();
                index = name.indexOf('+');
                if(index != -1){
                    name = name.replace('+', ' ');
                }
                else{
                    for(i = 0; i<this.teamList.size();i++){
                        if(name.equals(this.teamList.get(i).getName())){
                            System.out.println(this.teamList.get(i).getName());
                        }
                    }

                }
            } 
            else if (cmd.getCommand().equals("load_coaches")){

            } 
            else if (cmd.getCommand().equals("load_teams")){
		
            } 
            else if (cmd.getCommand().equals("best_coach")){
                 System.out.println(this.coachList.get(0).toString()); // best coach should be at the root of the vector 
                                                                      // due to maxheapify being called after every entry
            } 
            else if (cmd.getCommand().equals("search_coaches")){

            } 
            else if (cmd.getCommand().equals("exit")){
			    System.out.println("Leaving the database, goodbye!");
			    break;
            } 
            else if (cmd.getCommand().equals("")){
            } 
            else {
			    System.out.println("Invalid Command, try again!");
           	} 
            
	        if (result){
                    // ...
            }

            System.out.print("> "); 
        }        
    }
    
    private boolean doHelp() {
        System.out.println("add_coach ID SEASON FIRST_NAME LAST_NAME SEASON_WIN "); 
	    System.out.println("SEASON_LOSS PLAYOFF_WIN PLAYOFF_LOSS TEAM - add new coach data");
        System.out.println("add_team ID LOCATION NAME LEAGUE - add a new team");
        System.out.println("print_coaches - print a listing of all coaches");
        System.out.println("print_teams - print a listing of all teams");
        System.out.println("coaches_by_name NAME - list info of coaches with the specified name");
        System.out.println("teams_by_city CITY - list the teams in the specified city");
	    System.out.println("load_coach FILENAME - bulk load of coach info from a file");
        System.out.println("load_team FILENAME - bulk load of team info from a file");
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
