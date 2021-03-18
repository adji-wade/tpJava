package sn.isi.traitement;

import sn.isi.entities.Ecole;
import sn.isi.entities.Specialite;

import java.util.*;

public class EcoleImple  implements IEcole{
    @Override
    public Map<Specialite, Ecole> saisie() {
            Scanner sc = new Scanner(System.in);
            Map<Specialite, Ecole> lEcole = new Hashtable<Specialite,Ecole>();
            String rep , rep2 = null;
                do {
                    Ecole ecole = new Ecole();
                    Specialite specialite =new Specialite();
                    System.out.println("Entre l' id de l'ecole");
                    ecole.setId(Integer.parseInt(sc.nextLine()));
                    System.out.println("Entrez le nom de l'ecole ");
                    ecole.setNom(sc.nextLine());
                    System.out.println("Entre l' id de la specialite");
                    specialite.setId(Integer.parseInt(sc.nextLine()));
                    System.out.println("Entrez le nom de la Specialite");
                    specialite.setNom(sc.nextLine());
                    ecole.setSpecialite(specialite);
                    System.out.println("voulez vous continuer");
                    rep = sc.nextLine();
                    lEcole.put(specialite,ecole);
                }while(rep.equalsIgnoreCase("o"));

            return lEcole;
    }

    @Override
    public void affichageEcole(Map<Specialite, Ecole> maps) {
        Collection<Ecole>ecoles = maps.values();
        for (Ecole ecole : ecoles){
            System.out.println("id :"+ecole.getId());
            System.out.println("nom :"+ecole.getNom());
            System.out.println("id specialite :"+ecole.getSpecialite().getId());
            System.out.println("nom specialite :"+ecole.getSpecialite().getNom());
        }
       

    }
}
