import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;
public class Main {
    static String type;
    static String name;
    static double dungeonFloor = 0;
    static double difficultyMulti = 1;
    static boolean gameOver = false;
    static boolean characterChosen = false;
    static String roles = "Swordsman\nMage\nTank\nMarksman";
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

        }
    }
}