package api;

public interface Capteur extends CapteurAsync, Subject {

    /**
     *
     * @return
     */
    public Integer getValue();

    /**
     * Increment the counter
     */
    public void tick();

}
