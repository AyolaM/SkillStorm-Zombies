
public class Player {
    private String name;
    private int healthPoints;
    private int strength;
    private int wisdom;
    private int compassion;

    public Player(String name, int healthPoints, int strength, int wisdom, int compassion) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.wisdom = wisdom;
        this.compassion = compassion;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
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

    public void takeDamage(int damage) {
        healthPoints -= damage;
    }

    public void saveLife() {
        compassion += 5;
    }

    @Override
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
