package Simulator;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import Character.*;
/**
 *
 * @author
 * @version 2015.12.03
 */
public class Simulator {
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;
    // The probability that a fox will be created in any given grid position.
    private static final double HUMAN_CREATION_PROBABILITY = 0.02;
    // The probability that a rabbit will be created in any given grid position.
    private static final double PIG_CREATION_PROBABILITY = 0.08;
    // The probability that a rabbit will be created in any given grid position.
    private static final double DUCK_CREATION_PROBABILITY = 0.08;
    // The probability that a rabbit will be created in any given grid position.
    private static final double CHICKEN_CREATION_PROBABILITY = 0.08;

    // List of animals in the field.
    private List<Population> population;
    // The current state of the field.
    private Field field;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private SimulatorView view;

    /**
     * Construct a simulation field with default size.
     */
    public Simulator() {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }

    /**
     * Create a simulation field with the given size.
     *
     * @param depth
     *            Depth of the field. Must be greater than zero.
     * @param width
     *            Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width) {
        if (width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }

        population = new ArrayList<>();
        field = new Field(depth, width);

        // Create a view of the state of each location in the field.
        view = new SimulatorView(depth, width);
        view.setColor(Person.class, Color.ORANGE);
        view.setColor(Pig.class, Color.PINK);

        // Setup a valid starting point.
        reset();
    }

    /**
     * Run the simulation from its current state for a reasonably long period,
     * (4000 steps).
     */
    public void runLongSimulation() {
        simulate(4000);
    }

    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     *
     * @param numSteps
     *            The number of steps to run for.
     */
    public void simulate(int numSteps) {
        for (int step = 1; step <= numSteps && view.isViable(field); step++) {
        //    simulateOneStep();
        }
    }

    /**
     * Run the simulation from its current state for a single step. Iterate over
     * the whole field updating the state of each fox and rabbit.
     */
   /* public void simulateOneStep() {

        step++;

        List<Population> newPop = new ArrayList<>();

        for (Iterator<Population> it = Population.iterator(); it.hasNext();) {
            Population population = it.next();
            population.act(newPop);
            if (!population.isAlive()) {
                it.remove();
            }
        }

        // Add the newly born foxes and rabbits to the main lists.
        population.addAll(newPop);

        view.showStatus(step, field);
    }*/


    /**
     * Reset the simulation to a starting position.
     */
    public void reset() {
        step = 0;
        population.clear();
        populate();

        // Show the starting state in the view.
        view.showStatus(step, field);
    }

    /**
     * Randomly populate the field with foxes and rabbits.
     */
    private void populate() {
        Random rand = Randomizer.getRandom();
        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                if (rand.nextDouble() <= HUMAN_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                 //   Fox fox = new Fox(true, field, location);
                 //   animals.add(fox);
                } else if (rand.nextDouble() <= CHICKEN_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    //   Rabbit rabbit = new Rabbit(true, field, location);
                    //   animals.add(rabbit);
                }
                else if (rand.nextDouble() <= CHICKEN_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    //   Rabbit rabbit = new Rabbit(true, field, location);
                    //   animals.add(rabbit);
                }
                else if (rand.nextDouble() <= CHICKEN_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    //   Rabbit rabbit = new Rabbit(true, field, location);
                    //   animals.add(rabbit);
                }
                // else leave the location empty.
            }
        }
    }
}
