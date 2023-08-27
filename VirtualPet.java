public class VirtualPet {
    // Instance variables represent state of pets
    private String name;
    private int hunger;
    private int thirst;
    private int waste;
    private int boredom;
    private int sickness;

    // Constructor initialization for virtual pet
    public VirtualPet(String name) {
        this.name = name;
        this.hunger = 50;
        this.thirst = 50;
        this.waste = 0;
        this.boredom = 50;
        this.sickness = 0;
    }

    // Methods/pet behaviors:
    // Method to update pet based on the passage of time
    public void tick() {
        hunger += 5;
        thirst += 5;
        boredom += 5;
        sickness += 2;
    }

    // Method to feed pet
    public void feed() {
        hunger -= 20;
        thirst += 10;
        waste += 15;
    }

    // Method to water pet
    public void water() {
        thirst -= 20;
    }

    // Method to let virtual take a bio
    public void pottyBreak() {
        waste = 0;
    }

    // Method to play with pet
    public void play() {
        boredom -= 30;
        thirst += 10;
        sickness += 10;
    }

    // Method to bring pet to vet
    public void vetVisit() {
        sickness = 0;
    }

    // Method to check if pet is alive, needed to continue/end gameloop
    public boolean isAlive() {
        return hunger < 100 && thirst < 100 && sickness < 100;
    }

    public int calculateHealth() {
        int health = 100; // Starting with max health

        // Overall Health changes dependant on pet attribute values
        if (hunger >= 50) {
            health -= (hunger - 50);
        }

        if (thirst >= 50) {
            health -= (thirst - 50);
        }

        if (boredom >= 50) {
            health -= (boredom - 50);
        }

        if (sickness >= 50) {
            health -= (sickness - 50);
        }

        // Capping health to range between 0-100
        if (health < 0) {
            health = 0;
        } else if (health > 100) {
            health = 100;
        }

        return health;
    }

    // Getters for pet attributes

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getWaste() {
        return waste;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getSickness() {
        return sickness;
    }

}