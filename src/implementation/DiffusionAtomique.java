package implementation;

import api.AlgoDiffusion;
import api.CapteurAsync;
import api.ObserverAsync;

import java.util.Collection;
import java.util.List;

public class DiffusionAtomique implements AlgoDiffusion {

    private CapteurImpl capteur;
    private Collection<ObserverAsync> canaux;


    @Override
    public void configure(CapteurImpl capteurImpl, Collection<ObserverAsync> canaux) {
        this.capteur = capteurImpl;
        this.canaux = canaux;
    }

    public void execute() {
        if(this.capteur.getObs().isEmpty()) {
            this.capteur.setObs(canaux);
            this.capteur.setLock(true);
        } else {
            this.capteur.setLock(false);
        }
    }
}
