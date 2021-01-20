# Projet Capteur/Canal/Afficheur - AOC
## M2 MIAGE - Université Rennes 1 - Maud Garçon & Emmanuel Chauvel

Vous trouverez dans ce Git le code source documenté ainsi qu'une version executable de celui-ci en .jar.

### 1. Conception
#### a. Base du projet
Dans ce projet nous avons réalisé la simulation d'un service de diffusion de données.
Pour celui-ci, nous nous sommes aidés de nos cours AOC et ACO, plus particulièrement les design pattern dont Active Object.
Le programme permet de diffuser un flot de valeurs vers abonnés : les Afficheurs dans des Threads différents de la source : le Capteur.
Le projet a pour objectif de mettre en oeuvre du parallélisme d'Observer et il peut être découpé en 4 parties :
-   le Capteur, il diffuse une séquence croissante d'entiers via un compteur qui est incrémenté à intervalle fixe.
-   les Canaux, qui transmettent l'information aux Afficheurs, leur délai de transmission est aléatoire.
-   les Afficheurs il récupère les valeurs diffusées pour les afficher.
-   l'ensemble de politique de diffusion Observer comprenant 3 types de diffusions :
    - la diffusion atomique
    - la diffusion séquentielle
    - la diffusion par époque

![alt text](https://github.com/ChibiMG/AOC_Project/blob/master/Images/schema_aoc.png)

#### b. Diagrammes de class global
Diagramme de class avec les design patterns Strategy & Observer sur la diffusion Atomique
![alt text](https://github.com/ChibiMG/AOC_Project/blob/master/Images/diag_class_3_AO.png)

Diagramme de class avec les design patterns Active Object & Proxy dans le sens update

Diagramme de class avec les design patterns Active Object & Proxy dans le sens getValue

#### c. Diagramme de séquence de la difusion atomique
![alt text](https://github.com/ChibiMG/AOC_Project/blob/master/Images/diag_sec_M1.png)

#### d. Diagramme de séquence de la difusion séquentielle
![alt text](https://github.com/ChibiMG/AOC_Project/blob/master/Images/diag_sec_M2.png)

### 2. Validation

? => résultats attendus et obtenus
