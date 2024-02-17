import java.util.Arrays;
public class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;
    //Constructors
    public BlueAstronaut (String name) {
        this(name,15,6,10);
    }
    public BlueAstronaut (String name,int susLevel, int numTasks, int taskSpeed){
        super(name,susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }
    public void emergencyMeeting() {
        if (super.isFrozen()) 
        return;
        else {
                Player[] players = getPlayers();
                Arrays.sort(players);
                int maxfirst = players.length-1;
                while ( players[maxfirst].isFrozen()) {
                    maxfirst--;
                }
                int maxsecond = maxfirst-1;
                while ( players[maxsecond].isFrozen()) 
                    {// not final
                    maxsecond--;
                }
                if (players[maxfirst].getSusLevel() != players[maxsecond].getSusLevel()) {
                    players[maxfirst].setFrozen(true);
                    }
        }
        super.gameOver();
    }
    int count = 0;
    public void completeTask() {
        if (this.isFrozen())
        return;
        else {
        if (this.taskSpeed > 20)
        this.numTasks -=2;
        else
        this.numTasks -=1;
        
        if (this.numTasks <= 0) {
        this.numTasks = 0;
            count ++;
        }
        
        if (this.numTasks == 0 && count == 1)  {
        System.out.println("I have completed all my tasks");
        super.setSusLevel((int)(super.getSusLevel()/2));
        }
        }
    }
    public boolean equals(Object o) {
        if (super.equals(o)) {
            BlueAstronaut player = (BlueAstronaut) o;
            return this.numTasks == player.numTasks && this.taskSpeed == player.taskSpeed;
        }
        return false;
    }
    public String toString() {
        String statement = super.toString() + " I have " + this.numTasks + " left over.";
        if(this.getSusLevel() > 15) {
        	return statement.toUpperCase();
        } else {
        	return statement;
            }
    }
    public int getNumTasks() {
        return numTasks;
    }
    public void setNumTasks ( int newnumtasks ) {
        this.numTasks = newnumtasks;
    }
    public int getTaskSpeed() {
        return taskSpeed;
    }
    public void setTaskSpeed ( int newtaskSpeed ) {
        this.taskSpeed = newtaskSpeed;
    }
}
