package api;

import java.util.concurrent.ExecutionException;

public interface CapteurAsync {

    /**
     * @return the value
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public Integer getValue() throws ExecutionException, InterruptedException;
}
