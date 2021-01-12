package api;

import implementation.CapteurImpl;

import java.util.Collection;
import java.util.List;

public interface AlgoDiffusion {

    /**
     *
     */
    public void configure(CapteurImpl capteurImpl, Collection<ObserverAsync> canals);

    /**
     *
     */
    public void execute();

}
