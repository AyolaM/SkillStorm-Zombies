
public class Player {
    // Fields/properties/variables
    private String name;
    private int healthPoints;
    private int strength;
    private int wisdom;
    private int compassion;

    // no args constr
    public Player(){}

    // constructor w/ parameters, arguements passed in main will initialize
    public Player(String name, int healthPoints, int strength, int wisdom, int compassion) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.wisdom = wisdom;
        this.compassion = compassion;
    }

    // methods- getters and setters
    // add name, validate that name not empty
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) 
        this.name = name;
    }


    public int getHealthPoints() {
        return healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCompassion() {
        return compassion;
    }
// reduce healthpoints
    public void takeDamage(int damage) {
        healthPoints -= damage;
    }
// increases compassion points by 5 when a life is saved
    public void saveLife() {
        compassion += 5;
    }

    @Override //overriding the object
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", healthPoints=" + healthPoints +
                ", strength=" + strength +
                ", wisdom=" + wisdom +
                ", compassion=" + compassion +
                '}';
    }
}
