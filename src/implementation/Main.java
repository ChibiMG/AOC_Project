package implementation;

import api.AlgoDiffusion;
import api.Capteur;
import api.ObserverAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    private static void execDiffusion(AlgoDiffusion diffusion) throws InterruptedException {

        CapteurImpl capteur = new CapteurImpl(diffusion);

        Afficheur afficheur1 = new Afficheur();
        Afficheur afficheur2 = new Afficheur();
        Afficheur afficheur3 = new Afficheur();
        Afficheur afficheur4 = new Afficheur();

        Canal canal1 = new Canal(afficheur1, capteur);
        Canal canal2 = new Canal(afficheur2, capteur);
        Canal canal3 = new Canal(afficheur3, capteur);
        Canal canal4 = new Canal(afficheur4, capteur);

        capteur.attach(canal1);
        capteur.attach(canal2);
        capteur.attach(canal3);
        capteur.attach(canal4);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(capteur::tick, 1, 1, TimeUnit.MILLISECONDS);

        Thread.sleep(55000);
        future.cancel(false);
        Thread.sleep(2500);

        System.out.print("Afficheur 1 : ");
        afficheur1.displayTab();

        System.out.print("Afficheur 2 : ");
        afficheur2.displayTab();

        System.out.print("Afficheur 3 : ");
        afficheur3.displayTab();

        System.out.print("Afficheur 4 : ");
        afficheur4.displayTab();

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("----------------Diffusion atomique------------------");
        execDiffusion(new DiffusionAtomique());

        System.out.println("----------------Diffusion séquentielle--------------");
        execDiffusion(new DiffusionSequentielle());
    }

}