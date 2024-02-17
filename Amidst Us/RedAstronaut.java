
import java.util.Arrays;
public class RedAstronaut extends Player implements Impostor {
    private String skill;
    //constructor
    public RedAstronaut( String name ) {
        this(name,15,"experienced");
    }
    public RedAstronaut( String name, int susLevel, String skill) {
        super(name,susLevel);
        this.skill = skill;
    }
    public void emergencyMeeting() {
        if (super.isFrozen()) 
        return;
        else {
                Player[] players = getPlayers();
                Arrays.sort(players);
                int maxfirst = players.length-1;
                while ( players[maxfirst].isFrozen() || super.equals(players[maxfirst])) {
                    maxfirst--;
                }
                int maxsecond = maxfirst-1;
                while ( maxsecond >= 0 && players[maxsecond].isFrozen()) 
                    {// not final
                    maxsecond--;
                }
                if (maxsecond < 0 || players[maxfirst].getSusLevel() != players[maxsecond].getSusLevel()) {
                    players[maxfirst].setFrozen(true);
                }

        }
        super.gameOver();
    }
    public void freeze(Player p) {
        if (p instanceof Impostor || super.isFrozen() || p.isFrozen())
        return;
        else {
        if (super.compareTo(p) < 0) // not final
        p.setFrozen(true);
        else
        super.setSusLevel(super.getSusLevel()*2);
        super.gameOver();
        }
    }
    public void sabotage(Player p) {
        if (p instanceof Impostor || super.isFrozen() || p.isFrozen())
        return;
        else {
        double increasePercentage = super.getSusLevel() < 20 ? 0.5 : 0.25;
        int newSusLevel = (int) (p.getSusLevel() * (1 + increasePercentage));
        p.setSusLevel(newSusLevel);
        }
    }
    public boolean equals(Object o) {
        if (super.equals(o)) {
            RedAstronaut player = (RedAstronaut) o;
            return this.getSkill() == player.getSkill();
        }
        return false;
    }
    public String toString() {
        String statement = super.toString() + " I am an " + this.skill + " player!";
        if(this.getSusLevel() > 15) {
        	return statement.toUpperCase();
        } else {
        	return statement;
            }
    }
    public String getSkill() {
        return skill;
    }
    public void setSkill(String newskill) {
        this.skill = newskill;
    }
}
