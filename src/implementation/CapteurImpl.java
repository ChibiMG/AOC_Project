package implementation;

import api.*;

import java.util.Collection;

public class CapteurImpl implements Capteur {

    private int value;
    private boolean lock;

    //compteur en attendant de trouver mieux : permet de décrémenter
    //le nb d'oberser a voir fait getValue() pour que lorsqu'il est
    //a 0 on puisse delock
    private int compteur;

    private Collection<ObserverAsync> observerAsyncs;

    public CapteurImpl() {
        value = 0;
        lock = false;
        compteur = 0;
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
            observerAsyncs.forEach(observerAsync -> observerAsync.update());
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
}
