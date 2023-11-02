import java.util.ArrayList;

public class Character {
    private String type;
    private String name;
    private double health;
    private double healthMulti;
    private double attack;
    private double attackMulti;
    private double defense;
    private double defenseMulti;
    private double energy;
    private double energyMulti;
    private double energyRegen;
    private double energyRegenMulti;
    private double critChance;
    private double critBonus;
    private double attack1cd = 1;
    private double attack2cd = 2;
    private double attack3cd = 5;
    private double precision = 0;
    private double characterLevel;

    private ArrayList<String> accessories = new ArrayList<String>();
    private ArrayList<String> skills = new ArrayList<String>();


    //CREATES THE CHARACTER WITH STARTING SKILLS AND STATS
    public Character(String type, String name) {
        this.name = name;
        this.type = type;
        characterLevel = 0;
        if (type.equals("swordsman")) {
            attack = 11;
            attackMulti = 1.3;
            health = 100;
            healthMulti = 1.2;
            defense = 15;
            defenseMulti = 1.2;
            energy = 100;
            energyMulti= 1.2;
            energyRegen = 20;
            energyRegenMulti = 1.1;
            critChance = 0.33;
            critBonus = 1.5;
            skills.add("Slice");
            skills.add("Cleave");
            skills.add("Block");
            skills.add("Bandage");
            skills.add("Strengthen");
            skills.add("Flurry strike");
        } else if (type.equals("mage")) {
            attack = 12;
            attackMulti = 1.3;
            health = 80;
            healthMulti = 1.1;
            defense = 10;
            defenseMulti = 1.1;
            energy = 175;
            energyMulti = 1.3;
            energyRegen = 30;
            energyRegenMulti = 1.3;
            critChance = 0.33;
            critBonus = 1.5;
            skills.add("Magic Blast");
            skills.add("Fireball");
            skills.add("Shield");
            skills.add("Heal");
            skills.add("Empower");
            skills.add("Elemental Storm");
        } else if (type.equals("tank")) {
            attack = 10;
            attackMulti = 1.2;
            health = 150;
            healthMulti = 1.3;
            defense = 20;
            defenseMulti = 1.3;
            energy = 90;
            energyMulti = 1.2;
            energyRegen = 20;
            energyRegenMulti = 1.1;
            critChance = 0.15;
            critBonus = 1.75;
            skills.add("Smack");
            skills.add("Slam");
            skills.add("Bandage");
            skills.add("Parry");
            skills.add("Solidify");
            skills.add("idk for ultimate");
        } else if (type.equals("marksman")) {
            attack = 10;
            attackMulti = 1.3;
            health = 90;
            healthMulti = 1.1;
            defense = 15;
            defenseMulti = 1.2;
            energy = 100;
            energyMulti = 1.2;
            energyRegen = 20;
            energyRegenMulti = 1.1;
            critChance = 0.45;
            critBonus = 1.33;
            skills.add("Shoot");
            skills.add("Stab");
            skills.add("Retreat");
            skills.add("Bandage");
            skills.add("Take Aim");
            skills.add("Volley Shot");
        } else if (type.equals("test")) {
            attack = 9001;
            attackMulti = 1;
            health = 9001;
            healthMulti = 1;
            defense = 9001;
            defenseMulti = 1;
            energy = 9001;
            energyMulti = 1;
            energyRegen = 9001;
            energyRegenMulti = 1;
            characterLevel = 9001;
            skills.add("Strike of God");
        }
    }


    //CHARACTER ATTACKS
    public double characterAttack(String attackName) {
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
                    if (attackName.equals("slice")) {
                        damageDealt = attack * attackMulti * critBonus;
                        energy -= 25;
                    }
                    if (attackName.equals("Cleave")) {
                        damageDealt = attack * attackMulti * critBonus * 1.33;
                        energy -= 35;
                    }
                    if (attackName.equals("Flurry Strike")) {
                        damageDealt = attack * attackMulti * critBonus * 3;
                        energy -= 75;
                    }
                } else{
                    if (attackName.equals("slice")) {
                        damageDealt = attack * attackMulti;
                        energy -= 25;
                    }
                    if (attackName.equals("Cleave")) {
                        damageDealt = attack * attackMulti * 1.33;
                        energy -= 35;
                    }
                    if (attackName.equals("Flurry Strike")) {
                        damageDealt = attack * attackMulti * 3;
                        energy -= 75;
                    }
                }
            }
        }
        if (type.equals("mage")) {
            if (hit) {
                if(crit) {
                    if (attackName.equals("Fireball")) {
                        damageDealt = attack * attackMulti * critBonus * 1.2;
                        energy -= 30;
                    }
                    if (attackName.equals("Magic Blast")) {
                        damageDealt = attack * attackMulti * critBonus;
                        energy -= 25;
                    }
                }
            }
        }
        return damageDealt;
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
    public double getHealthMulti(){
        return healthMulti;
    }
    public double getAttack(){
        return attack;
    }
    public double getAttackMulti(){
        return attackMulti;
    }
    public double getDefense(){
        return defense;
    }
    public double getDefenseMulti(){
        return defenseMulti;
    }
    public double getEnergy(){
        return energy;
    }
    public double getEnergyMulti(){
        return energyMulti;
    }
    public double getEnergyRegen(){
        return energyRegen;
    }
    public double getEnergyRegenMulti(){
        return energyRegenMulti;
    }
}
