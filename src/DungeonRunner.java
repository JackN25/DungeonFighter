import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class DungeonRunner {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        String type = "";
        String name;
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
        Dungeon dungeon = new Dungeon();

        while (!gameOver) {
            dungeon.nextFloor();
            player.regenEnergy();
            System.out.println(player.toString());
            if (dungeon.determineNextEvent() == 1) {
                Enemy boss = new Enemy(difficultyMulti, dungeon.getDungeonFloor());
                System.out.println(boss.getEnemyName());
            }
            else if (dungeon.determineNextEvent() == 2) {
                Enemy normalEnemy = new Enemy(difficultyMulti, dungeon.getDungeonFloor());
                System.out.println(normalEnemy.getEnemyName());
            }
            else if (dungeon.determineNextEvent() == 3) {
                System.out.println("You found a secret chest!\nYour level has been increased by 1!");
                player.levelUp();
                player.recalculateCharacterStats();
            }
            else {
                System.out.println("ENEMY: CHEST MIMIC");
                Enemy mimicMoment = new Enemy(difficultyMulti, dungeon.getDungeonFloor(), "Chest Mimic");
            }

            if (player.getHealth() <= 0) {
                gameOver = true;
            }

            if (dungeon.getDungeonFloor() > 100) {
                gameOver = true;
            }
        }
    }
}