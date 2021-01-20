package api;

import implementation.CapteurImpl;

import java.util.Collection;
import java.util.List;

public interface AlgoDiffusion {

    /**
     * @param capteurImpl Capteur which produce the tick
     * @param canals Canals which are between Afficheur and CapteurImpl
     * Associate capteurImpl with canals
     */
    public void configure(CapteurImpl capteurImpl, Collection<ObserverAsync> canals);

    /**
     * Contains the algorithm of the AlgoDiffusion
     */
    public void execute();

    /**
     * Permit to read the actual value
     */
    public Integer valueRead();

}
