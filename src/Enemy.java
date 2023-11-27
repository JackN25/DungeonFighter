import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Enemy {
    /**
     * An enemy object is something that the user has to control their character to fight to progress in the game
     * @param enemyHealth represents the enemy's hp
     * @param enemyAttack represents the enemy's attack power
     * @param enemyName represents the name of the enemy
     */
    private double difficultyMulti;
    private int dungeonFloor;
    private double enemyHealth;
    private double enemyAttack;
    private String enemyName;

    /**
     * Constructor for the Enemy class
     * Creates an enemy with attributes based on the dungeon floor and difficulty multipliers
     * @param difficultyMulti is the multiplier for the enemy health and attack to make the game harder.
     * @param dungeonFloor represents what floor the player is on
     */
    public Enemy(double difficultyMulti, int dungeonFloor) {

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        this.difficultyMulti = difficultyMulti;
        this.dungeonFloor = dungeonFloor;
        int enemyChooser = (int) (1 + (Math.random() * 3));
        if (dungeonFloor % 5 == 0) {
            if (enemyChooser == 1) {
                enemyName = "Goblin King (BOSS)";
                enemyHealth = Double.parseDouble(df.format(150 * difficultyMulti * (dungeonFloor / 5.0)));
                enemyAttack = Double.parseDouble(df.format(20 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3)));
            } else if (enemyChooser == 2) {
                enemyName = "Slime Queen (BOSS)";
                enemyHealth = Double.parseDouble(df.format(175 * difficultyMulti * (dungeonFloor / 5.0)));
                enemyAttack = Double.parseDouble(df.format(15 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3)));
            } else {
                enemyName = "Giant Golem (BOSS)";
                enemyHealth = Double.parseDouble(df.format(200 * difficultyMulti * (dungeonFloor / 5.0)));
                enemyAttack = Double.parseDouble(df.format(10 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3)));
            }

        } else {
            if (enemyChooser == 1) {
                enemyName = "Goblin";
                enemyHealth = Double.parseDouble(df.format(25 * difficultyMulti * (dungeonFloor * 0.2)));
                enemyAttack = Double.parseDouble(df.format(10 * difficultyMulti * (dungeonFloor * 0.3)));
            } else if (enemyChooser == 2) {
                enemyName = "Slime";
                enemyHealth = Double.parseDouble(df.format(35 * difficultyMulti * (dungeonFloor / 5.0)));
                enemyAttack = Double.parseDouble(df.format(7 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3)));
            } else {
                enemyName = "Golem";
                enemyHealth = Double.parseDouble(df.format(40 * difficultyMulti * (dungeonFloor / 5.0)));
                enemyAttack = Double.parseDouble(df.format(5 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3)));
            }
        }
    }

    /**
     * Creates a special enemy (chest mimic) with attributes based on dungeon floor and difficulty multipliers
     * @param difficultyMulti is the multiplier for the enemy health and attack to make the game harder.
     * @param dungeonFloor represents what floor the player is on
     * @param name represents the name of the enemy which in this case is always Chest mimic
     */
    public Enemy(double difficultyMulti, int dungeonFloor, String name) {
        this.difficultyMulti = difficultyMulti;
        this.dungeonFloor = dungeonFloor;
        enemyName = "Chest Mimic";
        enemyHealth = 25 * difficultyMulti * (dungeonFloor * 0.2);
        enemyAttack = 10 * difficultyMulti * (dungeonFloor * 0.3);
    }

    /**
     * Calculates the amount of damage the enemy will deal towards the character
     * @return the damage the enemy will do
     */
    public double enemyAttack() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        double damageDealt;
        int attackType = (int) (1 + Math.random() * 4);
        if (attackType == 1) {
            damageDealt = enemyAttack;
        } else if (attackType == 2) {
            damageDealt = enemyAttack * 1.2;
        } else if (attackType == 3){
            damageDealt = enemyAttack * 0.75;
        }else {
            damageDealt = 0;
        }

        return Double.parseDouble(df.format(damageDealt));
    }

    /**
     * Subtracts enemy health based on how much damage taken
     * @param damageTaken the amount of damage the enemy will take
     */
    public void updateEnemyHealth(double damageTaken){
        enemyHealth = enemyHealth - damageTaken;
    }

    public String getEnemyName() {
        return enemyName;
    }
    public double getEnemyHealth(){
        return enemyHealth;
    }
}
