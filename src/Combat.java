public class Combat {
    Character player;
    String skill;
    Enemy enemy;
    public Combat(Character c, Enemy e, String s) {
        this.player = c;
        this.enemy = e;
        this.skill = s;
    }

    public double fightResult() {
        double result = 0;
        if (skill.equals("1")) {
            if (player.getRoundsAfterSkill1() == 0){
                result = player.characterSkill(skill);
                enemy.updateEnemyHealth(result);
            }else {
                result = -123456789;
            }
        }
        if (skill.equals("2")) {
            if (player.getRoundsAfterSkill2() == 0) {
                result = player.characterSkill(skill);
                enemy.updateEnemyHealth(result);
            }else {
                result = -123456789;
            }
        }
        if (skill.equals("4")) {
            if (player.getRoundsAfterSkill3() == 0) {
                result = -player.regenHealth();
            }else {
                result = -123456789;
            }
        }
        if (skill.equals("5")) {
            if (player.getRoundsAfterSkill5() == 0) {
                result = player.characterSkill(skill);
                enemy.updateEnemyHealth(result);
            }else {
                result = -123456789;
            }
        }
        return result;
    }
}
