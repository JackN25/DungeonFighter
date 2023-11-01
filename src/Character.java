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
        }
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
