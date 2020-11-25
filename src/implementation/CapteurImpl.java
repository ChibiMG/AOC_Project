package implementation;

import api.*;

import java.util.Collection;

public class CapteurImpl implements Capteur {

    private int value;
    private boolean lock;

    private Collection<ObserverdeCapteur> observerdeCapteurs;
    private Collection<ObserverAsync> observerAsyncs;

    public CapteurImpl() {
        value = 0;
        lock = false;
    }

    //On ajoute l'observer o aux observer du capteur
    @Override
    public void attach(ObserverAsync o) {
        observerAsyncs.add(o);
    }

    //on enlève l'observer o aux observer du capteur
    @Override
    public void detach(ObserverAsync o) {
        observerAsyncs.remove(o);
    }

    @Override
    public int getValue() {
        return value;
    }

    //lors du tick on dit au observer qu'on a update le tick
    @Override
    public void tick() {
        if (!lock){
            value++;
            observerAsyncs.forEach(observerAsync -> observerAsync.update());
            lock = true;
        }
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    }
}
