import java.util.Scanner;
public class DungeonRunner {
    public static void main(String[] args) {
        int whatHappensNext;
        String type = "";
        String name;
        int dungeonFloor = 0;
        double difficultyMulti = 1;
        boolean gameOver = false;
        boolean characterChosen = false;
        Scanner s = new Scanner(System.in);
        System.out.println("Dungeon Time!");
        while (!characterChosen) {
            System.out.println("Here are 4 roles that you can choose:");
            System.out.println("Swordsman\nMage\nTank\nMarksman");
            System.out.print("Enter the character you choose: ");
            type = s.nextLine();
            if (type.toLowerCase().equals("swordsman") || type.toLowerCase().equals("mage") || type.toLowerCase().equals("tank") || type.toLowerCase().equals("marksman") || type.toLowerCase().equals("test")) {
                characterChosen = true;

            }
            else {
                System.out.println("Please choose one of the 4 roles.\n\n\n");
            }
        }
        System.out.print("Input your character's name: ");
        name = s.nextLine();

        Character player = new Character(type, name);
        while (!gameOver) {
            dungeonFloor++;
            whatHappensNext = (int) (Math.random() * 11);
            if (dungeonFloor % 5 == 0) {
                Enemy boss = new Enemy(difficultyMulti, dungeonFloor);
                System.out.println(boss.getEnemyName());
            }
            else if (whatHappensNext >= 0 && whatHappensNext <= 6) {
                Enemy normalEnemy = new Enemy(difficultyMulti, dungeonFloor);
                System.out.println(normalEnemy.getEnemyName());
            }
            else if (whatHappensNext > 6 && whatHappensNext <= 9) {
                System.out.println("Secret chest!");
            }
            else {
                System.out.println("ENEMY: CHEST MIMIC");
                Enemy mimicMoment = new Enemy(difficultyMulti, dungeonFloor, "Chest Mimic");
            }

            if (player.getHealth() <= 0) {
                gameOver = true;
            }
        }
    }
}