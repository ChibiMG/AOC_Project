package api;

public interface Capteur extends CapteurAsync, Subject {

    /**
     * @return the Capteur value
     */
    public Integer getValue();

    /**
     * Increment the counter and call canals
     */
    public void tick();

}
