package implementation;


import api.AlgoDiffusion;
import api.Capteur;
import implementation.*;

import java.util.List;

public class main  {
// créer capteur, canaux, afficheurs
    AlgoDiffusion algo = new DiffusionAtomique();

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


        Thread.sleep(1000);
    }






    public static void main(String[] args) {
        Capteur capteur = new CapteurImpl();
        Afficheur afficheur1 = new Afficheur();
        Afficheur afficheur2 = new Afficheur();
        Canal canal1 = new Canal(afficheur1, capteur);
        Canal canal2 = new Canal(afficheur2, capteur);
    }

}