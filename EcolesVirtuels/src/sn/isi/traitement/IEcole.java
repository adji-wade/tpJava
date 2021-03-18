package sn.isi.traitement;

import sn.isi.entities.Ecole;
import sn.isi.entities.Specialite;

import java.util.Map;

public interface IEcole {
     public Map<Specialite,Ecole>  saisie();
     public void affichageEcole(Map<Specialite,Ecole>maps);
}
