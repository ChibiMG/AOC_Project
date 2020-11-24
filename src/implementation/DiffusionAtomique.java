package implementation;

import api.AlgoDiffusion;

public class DiffusionAtomique implements AlgoDiffusion {

    private CapteurImpl capteur;

    @Override
    public void configure(CapteurImpl capteur) {
        this.capteur = capteur;
    }

    @Override
    public void execute() {

    }
}
