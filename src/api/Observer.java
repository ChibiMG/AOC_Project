package api;

import java.util.concurrent.ExecutionException;

/**
 * Interface of ObserverAsync
 * @author Maud Garçon & Emmanuel Chauvel
 */

public interface Observer<T> {

    /**
     * Notify Afficheur that the value of Capteur has changed
     * @param subject
     * @throws ExecutionException
     * @throws InterruptedException
     */
    void update(T subject) throws ExecutionException, InterruptedException;

}
