package sn.isi.traitememt;

import sn.isi.entities.*;

import java.util.Scanner;

public class MedecinImplement implements IMedecin {
    Medecin medecin = new Medecin();
    MedecinChef chef = new MedecinChef();
    MedecinSpecialiste specialiste = new MedecinSpecialiste();
    MedecinGeneraliste generaliste = new MedecinGeneraliste();
    @Override
    public Medecin saisir() {
        Scanner sc = new Scanner(System.in);

        Services service =new Services();
        System.out.println("Entre le nom du service");
        service.setNom(sc.nextLine());
        System.out.println("Entre l' id service");
        service.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Entre l' id");
        medecin.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Entre votre nom");
        medecin.setNom(sc.nextLine());
        System.out.println("Entre votre prenom");
        medecin.setPrenom(sc.nextLine());
        System.out.println("Entre le service du medecin");
        medecin.setService(service);
        if(medecin.getService().getNom().equals("medecinChef"))
        {

            System.out.println("Entre le nom du bureau");
            chef.setBureau(sc.nextLine());
        }else if (medecin.getService().getNom().equals("medecinGeneraliste")) {

            System.out.println("Entre les specialités separées par des virgules");
            generaliste.setListeSpecialistes(sc.nextLine());
        }else if (medecin.getService().getNom().equals("medecinSpecialiste") ){

            System.out.println("Entre la specialite ");
            specialiste.setSpecialiste(sc.nextLine());
        }



        return medecin;
    }

    @Override
    public void affichage(Medecin m ) {
        System.out.println("l'identifiant est : "+m.getId());
        System.out.println("le nom est : "+m.getNom());
        System.out.println("le prenom est : "+m.getPrenom());
        System.out.println("le prenom est : "+m.getService().getNom());
        if(medecin.getService().getNom().equals("medecinChef"))
        {

            System.out.println("le bureau du chef est : "+chef.getBureau());
        }else if (medecin.getService().getNom().equals("medecinGeneraliste")) {

            System.out.println("Les specialités sont :"+generaliste.getListeSpecialistes());
        }else if (medecin.getService().getNom().equals("medecinSpecialiste") )
        {

            System.out.println("Sa specialite est "+specialiste.getSpecialiste());
        }
    }
}
