public class Enemy {
    private int difficultyMulti;
    private int dungeonFloor;
    private int enemyHealth;
    private int enemyAttack;
    private String enemyName;

    public Enemy(int difficultyMulti, int dungeonFloor) {
            this.difficultyMulti = difficultyMulti;
            this.dungeonFloor = dungeonFloor;
            if (dungeonFloor % 5 == 0) {
                int enemyChooser = (int) (1 + (Math.random() * 3));

            } else {
                int enemyChooser = (int) (1 + (Math.random() * 3));
            }
    }


}
