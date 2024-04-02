public class Player {
    private int healthPoints;
    private int strength;
    private int wisdom;
    private int compassion;
    

    // no args constructor
    public Player() {
    }
    
    // Constructor
    public Player(int healthPoints, int strength, int wisdom, int compassion) {
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.wisdom = wisdom;
        this.compassion = compassion;
    }

    // Getters and Setters
    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCompassion() {
        return compassion;
    }

    public void setCompassion(int compassion) {
        this.compassion = compassion;
    }

    // Method to reduce player's healthPoints
    public void takeDamage(int damage) {
        healthPoints -= damage;
    }

    // Method to increase player's compassion
    public void saveLife() {
        compassion += 5;
    }

    @Override
    public String toString() {
        return "Player{" +
                "healthPoints=" + healthPoints +
                ", strength=" + strength +
                ", wisdom=" + wisdom +
                ", compassion=" + compassion +
                '}';
    }
}

