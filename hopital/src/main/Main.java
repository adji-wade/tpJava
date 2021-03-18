package main;

import sn.isi.entities.Medecin;
import sn.isi.traitememt.IMedecin;
import sn.isi.traitememt.MedecinImplement;

public class Main {
    public static void main(String[] args) {
        IMedecin med = new MedecinImplement();
        Medecin m = med.saisir();
        med.affichage(m);
    }
}
