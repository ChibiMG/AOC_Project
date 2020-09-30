package api;

public interface Capteur {

    /**
     *
     * @param o
     */
    public void attach(Observer o);

    /**
     *
     * @param o
     */
    public void detach(Observer o);

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
