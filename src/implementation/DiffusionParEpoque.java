package implementation;

import api.AlgoDiffusion;
import api.ObserverAsync;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

/**
 * The third type of diffusion :
 * The Capteur write when it wants
 * All Afficheur read when they want
 * @author Maud Garçon & Emmanuel Chauvel
 */

public class DiffusionParEpoque implements AlgoDiffusion {

    /**
     * The DiffusionParEpoque's Capteur
     */
    private CapteurImpl capteur;

    /**
     * The DiffusionParEpoque's Canal list
     */
    private Collection<ObserverAsync> canaux;

    @Override
    public void configure(CapteurImpl capteurImpl, Collection<ObserverAsync> canaux) {
        this.capteur = capteurImpl;
        this.canaux = canaux;
    }

    @Override
    public void execute() {
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
        return capteur.getRawValue();
    }

}
