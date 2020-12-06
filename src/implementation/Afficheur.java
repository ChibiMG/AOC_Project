package implementation;

import api.CapteurAsync;
import api.ObserverAsync;

import java.util.concurrent.ExecutionException;

public class Afficheur implements ObserverAsync {

    @Override
    public void update(CapteurAsync capteurAsync) {
        try {
            capteurAsync.getValue();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
