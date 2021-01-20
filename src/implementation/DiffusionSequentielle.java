package implementation;

import api.AlgoDiffusion;
import api.CapteurAsync;
import api.ObserverAsync;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DiffusionSequentielle implements AlgoDiffusion {


    private CapteurImpl capteur;
    private Collection<ObserverAsync> canaux;
    private Integer value;
    private Integer compteur;

    @Override
    public void configure(CapteurImpl capteur, Collection<ObserverAsync> canaux) {
        this.capteur = capteur;
        this.compteur = 0;
        this.canaux = canaux;
    }


    public void execute() {
        if (compteur == 0) {

            value = capteur.getRawValue();
            compteur = canaux.size();

            canaux.forEach(observerAsync -> {
                try {
                    observerAsync.update(capteur);
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public Integer valueRead() {
        compteur--;
        return value;
    }
}
