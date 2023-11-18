import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Enemy {
    private double difficultyMulti;
    private int dungeonFloor;
    private double enemyHealth;
    private double enemyAttack;
    private String enemyName;


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
                enemyHealth = 35 * difficultyMulti * (dungeonFloor / 5.0);
                enemyAttack = 7 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3);
            } else {
                enemyName = "Golem";
                enemyHealth = 40 * difficultyMulti * (dungeonFloor / 5.0);
                enemyAttack = 5 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3);
            }
        }
    }


    public Enemy(double difficultyMulti, int dungeonFloor, String name) {
        this.difficultyMulti = difficultyMulti;
        this.dungeonFloor = dungeonFloor;
        enemyName = "Chest Mimic";
        enemyHealth = 25 * difficultyMulti * (dungeonFloor * 0.2);
        enemyAttack = 10 * difficultyMulti * (dungeonFloor * 0.3);
    }

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
