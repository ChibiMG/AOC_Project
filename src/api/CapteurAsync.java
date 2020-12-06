package api;

import java.util.concurrent.ExecutionException;

public interface CapteurAsync {

    public Integer getValue() throws ExecutionException, InterruptedException;
}
