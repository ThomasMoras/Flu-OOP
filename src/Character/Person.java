package Character;


import Simulator.Location;
import Virus.Virus;
import Simulator.Field;
import Simulator.Randomizer;
import java.util.Random;
import java.util.List;

/**
 * Created by Thomas on 26/11/15.
 *
 * Class representant une personne
 */
public class Person extends Population {

    // The age at which a person can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a person can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a person breeding.
    private static final double BREEDING_PROBABILITY = 0.12;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

    // Individual characteristics (instance fields).

    // The person's age.
    private int age;
    /**
     * Create a new person. A person may be created with age
     * zero (a new born) or with a random age.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */

    public Person(Field field, Location location, State s, Virus v) {
       super(field,location,s,null);
    }

    // Characteristics shared by all persons (class variables).




    /**
     * This is what the person does most of the time - it runs
     * around. Sometimes it will breed or die of old age.
     * @param newPerson A list to return newly born persons.
     */
    public void act(List<Population> newPerson)
    {
        incrementAge();
        if(isAlive()) {
            giveBirth(newPerson);
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }

    /**
     * Increase the age.
     * This could result in the person's death.
     */
    private void incrementAge()
    {
        age++;
        if(age > MAX_AGE) {
            setDead();
        }
    }

    /**
     * Check whether or not this person is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newPerson A list to return newly born persons.
     */
    private void giveBirth(List<Population> newPerson)
    {
        // New persons are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Person young = new Person(field, loc, State.HEALTHY,null);
            newPerson.add(young);
        }
    }

    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
            births = rand.nextInt(MAX_LITTER_SIZE) + 1;
        }
        return births;
    }

    /**
     * A person can breed if it has reached the breeding age.
     * @return true if the person can breed, false otherwise.
     */
    private boolean canBreed()
    {
        return age >= BREEDING_AGE;
    }

}
