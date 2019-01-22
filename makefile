JC = javac
MAKEIT = make run
P1.class:P1.java
	$(JC) P1.java
Command.class:Command.java
	$(JC) Command.java
CommandParser.class:CommandParser.java
	$(JC) CommandParser.java
Team.class:Team.java
	$(JC) Team.java
Coach.class:Coach.java
	$(JC) Coach.java
run:
	java P1
clean:
	rm *.class

it:
	$(MAKE)
	$(MAKEIT) 