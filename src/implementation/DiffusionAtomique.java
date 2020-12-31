package implementation;

import api.AlgoDiffusion;
import api.ObserverAsync;

import java.util.List;

public class DiffusionAtomique implements AlgoDiffusion {

    private CapteurImpl capteur;
    private List<ObserverAsync> canaux;


    @Override
    public void configure(CapteurImpl capteurImpl) {
        this.capteur = capteur;
    }

    public void execute() {
        if(this.capteur.getObs().isEmpty()) {
            this.capteur.setObs(canaux);
            this.capteur.setLock(false);
        } else {
            this.capteur.setLock(true);
        }
    }
}
