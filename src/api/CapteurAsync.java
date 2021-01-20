package api;

import java.util.concurrent.ExecutionException;

/**
 * Interface of Capteur & Canal
 * @author Maud Garçon & Emmanuel Chauvel
 */

public interface CapteurAsync {

    /**
     * @return the value corresponding of the last "tick"
     * @throws ExecutionException
     * @throws InterruptedException
     */
    Integer getValue() throws ExecutionException, InterruptedException;
}
