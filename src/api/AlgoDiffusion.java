package api;

import implementation.CapteurImpl;

import java.util.Collection;

/**
 * Interface of diffusion algorithms (DiffusionAtomique, DiffusionParEpoque and DiffusionSequentielle)
 * @author Maud Garçon & Emmanuel Chauvel
 */

public interface AlgoDiffusion {

    /**
     * Associate capteurImpl with canals
     * @param capteurImpl Capteur which produce the tick
     * @param canals Canals which are between Afficheur and CapteurImpl
     */
    void configure(CapteurImpl capteurImpl, Collection<ObserverAsync> canals);

    /**
     * Contains the algorithm of the AlgoDiffusion
     */
    void execute();

    /**
     * Permit to read the actual value
     */
    Integer valueRead();

}
