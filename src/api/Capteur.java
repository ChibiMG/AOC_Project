package api;

/**
 * Interface of CapteurImpl
 * @author Maud Garçon & Emmanuel Chauvel
 */

public interface Capteur extends CapteurAsync, Subject {

    /**
     * @return the Capteur value
     */
    Integer getValue();

    /**
     * Increment the counter and call canals
     */
    void tick();

}
