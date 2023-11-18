import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Character {
    private String type;
    private String name;
    private double baseHealth;
    private double health;
    private double maxHealth;
    private double maxHealthMulti;
    private double attack;
    private double baseAttack;
    private double attackMulti;
    //private double defense;
    //private double defenseMulti;
    private double energy;
    private double baseEnergy;
    private double maxEnergy;
    private double maxEnergyMulti;
    private double energyRegen;
    private double energyRegenMulti;
    private double critChance;
    private double critBonus;
    private double skill1cd = 1;
    private double roundsAfterSkill1 = 0;
    private double skill1EnergyCost;
    private double skill2cd = 2;
    private double roundsAfterSkill2 = 1;
    private double skill2EnergyCost;
    private double skill3cd = 5;
    private double roundsAfterSkill3 = 2;
    private double skill3EnergyCost;
    private double skill4cd = 3;
    private double roundsAfterSkill4 = 3;
    private double skill4EnergyCost;
    private double skill5cd = 7;
    private double roundsAfterSkill5 = 5;
    private double skill5EnergyCost;
    //private double precision;
    private int characterLevel;
    private int characterExp;
    private int characterExpUntilNextLevel;

    //private ArrayList<String> accessories = new ArrayList<String>();
    private ArrayList<String> skills = new ArrayList<String>();


    //CREATES THE CHARACTER WITH STARTING SKILLS AND STATS

    /**
     *
     * @param type
     * @param name
     */
    public Character(String type, String name) {

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        this.name = name;
        this.type = type;
        characterLevel = 0;
        characterExpUntilNextLevel = 100;
        setAttributes();
    }


    //Attribute Initialization
    public void setAttributes(){
        if (type.equals("swordsman")) {
            attack = 11;
            baseAttack = 11;
            attackMulti = 1.3;
            maxHealth = 100;
            baseHealth = 100;
            health = 100;
            maxHealthMulti = 1.2;
            //defense = 15;
            //defenseMulti = 1.2;
            maxEnergy = 100;
            energy = 100;
            baseEnergy = 100;
            maxEnergyMulti= 1.2;
            energyRegen = 20;
            energyRegenMulti = 1.1;
            critChance = 0.33;
            critBonus = 1.5;
            skill1EnergyCost = 25;
            skill2EnergyCost = 35;
            skill3EnergyCost = 0;
            skills.add("Slice");
            skills.add("Cleave");
            skills.add("Block");
            skills.add("Bandage");
            skills.add("Flurry strike");
        }
        else if (type.equals("mage")) {
            attack = 12;
            baseAttack = 12;
            attackMulti = 1.3;
            maxHealth = 80;
            baseHealth = 80;
            health = 80;
            maxHealthMulti = 1.1;
            //defense = 10;
            //defenseMulti = 1.1;
            maxEnergy = 175;
            energy = 175;
            baseEnergy = 175;
            maxEnergyMulti = 1.3;
            energyRegen = 30;
            energyRegenMulti = 1.3;
            critChance = 0.33;
            critBonus = 1.5;
            skills.add("Magic Blast");
            skills.add("Fireball");
            skills.add("Shield");
            skills.add("Heal");
            skills.add("Elemental Storm");
        }
        else if (type.equals("tank")) {
            attack = 10;
            baseAttack = 10;
            attackMulti = 1.2;
            health = 150;
            baseHealth = 150;
            maxHealth = 150;
            maxHealthMulti = 1.3;
            //defense = 20;
            //defenseMulti = 1.3;
            maxEnergy = 90;
            energy = 90;
            baseEnergy = 90;
            maxEnergyMulti = 1.2;
            energyRegen = 20;
            energyRegenMulti = 1.1;
            critChance = 0.15;
            critBonus = 1.75;
            skills.add("Smack");
            skills.add("Slam");
            skills.add("Bandage");
            skills.add("Parry");
            skills.add("tank ult");
        }
        else if (type.equals("marksman")) {
            attack = 10;
            baseAttack = 10;
            attackMulti = 1.3;
            health = 90;
            maxHealth = 90;
            baseHealth = 90;
            maxHealthMulti = 1.1;
            //defense = 15;
            //defenseMulti = 1.2;
            maxEnergy = 100;
            energy = 100;
            baseEnergy = 100;
            maxEnergyMulti = 1.2;
            energyRegen = 20;
            energyRegenMulti = 1.1;
            critChance = 0.45;
            critBonus = 1.33;
            skills.add("Shoot");
            skills.add("Stab");
            skills.add("Dodge");
            skills.add("Bandage");
            skills.add("Volley Shot");
        }
        else if (type.equals("test")) {
            characterLevel = 9001;
            attack = 9001;
            baseAttack = 9001;
            attackMulti = 1;
            health = 9001;
            baseHealth = 9001;
            maxHealth = 9001;
            maxHealthMulti = 1;
            //defense = 9001;
            //defenseMulti = 1;
            maxEnergy = 9001;
            energy = 9001;
            baseEnergy = 9001;
            maxEnergyMulti = 1;
            energyRegen = 9001;
            energyRegenMulti = 1;
            characterLevel = 9001;
            skills.add("Strike of God");
            skills.add("Strike of God");
            skills.add("Strike of God");
            skills.add("Strike of God");
            skills.add("Strike of God");
        }
    }


    //CHARACTER ATTACKS

    /**
     *
     * @param attackName
     * @return
     */
    public double characterSkill(String attackName) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        double damageDealt = 0;
        int attackSuccessful = (int) (1 + Math.random() * 100);
        int critRandomizer = (int) (Math.random() * 100);
        boolean crit = false;
        boolean hit = false;
        if (critRandomizer >= 100 - (critChance * 100)){
            crit = true;
        }
        if (attackSuccessful >= 25) {
            hit = true;
        }
        //SWORDSMAN ATTACKS
        if (type.equals("swordsman")) {
            if (hit) {
                //Crit attacks
                if (crit) {
                    if (attackName.equals("1")) {
                        damageDealt = attack * attackMulti * critBonus;
                        energy -= 25;
                        roundsAfterSkill1 = skill1cd;
                    }
                    if (attackName.equals("2")) {
                        damageDealt = attack * attackMulti * critBonus * 1.33;
                        energy -= 35;
                        roundsAfterSkill2 = skill2cd;
                    }
                    if (attackName.equals("5")) {
                        damageDealt = attack * attackMulti * critBonus * 3;
                        energy -= 75;
                        roundsAfterSkill5 = skill5cd;
                    }
                } else{
                    if (attackName.equals("1")) {
                        damageDealt = attack * attackMulti;
                        energy -= 25;
                        roundsAfterSkill1 = skill1cd;
                    }
                    if (attackName.equals("2")) {
                        damageDealt = attack * attackMulti * 1.33;
                        energy -= 35;
                        roundsAfterSkill2 = skill2cd;
                    }
                    if (attackName.equals("5")) {
                        damageDealt = attack * attackMulti * 3;
                        energy -= 75;
                        roundsAfterSkill5 = skill5cd;
                    }
                }
            }
        }
        else if (type.equals("mage")) {
            if (hit) {
                if(crit) {
                    if (attackName.equals("1")) {
                        damageDealt = attack * attackMulti * critBonus * 1.2;
                        energy -= 30;
                        roundsAfterSkill1 = skill1cd;
                    }
                    if (attackName.equals("2")) {
                        damageDealt = attack * attackMulti * critBonus;
                        energy -= 25;
                        roundsAfterSkill2 = skill2cd;
                    }
                    if (attackName.equals("5")) {
                        damageDealt = attack * attackMulti * critBonus * 3;
                        energy -= 80;
                        roundsAfterSkill5 = skill5cd;
                    }
                } else {
                    if (attackName.equals("1")) {
                        damageDealt = attack * attackMulti * 1.2;
                        energy -= 30;
                        roundsAfterSkill1 = skill1cd;
                    }
                    if (attackName.equals("2")) {
                        damageDealt = attack * attackMulti;
                        energy -= 25;
                        roundsAfterSkill2 = skill2cd;
                    }
                    if (attackName.equals("5")) {
                        damageDealt = attack * attackMulti * 3;
                        energy -= 80;
                        roundsAfterSkill5 = skill5cd;
                    }
                }
            }
        }
        else if (type.equals("tank")) {
            if (hit) {
                if(crit) {
                    if (attackName.equals("1")) {
                        damageDealt = attack * attackMulti * critBonus;
                        energy -= 30;
                        roundsAfterSkill1 = skill1cd;
                    }
                    if (attackName.equals("2")) {
                        damageDealt = attack * attackMulti * critBonus * 1.5;
                        energy -= 25;
                        roundsAfterSkill2 = skill2cd;
                    }
                    if (attackName.equals("5")) {
                        damageDealt = attack * attackMulti * critBonus * 3;
                        energy -= 80;
                        roundsAfterSkill5 = skill5cd;
                    }
                } else {
                    if (attackName.equals("1")) {
                        damageDealt = attack * attackMulti;
                        energy -= 30;
                        roundsAfterSkill1 = skill1cd;
                    }
                    if (attackName.equals("2")) {
                        damageDealt = attack * attackMulti * 1.3;
                        energy -= 35;
                        roundsAfterSkill2 = skill2cd;
                    }
                    if (attackName.equals("5")) {
                        damageDealt = attack * attackMulti * 3;
                        energy -= 80;
                        roundsAfterSkill5 = skill5cd;
                    }
                }
            }
        }
        else if (type.equals("marksman")) {
            if (hit) {
                if(crit) {
                    if (attackName.equals("1")) {
                        damageDealt = attack * attackMulti * critBonus * 1.3;
                        energy -= 30;
                        roundsAfterSkill1 = skill1cd;
                    }
                    if (attackName.equals("2")) {
                        damageDealt = attack * attackMulti * critBonus;
                        energy -= 25;
                        roundsAfterSkill2 = skill2cd;
                    }
                    if (attackName.equals("5")) {
                        damageDealt = attack * attackMulti * critBonus * 3;
                        energy -= 75;
                        roundsAfterSkill5 = skill5cd;
                    }
                } else {
                    if (attackName.equals("1")) {
                        damageDealt = attack * attackMulti * 1.3;
                        energy -= 25;
                        roundsAfterSkill1 = skill1cd;
                    }
                    if (attackName.equals("2")) {
                        damageDealt = attack * attackMulti;
                        energy -= 20;
                        roundsAfterSkill2 = skill2cd;
                    }
                    if (attackName.equals("5")) {
                        damageDealt = attack * attackMulti * 3;
                        energy -= 75;
                        roundsAfterSkill5 = skill5cd;
                    }
                }
            }
        }
        else if (type.equals("test")) {
            if (crit) {
                damageDealt = attack * attackMulti * critBonus;
            }
        }
        damageDealt = Double.parseDouble(df.format(damageDealt));
        return damageDealt;
    }

    /**
     *
     * @return
     */
    public double regenHealth() {
        health += baseHealth * 0.3;
        return baseHealth * 0.3;
    }


    /**
     *
     */
    public void regenEnergy() {
        double energyRegained = energyRegen * energyRegenMulti;
        if (energyRegained + energy > maxEnergy) {
            energy += maxEnergy - energy;
        } else {
            energy += energyRegained;
        }
    }

    /**
     *
     */
    public void levelUp() {
        characterLevel ++;
        attackMulti += 0.15;
        maxHealthMulti += 0.001;
        if (characterLevel % 15 == 0) {
            baseAttack += 5;
            maxHealth += 7;
            maxEnergy += 10;
        }
        energyRegenMulti += 0.02;
        health = maxHealth;
    }

    /**
     *
     */
    public void recalculateCharacterStats() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        attack = Double.parseDouble(df.format(baseAttack + (baseAttack * attackMulti)));
        maxHealth = Double.parseDouble(df.format(baseHealth + (baseHealth * maxHealthMulti)));
        energyRegen = Double.parseDouble(df.format(energyRegen + (energyRegen * energyRegenMulti)));
        maxEnergy = Double.parseDouble(df.format(baseEnergy + (baseEnergy * maxEnergyMulti)));
    }

    /**
     *
     */
    public void reduceSkillcd(){
        skill1cd--;
        skill2cd--;
        skill3cd--;
        skill4cd--;
        skill5cd--;
        if (skill1cd < 0) {
            skill1cd = 0;
        }
        if (skill2cd < 0) {
            skill2cd = 0;
        }
        if (skill3cd < 0) {
            skill3cd = 0;
        }
        if (skill4cd < 0) {
            skill4cd = 0;
        }
        if (skill5cd < 0) {
            skill5cd = 0;
        }
    }

    /**
     *
     * @param d
     */
    public void takeDamage(double d){
        health = health - d;
    }

    /**
     *
     * @return
     */
    public String toString(){

        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.HALF_UP);

        return "Health: " + df.format(health) + "/" + df.format(maxHealth) +"\nEnergy: " + df.format(energy) +"/" + df.format(maxEnergy) + "\nAttack Cooldowns: \n" + skills.get(0) + ": " + skill1cd + " | " + skills.get(1) + ": " + skill2cd + " | " + skills.get(2) + ": " + skill3cd + " | " + skills.get(3) + ": " + skill4cd + " | " + skills.get(4) + ": " + skill5cd;
    }





    //GETTER METHODS
    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }
    public double getHealth(){
        return health;
    }
    public double getMaxHealth(){
        return maxHealth;
    }
    public double getMaxHealthMulti(){
        return maxHealthMulti;
    }
    public double getAttack(){
        return attack;
    }
    public double getAttackMulti(){
        return attackMulti;
    }
    /* public double getDefense(){
        return defense;
    }
    public double getDefenseMulti(){
        return defenseMulti;
    } */ //defense not implemented
    public double getEnergy(){
        return energy;
    }
    public double getMaxEnergyMulti(){
        return maxEnergyMulti;
    }
    public double getEnergyRegen(){
        return energyRegen;
    }
    public double getEnergyRegenMulti(){
        return energyRegenMulti;
    }
    /*public ArrayList<String> getAccessories() {
        return accessories;
    }*/ // accessories not implemented

    public double getRoundsAfterSkill1() {
        return roundsAfterSkill1;
    }
    public double getRoundsAfterSkill2() {
        return roundsAfterSkill2;
    }
    public double getRoundsAfterSkill3() {
        return roundsAfterSkill3;
    }
    public double getRoundsAfterSkill4() {
        return roundsAfterSkill4;
    }
    public double getRoundsAfterSkill5() {
        return roundsAfterSkill5;
    }
}
