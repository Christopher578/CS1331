
public class Gameplay {
    public static void main(String[] args) {
        BlueAstronaut[] players1 = {
            new BlueAstronaut("Bob",20,6,30),
            new BlueAstronaut("Heath",30,3,21),
            new BlueAstronaut("Albert",44,2,0),
            new BlueAstronaut("Angel",0,1,0)
        };
        RedAstronaut[] players2 = {
            new RedAstronaut("Liam",19,"experienced"),
            new RedAstronaut("Suspicious Person",100,"expert")
        };
        players2[0].sabotage(players1[0]);//Bob should have: susLevel = 30, frozen = false
        System.out.println(players1[0].getSusLevel());
        players2[0].freeze(players2[1]); //Nothing should happen
        System.out.println(players2[1].isFrozen());
        players2[0].freeze(players1[2]); //Albert is now frozen
        System.out.println(players1[2].isFrozen());
        players1[2].emergencyMeeting(); //Nothing should happen since he is frozen
        players2[1].emergencyMeeting(); //This will result in a tie between Bob and Heath, so nothing should happen
        System.out.println(players1[0].isFrozen());
        System.out.println(players1[1].isFrozen());
        players1[0].emergencyMeeting(); //Suspicious Person should have: frozen = true
        System.out.println(players2[1].isFrozen());
        players1[1].completeTask(); //Heath should have: numTasks = 1
        System.out.println(players1[1].getNumTasks());
        players1[1].completeTask();  //“I have completed all my tasks” should be printed to console, Heath should have: numTasks = 0, susLevel = 15
        System.out.println(players1[1].getNumTasks());
        System.out.println(players1[1].getSusLevel());
        players1[1].completeTask();  //Nothing should happen
        System.out.println(players1[1].getNumTasks());
        players2[0].freeze(players1[3]); //Angel should have: frozen = false, Liam should have: susLevel = 38
        System.out.println(players1[3].isFrozen());
        System.out.println(players2[0].getSusLevel());
        players2[0].sabotage(players1[0]);
        System.out.println(players1[0].getSusLevel());
        players2[0].sabotage(players1[0]);//Bob should have: susLevel = 46 (30 -> 37 -> 46)
        System.out.println(players1[0].getSusLevel());
        players2[0].freeze(players1[0]); //Bob should have: frozen = true
        System.out.println(players1[0].isFrozen());
        players1[3].emergencyMeeting(); //Liam should have: frozen = true,"Crewmates win!" should be printed to console
        System.out.println(players2[0].isFrozen());
    }
}
