package implementation;

import api.AlgoDiffusion;
import api.CapteurAsync;

import java.util.List;

public class DiffusionSequentielle implements AlgoDiffusion {

    private CapteurImpl capteur;
    private List<CapteurAsync> canals;
    private Integer value;

    @Override
    public void configure(CapteurImpl capteur) {
        this.capteur = capteur;
        this.canals = canals;
    }


    public void execute() {
        if (this.capteur.getObs().isEmpty()) {
            value = this.capteur.getValue();
            this.capteur.setObs(canals);
            this.capteur.setLock(false);
        } else {
            this.capteur.setLock(true);
        }
    }

    public Integer getVal() {
        return value;
    }
}
