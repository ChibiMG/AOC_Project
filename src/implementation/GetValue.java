package implementation;

import api.CapteurAsync;

import java.util.concurrent.Callable;

/**
 * The GetValue allow to get the Capteur's value
 * @author Maud Garçon & Emmanuel Chauvel
 */

public class GetValue implements Callable<Integer> {

    /**
     * The Capteur on which we do the get value
     */
    private CapteurAsync capteur;

    public GetValue(CapteurAsync capteurAsync) {
        this.capteur = capteurAsync;
    }

    @Override
    public Integer call() throws Exception {
        return capteur.getValue();
    }
}
