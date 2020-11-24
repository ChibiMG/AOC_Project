package implementation;

import api.*;

import java.util.Collection;

public class CapteurImpl implements Capteur {

    private int value;
    private boolean lock;

    private Collection<ObserverdeCapteur> observerdeCapteurs;

    public CapteurImpl() {
        value = 0;
        lock = false;
    }

    @Override
    public void attach(ObserverAsync o) {

    }

    @Override
    public void detach(ObserverAsync o) {

    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void tick() {
        if (!lock){
            value++;
        }
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public Collection<ObserverdeCapteur> getObserverdeCapteurs() {
        return observerdeCapteurs;
    }

    public void setObserverdeCapteurs(Collection<ObserverdeCapteur> observerdeCapteurs) {
        this.observerdeCapteurs = observerdeCapteurs;
    }
}
