package implementation;

import api.Capteur;
import api.Observer;

public class CapteurImpl implements Capteur {

    private int value;
    private boolean lock;

    public CapteurImpl() {
        value = 0;
        lock = false;
    }

    @Override
    public void attach(Observer o) {

    }

    @Override
    public void detach(Observer o) {

    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void tick() {
        value++;
    }
}
