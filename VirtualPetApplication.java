import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class VirtualPetApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        VirtualPet pet = new VirtualPet("Zigzag");

        System.out.println("Virtual Pet App is loading...");

        // Try/catch state to set a pause between 2 println functions.
        try {
            // Sleep for 10 secs using TimeUnit class
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // Handle exceptions during sleep
            e.printStackTrace();
        }
        
        // System.out.println("Virtual Pet App initiated...");
        // System.out.println("");

        System.out.println("Welcome to Virtual Petland!");
        System.out.println("");
        System.out.println("A new " + pet.getName() + " has been created out of thin air.");
        System.out.println("Do whatever your pet requires to ensure they stay alive!!");
        System.out.println("");

        // Loop to test is virtual pet is alive. If pet isAlive is true, print pet stats
        // then prompt user to make an action.
        while (pet.isAlive()) {

            System.out.println(pet.getName() + "'s Stats:");
            System.out.println("Hunger " + pet.getHunger());
            System.out.println("Thirst: " + pet.getThirst());
            System.out.println("Waste: " + pet.getWaste());
            System.out.println("Boredom: " + pet.getBoredom());
            System.out.println("Sickness: " + pet.getSickness());

            System.out.println("");

            System.out.println("What action would you like to do? Select action by list #.");
            System.out.println("1. Feed " + pet.getName());
            System.out.println("2. Water " + pet.getName());
            System.out.println("3. Take " + pet.getName() + " out for a potty break");
            System.out.println("4. Play with " + pet.getName());
            System.out.println("5. Bring " + pet.getName() + " to the vet");
            System.out.println("6. End game");

            System.out.println("");

            int action = input.nextInt();

            switch (action) {
                case 1:
                    pet.feed();
                    break;
                case 2:
                    pet.water();
                    break;
                case 3:
                    pet.pottyBreak();
                    break;
                case 4:
                    pet.play();
                    break;
                case 5:
                    pet.vetVisit();
                    break;
                case 6:
                    System.out.println("Say good bye to " + pet.getName() + "!");

                    try {
                        TimeUnit.SECONDS.sleep(2);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Application terminating.....");

                    try {
                        TimeUnit.SECONDS.sleep(3);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Application terminated.");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid action ID #.");

            }

            pet.tick();
        }

        System.out.println("Oh no.. You weren't able to proper care for " + pet.getName() + ". Game over.");

        input.close();
    }
}