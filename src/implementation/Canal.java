package implementation;

import api.Capteur;
import api.CapteurAsync;
import api.ObserverAsync;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
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
        scheduledExecutorService = Executors.newScheduledThreadPool(2);

    }

    @Override
    public Integer getValue() throws ExecutionException, InterruptedException {
        GetValue getValue = new GetValue(capteur);
        return scheduledExecutorService.schedule(getValue, random.nextInt(500), TimeUnit.MILLISECONDS).get();
    }

    @Override
    public void update(CapteurAsync capteurAsync) throws ExecutionException, InterruptedException {
        Update update = new Update(afficheur, this);
        scheduledExecutorService.schedule(update , random.nextInt(500), TimeUnit.MILLISECONDS).get();
    }
}