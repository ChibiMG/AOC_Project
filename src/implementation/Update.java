package implementation;

import api.CapteurAsync;
import api.ObserverAsync;

import java.util.concurrent.Callable;

public class Update implements Callable<Void> {
    /**
     *
     * @return
     * @throws Exception
     */

    private ObserverAsync observerAsync;
    private CapteurAsync capteurAsync;

    public Update(ObserverAsync observerAsync, CapteurAsync capteurAsync) {
        this.observerAsync = observerAsync;
        this.capteurAsync = capteurAsync;
    }

    @Override
    public Void call() throws Exception {
        observerAsync.update(capteurAsync);
        return null;
    }
}
