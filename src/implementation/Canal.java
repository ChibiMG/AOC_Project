package implementation;

import api.Capteur;
import api.Observer;
import api.ObserverAsync;

import java.util.concurrent.Future;

public class Canal implements Capteur, ObserverAsync {

    @Override
    public void attach(ObserverAsync o) {

    }

    @Override
    public void detach(ObserverAsync o) {

    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void tick() {

    }

    @Override
    public Future update() {
        return null;
    }
}
