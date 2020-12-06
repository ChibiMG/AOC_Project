package implementation;

import api.Capteur;
import api.Observer;
import api.ObserverAsync;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

public class CapteurImpl implements Capteur {

    private int value;
    private boolean lock;

    //compteur en attendant de trouver mieux : permet de décrémenter
    //le nb d'oberser a voir fait getValue() pour que lorsqu'il est
    //a 0 on puisse delock
    private int compteur;

    //il n'utilise pas les futures
    private Collection<ObserverAsync> observerAsyncs;

    public CapteurImpl() {
        value = 0;
        lock = false;
        compteur = 0;
        observerAsyncs = new ArrayList<>();
    }

    @Override
    public Integer getValue() {
        compteur--;
        if (compteur == 0) {
            lock = false;
        }
        return value;
    }

    //lors du tick on dit au observer qu'on a update le tick
    @Override
    public void tick() {
        if (!lock){
            value++;
            observerAsyncs.forEach(observerAsync -> {
                try {
                    observerAsync.update(this);
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
            lock = true;
            compteur = observerAsyncs.size();
        }
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    //On ajoute l'observer o aux observer du capteur
    public void attach(Observer o) {
        assert o instanceof ObserverAsync;
        observerAsyncs.add((ObserverAsync) o);
    }

    //on enlève l'observer o aux observer du capteur
    public void detach(Observer o) {
        observerAsyncs.remove(o);
    }

}
