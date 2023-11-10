import javax.naming.NamingEnumeration;

public class Dungeon {
    private int dungeonFloor;
    private int whatHappensNext;
    private int nextEvent;
    public Dungeon(){
        dungeonFloor = 1;
    }

    public void nextFloor(){
        dungeonFloor++;
    }

    public int determineNextEvent() {
        whatHappensNext = (int) (Math.random() * 11);
        if (dungeonFloor % 5 == 0) {
            nextEvent = 1;
        } else if (whatHappensNext >= 0 && whatHappensNext <= 6) {
            nextEvent = 2;
        } else if (whatHappensNext > 6 && whatHappensNext <= 9) {
            nextEvent = 3;
        } else {
            nextEvent = 4;
        }
        return nextEvent;
    }


    public int getDungeonFloor(){return dungeonFloor;}
}
