package implementation;

import api.CapteurAsync;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {

    private CapteurAsync capteur;

    public GetValue(CapteurAsync capteurAsync) {
        this.capteur = capteurAsync;
    }

    @Override
    public Integer call() throws Exception {
        return capteur.getValue();
    }
}
