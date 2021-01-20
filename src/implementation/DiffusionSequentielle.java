package implementation;

import api.AlgoDiffusion;
import api.ObserverAsync;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

/**
 * The second type of diffusion :
 * The Capteur write the sequence V1, V2, V3...
 * All Afficheur read the same sub suite
 * @author Maud Garçon & Emmanuel Chauvel
 */

public class DiffusionSequentielle implements AlgoDiffusion {

    /**
     * The DiffusionSequentielle's Capteur
     */
    private CapteurImpl capteur;

    /**
     * The DiffusionSequentielle's Canal list
     */
    private Collection<ObserverAsync> canaux;

    /**
     * The DiffusionSequentielle's actual value
     */
    private Integer value;

    /**
     * The DiffusionSequentielle's Compteur to count the number of Canal must read values
     */
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
