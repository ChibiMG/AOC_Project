package implementation;

import api.AlgoDiffusion;
import api.Capteur;
import api.Observer;
import api.ObserverAsync;

import java.util.ArrayList;
import java.util.Collection;

public class CapteurImpl implements Capteur {

    private final AlgoDiffusion algo;
    private int value;
    private boolean lock;
    private final Collection<ObserverAsync> observerAsyncs;

    public CapteurImpl(AlgoDiffusion algo) {
        value = 0;
        lock = false;
        observerAsyncs = new ArrayList<>();
        this.algo = algo;
        algo.configure(this, this.observerAsyncs);
    }

    public Integer getRawValue() {
        return value;
    }

    @Override
    public Integer getValue() {
        return algo.valueRead();
    }

    @Override
    public void tick() {
        if (!lock){
            value++;
            this.algo.execute();
        }
    }

    /**
     * Set the lock of the Capteur
     * @param lock of the Capteur
     */
    public void setLock(boolean lock) {
        this.lock = lock;
    }

    /**
     * Attach an observer to the Capteur observers list
     * @param o an Observer
     */
    public void attach(Observer o) {
        assert o instanceof ObserverAsync;
        observerAsyncs.add((ObserverAsync) o);
    }

    /**
     * Detachcan observer to the Capteur observers list
     * @param o an Observer
     */
    public void detach(Observer o) {
        observerAsyncs.remove(o);
    }
}
