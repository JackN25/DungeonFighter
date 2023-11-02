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
    private ArrayList<String> accessories = new ArrayList<String>();
    private ArrayList<String> skills = new ArrayList<String>();


    //CREATES THE CHARACTER WITH STARTING SKILLS AND STATS
    public Character(String type, String name) {
        this.name = name;
        this.type = type;
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
            skills.add("Fireball");
            skills.add("Snowball");
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
            skills.add("Shoot");
            skills.add("Stab");
            skills.add("Retreat");
            skills.add("Bandage");
            skills.add("Precision");
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
            skills.add("Strike of God");
        }
    }


    //CHARACTER ACTIONS











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
