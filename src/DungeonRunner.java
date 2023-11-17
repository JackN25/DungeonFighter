import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class DungeonRunner {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        String input;
        String type = "";
        String name;
        double difficultyMulti = 1;
        boolean gameOver = false;
        boolean characterChosen = false;
        Scanner s = new Scanner(System.in);
        Enemy enemy = new Enemy(0,0);

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

        boolean inCombat = false;

        while (!gameOver) {
            System.out.println("What do you want to do(n for next level, q to view stats):");
            input = s.nextLine();
            if (input.toLowerCase().equals("n")) {
                dungeon.nextFloor();
                player.reduceSkillcd();
                player.regenEnergy();
                System.out.println(player);
                if (dungeon.determineNextEvent() == 1) {
                    enemy = new Enemy(difficultyMulti, dungeon.getDungeonFloor());
                    System.out.println(enemy.getEnemyName());
                    inCombat = true;
                }
                else if (dungeon.determineNextEvent() == 2) {
                    enemy = new Enemy(difficultyMulti, dungeon.getDungeonFloor());
                    System.out.println(enemy.getEnemyName());
                    inCombat = true;
                }
                else if (dungeon.determineNextEvent() == 3) {
                    System.out.println("You found a secret chest!\nYour level has been increased by 1!");
                    player.levelUp();
                    player.recalculateCharacterStats();
                }
                else {
                    System.out.println("ENEMY: CHEST MIMIC");
                    enemy = new Enemy(difficultyMulti, dungeon.getDungeonFloor(), "Chest Mimic");
                    inCombat = true;
                }


                if (inCombat) {
                    System.out.println("\n\n\n\n\n\n\n\n\n-------------------------------------------");
                    while (enemy.getEnemyHealth() > 0) {
                        System.out.println(enemy.getEnemyName());
                        System.out.println("Enemy Health: " + enemy.getEnemyHealth());
                        System.out.println("------");
                        System.out.println("Your stats: ");
                        System.out.println(player + "\n\n\n");
                        boolean validInputForSkill = false;
                        while (validInputForSkill == false) {
                            System.out.println("What skill do you want to use?(use 1,2,3,4 or 5)");
                            input = s.nextLine().toLowerCase();
                            if (input.equals("4")) {
                                System.out.println("The enemy did zero damage!");
                                validInputForSkill = true;
                            } else if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("5")) {
                                validInputForSkill = true;
                                Combat fight = new Combat(player, enemy, input);
                                double result = fight.fightResult();
                                if (result < 0) {
                                    System.out.println("You healed " + -result + " health!");
                                }
                                if (result > 0) {
                                    System.out.println("You did " + result + " damage to " + enemy.getEnemyName());
                                }
                            }
                        }


                    }
                    System.out.println("You have killed the enemy and cleared the floor!");
                    inCombat = false;
                }
            }
        }
    }
}