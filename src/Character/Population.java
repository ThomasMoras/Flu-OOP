package Character;

import java.util.ArrayList;

/**
 * Created by Thomas on 26/11/15.
 *
 * Stock le nombre total de character + definis l'implementation graphique
 */
public class Population {
    private ArrayList<Population> populationList;
    private State state;

    public Population(State state){
        this.state = state;
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
}
