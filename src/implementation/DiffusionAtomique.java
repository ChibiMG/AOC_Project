package implementation;

import api.AlgoDiffusion;
import api.ObserverAsync;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

public class DiffusionAtomique implements AlgoDiffusion {

    private CapteurImpl capteur;
    private Collection<ObserverAsync> canaux;
    private int compteur;

    @Override
    public void configure(CapteurImpl capteurImpl, Collection<ObserverAsync> canaux) {
        this.capteur = capteurImpl;
        this.canaux = canaux;
        this.compteur = 0;
    }

    @Override
    public void execute() {
        this.capteur.setLock(true);
        compteur = canaux.size();

        canaux.forEach(observerAsync -> {
            try {
                observerAsync.update(capteur);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public Integer valueRead() {
        compteur--;
        if (compteur == 0) {
            capteur.setLock(false);
        }
        return capteur.getRawValue();
    }
}
