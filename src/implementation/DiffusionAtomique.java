package implementation;

import api.AlgoDiffusion;
import api.ObserverAsync;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

public class DiffusionAtomique implements AlgoDiffusion {

    private CapteurImpl capteur;
    private int compteur;

    @Override
    public void configure(CapteurImpl capteurImpl, Collection<ObserverAsync> canaux) {
        this.capteur = capteurImpl;
        this.compteur = 0;
    }

    @Override
    public void execute() {
        this.capteur.setLock(true);
        compteur = capteur.getObs().size();

        capteur.getObs().forEach(observerAsync -> {
            try {
                observerAsync.update(capteur);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void valueRead() {
        compteur--;
        if (compteur == 0) {
            capteur.setLock(false);
        }
    }
}
