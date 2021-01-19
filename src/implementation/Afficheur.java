package implementation;

import api.CapteurAsync;
import api.ObserverAsync;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ExecutionException;

public class Afficheur implements ObserverAsync {

    private List<Integer> values;

    public Afficheur() {
        this.values = new ArrayList<>();
    }

    @Override
    public void update(CapteurAsync capteurAsync) {
        try {
            values.add(capteurAsync.getValue());
            //System.out.println(values.toString());
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * Function to display the table of values
     */
    public void displayTab(){
        System.out.println(values.toString());
    }
}
