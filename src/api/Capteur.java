package api;

public interface Capteur {

    /**
     *
     * @param o
     */
    public void attach(ObserverAsync o);

    /**
     *
     * @param o
     */
    public void detach(ObserverAsync o);

    /**
     *
     * @return
     */
    public int getValue();

    /**
     * Increment the counter
     */
    public void tick();

}
