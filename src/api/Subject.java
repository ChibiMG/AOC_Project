package api;

import api.Observer;

/**
 * Interface of Capteur
 * @author Maud Garçon & Emmanuel Chauvel
 */

public interface Subject {

    /**
     * Link the subject with the observer
     * @param o an Observer
     */
    void attach(Observer o);

    /**
     * Delete the link between the subject and the observer
     * @param o an Observer
     */
    void detach(Observer o);

}
