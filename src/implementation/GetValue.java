package implementation;

import api.CapteurAsync;
import api.ObserverAsync;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {

    private CapteurAsync capteur;
    private ObserverAsync canal;

    public GetValue(CapteurAsync capteurAsync, ObserverAsync canal) {
        this.capteur = capteurAsync;
        this.canal = canal;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        return capteur.getValue();
    }
}
