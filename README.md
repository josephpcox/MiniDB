# Joseph Cox Mini Database project 1/21/18

---
# mini-DB Commands
## mini-DB Command Format
1. **add_coach** < 6 digit season id > <4 digit year>< first name > < last name> < season losses > < team > -adds a coach to the System if and only if all 9 arguments are correctly formatted. 
2. **add_team** < 6 digit team id > < Location > < team name > < League >
3. **load_coaches** < file name >
4. **load_teams** < file name>
5. **print_coaches** no arguments needed
6. **print_teams** no arguments needed
7. **coaches_by_name** < last name>
8. **teams_by_city** < city name>
9. **best_coach** < 4 digit season year>
10. **search_coaches** < filed = input > < filed=input > multiple inputs in this format are accepted

## mini-DB Command Definitions

1. **add_coach**: add a new record describing the performance of one coach in one season. It should have the following 9 arguments: ID SEASON FIRST_NAME LAST_NAME SEASON_WIN SEASON_LOSS PLAYOFF_WIN PLAYOFF_LOSS TEAM. When successful the command prompt will output: **New coach entered successfully** if the names are two words or more use the '+' operator to chain the names together such as <Van+Gundy>. This will result in Van Gundy

2. **add_team**: add a new record with one team's basic information. It should be followed by the following 4 arguments: ID, LOCATION, NAME, and LEAGUE. When successful the command prompt will output: **New team entered successfully** if the name of the location is two words or more use the plus operator to chain the names together such as <New+York>, this will result in New York. 

3. **load_coaches** : bulk load of multiple coach/season records from a file specified by the only argument of the command. Note that the file stores each record in one line of text, and different fields of the line/record are separated by commas. In our sample files, you may find empty attribute values.

4. **load_teams** : bulk load of multiple team records from a file specified by the only argument of the command. Records in such files are organized in the same way as in those for load_coaches.

5. **print_coaches**: print a list of all coaches, with info about one coach's performance in one season in a line;

6. print_teams: print a list of all teams, with info about one team per line;

7. **coaches_by_name** : print the information of coach(es) with the specified last name, which is given by the only argument of this command;

8. **teams_by_city** : print the information of teams in the city specified by the only argument;

9. **best_coach**: print the name of the coach who has the most net wins in a season specified by the only argument. Note that the net wins should be calculated as (season_win - season_loss) + (playoff_win - playoff_loss).

10. **search_coaches**: print the info of coaches with the specified properties, which are given by the arguments in the following format: field=VALUE where field represents the name of a search criterion and 'VALUE' is the value of that field you want the query results to match. Multiple fields can be used in the same query. For example, a command "search_coaches first_name=John season_win=40" means "finding all performance data of a coach with first name 'John' who had a seasonal win of 40". Note that a meaningful field should match exactly one of the column names in the coaches table (just ignore those that do not match any column names). **Note: when chaning fields with playoff_loss and playoff_win it is entered as: *playoff_wins* and *playoff_losses* as well as season_wins and season_losses*. For more detail look at line *383 - 487 of P1.java**


---

# mini-DB Attribute Definitions

## Coaches
1. *Coach_ID* : consists of less than 7 capital letters and two digits
2. *4 digit year*
3. *first_name* : any reasonable English name
4. *last_name* : any reasonable English name
5. *season_win* : non-negative integer
6. *season_loss* : non-negative integer
7. *playoff_win* : non-negative integer
8. *playoff_loss* : non-negative integer
9. *team* : capital letters and/or digits

## Teams
1. team_ID : capital letters and/or digits
2. Location : American City name, one or two English word(s)
3. Name : team name, any reasonable English word
4. League : one capital letter



---
# Make File and Execution

1. **make it** - This comand will compile and run the program
2. **make** -This command will just compile the code 
3. **make run** - This will run the program only if the progam is already compiled.
4. **make clean** - This command will remove all of the .class files in the folder.


### Note: You can compile the code and run it calling the java compiler. **javac P1.java** to compile and **java P1** to run it, however a makefile is provided for convineance.

---
# Files 

## Java Files

1. Coach.java - Java Class that contains methods for the Coach object.
2. Team.java - Java Class that contains methods for the Team object.
3. Command.java - Container class that holds the code for an individual command.
4. CommandParser.java - Contains methods for parsing string commands.
5. P1.java - Creates a P1 object with two ArrayList data structures teams which are of type Team and coaches which are of type Coach.

## Input Files

1. coaches.txt - Contains a list of coaches to be loaded to the database.

2. teams.txt -contains a list of teams to be added to the database.

## Documentation Files

There are 4 document files all with the same information. I recommend opening the README.html, if for some reason that an html file cannot be viewed. There is a README.md a README.pdf and a README.txt that are exact copies of what is in the README.html. 


