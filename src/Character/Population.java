package Character;

import java.util.ArrayList;
import Simulator.*;
import java.util.List;
import Virus.*;
/**
 * Created by Thomas on 26/11/15.
 *
 * Stock le nombre total de character + definis l'implementation graphique
 */
abstract class Population {
    private ArrayList<Population> populationList;

    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;

    private State state;

    private Virus v;

    /**
     * Create a new animal at location in field.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Population(Field field, Location location, State state, Virus v)
    {
        this.v = v;
        this.state = State.HEALTHY;
        this.alive = true;
        this.field = field;
        setLocation(location);
    }

    /**
     * Make this population act - that is: make it do
     * whatever it wants/needs to do.
     * @param newPopulation A list to receive newly born animals.
     */
    abstract public void act(List<Population> newPopulation);

    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }

    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }

    public void SetSick() {
        this.state = State.SICK;
    }

    public void ContagiousSick() {
        this.state = State.CONTAGIOUS;
    }

    public void SetDead() {
        this.state = State.DEAD;
    }

    public void giveIll()
    {

    }
}
