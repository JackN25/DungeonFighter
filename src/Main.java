import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;
public class Main {
    static int whatHappensNext;
    static String type;
    static String name;
    static int dungeonFloor = 0;
    static double difficultyMulti = 1;
    static boolean gameOver = false;
    static boolean characterChosen = false;
    static String roles = "swordsman\nmage\ntank\nmarksman";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Dungeon Time!");
        while (!characterChosen) {
            System.out.println("Here are 4 roles that you can choose:");
            System.out.println("Swordsman\nMage\nTank\nMarksman");
            System.out.print("Enter the character you choose: ");
            type = s.nextLine();
            if (roles.contains(type.toLowerCase())) {
                characterChosen = true;

            } else {
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
            } else if (whatHappensNext > 6 && whatHappensNext <= 9) {
                System.out.println("Secret chest!");
            } else {
                System.out.println("ENEMY: CHEST MIMIC");
                Enemy mimicMoment = new Enemy(difficultyMulti, dungeonFloor, "Chest Mimic");
            }
        }
    }
}