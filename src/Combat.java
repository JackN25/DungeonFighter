public class Combat {
    /**
     * Represents a combat scenario
     * @param player is the character instance that the user created
     * @param skill is the ability that the user entered for the character to use
     * @param enemy is the enemy instance that takes damage
     */
    Character player;
    String skill;
    Enemy enemy;
    public Combat(Character c, Enemy e, String s) {
        /**
         * Sets the variables to the instances and user input
         */
        this.player = c;
        this.enemy = e;
        this.skill = s;
    }

    public double fightResult() {
        /**
         * Checks if the user has enough energy to use a skill or if the skill is off cooldown
         * Calls the characterSkill() method in character.java to determine amount of damage dealt if the conditions are met
         * @returns the amount of damage the character dealt if the result is positive/zero and the health the character healed if the result is negative
         */
        double result = 0;
        if (skill.equals("1")) {
            if (player.getRoundsAfterSkill1() == 0 && player.getEnergy() >= player.getSkill1EnergyCost()){
                result = player.characterSkill(skill);
                enemy.updateEnemyHealth(result);
            }else {
                result = -123456789;
            }
        }
        if (skill.equals("2")) {
            if (player.getRoundsAfterSkill2() == 0 && player.getEnergy() >= player.getSkill2EnergyCost()) {
                result = player.characterSkill(skill);
                enemy.updateEnemyHealth(result);
            }else {
                result = -123456789;
            }
        }
        if (skill.equals("4")) {
            if (player.getRoundsAfterSkill3() == 0 && player.getEnergy() >= player.getSkill4EnergyCost()) {
                result = -player.regenHealth();
            }else {
                result = -123456789;
            }
        }
        if (skill.equals("5")) {
            if (player.getRoundsAfterSkill5() == 0 && player.getEnergy() >= player.getSkill5EnergyCost()) {
                result = player.characterSkill(skill);
                enemy.updateEnemyHealth(result);
            }else {
                result = -123456789;
            }
        }
        return result;
    }
}
