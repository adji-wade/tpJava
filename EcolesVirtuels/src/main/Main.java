package main;

import sn.isi.entities.Ecole;
import sn.isi.entities.Specialite;
import sn.isi.traitement.EcoleImple;
import sn.isi.traitement.IEcole;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IEcole ie = new EcoleImple();
        Map<Specialite, Ecole> lEcoles = ie.saisie();
        ie.affichageEcole(lEcoles);
    }
}
