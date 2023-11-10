public class Enemy {
    private double difficultyMulti;
    private int dungeonFloor;
    private double enemyHealth;
    private double enemyAttack;
    private String enemyName;

    public Enemy(double difficultyMulti, int dungeonFloor) {
            this.difficultyMulti = difficultyMulti;
            this.dungeonFloor = dungeonFloor;
        int enemyChooser = (int) (1 + (Math.random() * 3));
        if (dungeonFloor % 5 == 0) {
            if (enemyChooser == 1) {
                enemyName = "Goblin King (BOSS)";
                enemyHealth = 500 * difficultyMulti * (dungeonFloor / 5.0);
                enemyAttack = 50 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3);
            } else if (enemyChooser == 2) {
                enemyName = "Slime Queen (BOSS)";
                enemyHealth = 750 * difficultyMulti * (dungeonFloor / 5.0);
                enemyAttack = 30 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3);
            } else {
                enemyName = "Giant Golem (BOSS)";
                enemyHealth = 1000 * difficultyMulti * (dungeonFloor / 5.0);
                enemyAttack = 40 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3);
            }

        } else {
            if (enemyChooser == 1) {
                enemyName = "Goblin";
                enemyHealth = 25 * difficultyMulti * (dungeonFloor * 0.2);
                enemyAttack = 10 * difficultyMulti * (dungeonFloor * 0.3);
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
        enemyName = "Goblin";
        enemyHealth = 25 * difficultyMulti * (dungeonFloor * 0.2);
        enemyAttack = 10 * difficultyMulti * (dungeonFloor * 0.3);
    }

    public double enemyAttack() {
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
        return damageDealt;
    }

    public String getEnemyName() {
        return enemyName;
    }
}
