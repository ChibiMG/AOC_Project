package implementation;

import api.AlgoDiffusion;
import api.CapteurAsync;
import api.ObserverAsync;

import java.util.concurrent.*;

/**
 * The Update allow to report a value change
 * @author Maud Garçon & Emmanuel Chauvel
 */

public class Update implements Callable<Void> {

    /**
     * The Afficheur that must be expected from the change
     */
    private ObserverAsync observerAsync;

    /**
     * The Canal which signals the change
     */
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
