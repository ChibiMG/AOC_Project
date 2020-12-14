package implementation;

import api.Capteur;
import api.CapteurAsync;
import api.ObserverAsync;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements CapteurAsync, ObserverAsync {

    private Afficheur afficheur;
    private Capteur capteur;

    private Random random;

    private ScheduledExecutorService scheduledExecutorService;

    public Canal(Afficheur afficheur, Capteur capteur) {
        this.afficheur = afficheur;
        this.capteur = capteur;
        this.random = new Random();
        //TODO
        this.scheduledExecutorService = null;
    }

    //On ne renvoie pas un future (cf td) mais Integer
    //Dans le but de garder un unique CapteurAsync et ne pas avoir 2 methodes getValue
    //Dans 2 CapteurAsync différents (getValue : Future<Integer> & getValue : Integer)
    //Etre plus proche du diag de class du TD
    //Pour le future, il est cantonné au scheduler
    //On ne renvoie pas un future, mais la valeur qu'il renvoie quand il est pret
    @Override
    public Integer getValue() throws ExecutionException, InterruptedException {
        GetValue getValue = new GetValue(capteur);
        return scheduledExecutorService.schedule(getValue, random.nextInt(random.nextInt()), TimeUnit.MILLISECONDS).get();
    }

    //On ne renvoie pas un future (cf td) mais rien
    //Dans le but de garder un unique Observer et ne pas avoir 2 methodes update
    //Dans 2 Observer différents (update : Future<Void> & update : Void)
    //Etre plus proche du diag de class du TD
    @Override
    public void update(CapteurAsync capteurAsync) throws ExecutionException, InterruptedException {
        Update update = new Update(afficheur, this);
        scheduledExecutorService.schedule(update , random.nextInt(random.nextInt()), TimeUnit.MILLISECONDS).get();
    }
}
