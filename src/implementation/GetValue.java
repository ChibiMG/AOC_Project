package implementation;

import api.CapteurAsync;
import api.ObserverAsync;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {

    private  CapteurAsync capteurAsync;

    public GetValue(CapteurAsync capteurAsync) {
        this.capteurAsync = capteurAsync;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        return capteurAsync.getValue();
    }
}
