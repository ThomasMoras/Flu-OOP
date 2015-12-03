package Character;


/**
 * Created by Thomas on 26/11/15.
 *
 * Class representant une personne
 */
public class Person extends Population {
    private State state;

    public Person() {
        this.state = State.HEALTHY;
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
