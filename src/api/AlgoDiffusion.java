package api;

import implementation.CapteurImpl;

public interface AlgoDiffusion {

    /**
     *
     */
    public void configure(CapteurImpl capteurImpl);

    /**
     *
     */
    public void execute();

}
