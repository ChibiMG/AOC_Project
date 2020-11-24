package api;

import implementation.CapteurImpl;

public interface AlgoDiffusion {

    /**
     *
     */
    public void configure(CapteurImpl capteur);

    /**
     *
     */
    public void execute();

}
