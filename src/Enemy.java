public class Enemy {
    private double difficultyMulti;
    private int dungeonFloor;
    private double enemyHealth;
    private double enemyAttack;
    private String enemyName;

    public Enemy(int difficultyMulti, int dungeonFloor) {
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
                enemyName = "Giant Gollum (BOSS)";
                enemyHealth = 1000 * difficultyMulti * (dungeonFloor / 5.0);
                enemyAttack = 40 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3);
            }

        } else {
            if (enemyChooser == 1) {
                enemyName = "Goblin";
                enemyHealth = 500 * difficultyMulti * (dungeonFloor / 5.0);
                enemyAttack = 50 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3);
            } else if (enemyChooser == 2) {
                enemyName = "Slime";
                enemyHealth = 750 * difficultyMulti * (dungeonFloor / 5.0);
                enemyAttack = 30 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3);
            } else {
                enemyName = "Golem";
                enemyHealth = 1000 * difficultyMulti * (dungeonFloor / 5.0);
                enemyAttack = 40 * difficultyMulti * (1 + dungeonFloor / 5.0 * 0.3);
            }
        }
    }


}
