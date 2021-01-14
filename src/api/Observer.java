package api;

import java.util.concurrent.ExecutionException;

public interface Observer<T> {

    /**
     * Notify Afficheur that the value of Capteur has changed
     * @param subject
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void update(T subject) throws ExecutionException, InterruptedException;

}
