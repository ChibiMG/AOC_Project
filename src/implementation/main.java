package implementation;


import api.AlgoDiffusion;
import api.Capteur;
import api.ObserverAsync;
import implementation.*;

import java.util.ArrayList;
import java.util.List;

public class main  {


    static void execDiffusion(CapteurImpl capteur) throws InterruptedException {

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

        //for(int i=0; i==4; i++){
            capteur.tick();
        //}

        System.out.print("Afficheur 1 : ");
        afficheur1.displayTab();

        System.out.print("Afficheur 2 : ");
        afficheur2.displayTab();

        System.out.print("Afficheur 3 : ");
        afficheur3.displayTab();

        System.out.print("Afficheur 4 : ");
        afficheur4.displayTab();

        //AlgoDiffusion algo = capteur.getAlgo();
        //Thread.sleep(1000);
    }






    public static void main(String[] args) throws InterruptedException {
        System.out.println("----------------Diffusion atomique------------------");
        CapteurImpl capteur = new CapteurImpl(new DiffusionAtomique());
        execDiffusion(capteur);


        //System.out.println("----------------Diffusion séquentielle--------------");
        //execDiffusion(new CapteurImpl(new DiffusionSequentielle()));


    }

}