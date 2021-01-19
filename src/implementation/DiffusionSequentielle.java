package implementation;

import api.AlgoDiffusion;
import api.CapteurAsync;
import api.ObserverAsync;

import java.util.Collection;
import java.util.List;

public class DiffusionSequentielle implements AlgoDiffusion {


    private CapteurImpl capteur;
    private Collection<ObserverAsync> canals;
    private Integer value;

    @Override
    public void configure(CapteurImpl capteur, Collection<ObserverAsync> canaux) {
        this.capteur = capteur;
        this.canals = canaux;
    }


    public void execute() {
        if (this.capteur.getObs().isEmpty()) {
            value = this.capteur.getValue();
            this.capteur.setObs(canals);
            this.capteur.setSequentialLock(false);
        } else {
            this.capteur.setSequentialLock(true);
        }
    }

    @Override
    public void valueRead() {

    }

    public Integer getVal() {
        return value;
    }
}
