package implementation;

import api.AlgoDiffusion;

import java.util.concurrent.*;

/**
 * The Main of the program
 * @author Maud Garçon & Emmanuel Chauvel
 */

public class Main {

    private static void execDiffusion(AlgoDiffusion diffusion) throws InterruptedException {

        //Creation of the Capteur
        CapteurImpl capteur = new CapteurImpl(diffusion);

        //Creation of Afficheurs
        Afficheur afficheur1 = new Afficheur();
        Afficheur afficheur2 = new Afficheur();
        Afficheur afficheur3 = new Afficheur();
        Afficheur afficheur4 = new Afficheur();

        //Creation of Canal list and association with an Afficheur and the Capteur
        Canal canal1 = new Canal(afficheur1, capteur);
        Canal canal2 = new Canal(afficheur2, capteur);
        Canal canal3 = new Canal(afficheur3, capteur);
        Canal canal4 = new Canal(afficheur4, capteur);

        //Attach each Canal on the Capteur
        capteur.attach(canal1);
        capteur.attach(canal2);
        capteur.attach(canal3);
        capteur.attach(canal4);

        //Launch the Capteur's tick
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> new Thread(capteur::tick).start(), 1, 600, TimeUnit.MILLISECONDS);

        //Stop the Capteur's tick
        Thread.sleep(20000);
        future.cancel(false);
        Thread.sleep(2500);

        //Display Afficheur's results
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
        //Launch the DiffusionAtomique
        System.out.println("----------------Diffusion atomique------------------");
        execDiffusion(new DiffusionAtomique());

        //Launch the DiffusionSequentielle
        System.out.println("----------------Diffusion séquentielle--------------");
        execDiffusion(new DiffusionSequentielle());

        //Launch the DiffusionParEpoque
        //System.out.println("----------------Diffusion par époque----------------");
        //execDiffusion(new DiffusionParEpoque());
    }

}