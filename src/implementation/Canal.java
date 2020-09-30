package implementation;

import api.Capteur;
import api.Observer;
import api.ObserverdeCapteur;

public class Canal implements Capteur, ObserverdeCapteur {
    @Override
    public void attach(Observer o) {

    }

    @Override
    public void detach(Observer o) {

    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void tick() {

    }
}
