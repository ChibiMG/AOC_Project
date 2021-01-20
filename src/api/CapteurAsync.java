package api;

import java.util.concurrent.ExecutionException;

public interface CapteurAsync {

    /**
     * @return the value corresponding of the last "tick"
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public Integer getValue() throws ExecutionException, InterruptedException;
}
