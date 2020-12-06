package api;

import java.util.concurrent.ExecutionException;

public interface Observer<T> {

    public void update(T subject) throws ExecutionException, InterruptedException;

}
