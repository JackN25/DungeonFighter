public class Dungeon {
    /**
     * Determines the next event in the dungeon
     * @param dungeonFloor represents the floor the character is on
     * @param whatHappensNext represents the randomized number to check what the next event is
     * @param nextEvent represents the next event
     */
    private int dungeonFloor;
    private int whatHappensNext;
    private int nextEvent;
    public Dungeon(){
        /**
         * Creates an instance of dungeon and sets dungeonFloor to zero
         */
        dungeonFloor = 0;
    }

    public void nextFloor(){
        /**
         * Increments dungeonFloor after the user has cleared the previous floor
         */
        dungeonFloor++;
    }

    public int determineNextEvent() {
        /**
         * Randomizes a number and then uses that number to determine the next event
         * @returns the next event
         */
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
