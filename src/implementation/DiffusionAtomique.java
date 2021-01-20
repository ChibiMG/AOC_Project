package implementation;

import api.AlgoDiffusion;
import api.ObserverAsync;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

/**
 * The first type of diffusion :
 * The Capteur write the sequence V1, V2, V3...
 * All Afficheur read V1, V2, V3...
 * @author Maud Garçon & Emmanuel Chauvel
 */

public class DiffusionAtomique implements AlgoDiffusion {

    /**
     * The DiffusionAtomique's Capteur
     */
    private CapteurImpl capteur;

    /**
     * The DiffusionAtomique's Canal list
     */
    private Collection<ObserverAsync> canaux;

    /**
     * The DiffusionAtomique's Compteur to count the number of Canal must read values
     */
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
