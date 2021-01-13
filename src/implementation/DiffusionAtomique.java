package implementation;

import api.AlgoDiffusion;
import api.CapteurAsync;
import api.ObserverAsync;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DiffusionAtomique implements AlgoDiffusion {

    private CapteurImpl capteur;
    //private Collection<ObserverAsync> canaux;


    @Override
    public void configure(CapteurImpl capteurImpl, Collection<ObserverAsync> canaux) {
        this.capteur = capteurImpl;
        //this.canaux = canaux;
    }

    public void execute() {
        this.capteur.setLock(true);

        capteur.getObs().forEach(observerAsync -> {
            try {
                System.out.println("update lance");
                observerAsync.update(capteur);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        /*if(this.capteur.getObs().isEmpty()) {
            this.capteur.setObs(canaux);
            this.capteur.setLock(false);
        } else {
            this.capteur.setLock(true);
        }*/
    }
}
