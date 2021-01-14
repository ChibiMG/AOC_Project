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
    private Collection<ObserverAsync> observerAsyncs;

    public CapteurImpl(AlgoDiffusion algo) {
        value = 0;
        lock = false;
        observerAsyncs = new ArrayList<>();
        this.algo = algo;
        algo.configure(this, this.observerAsyncs);
    }

    @Override
    public Integer getValue() {
        algo.valueRead();
        return value;
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

    /**
     * Get the list of Capteur observers
     * @return Collection<ObserverAsync>
     */
    public Collection<ObserverAsync> getObs() {
        return observerAsyncs;
    }

    /**
     * Set the list of Capteur observers
     * @param canaux is capteur observers
     */
    public void setObs(Collection<ObserverAsync> canaux){
        this.observerAsyncs = canaux;
    }
}
