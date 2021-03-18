package main;

import sn.isi.dao.*;
import sn.isi.entities.Produit;
import sn.isi.entities.User;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        DB db = new DB();
        db.open();
        IUser iuser = new UserImp();
        User user1 = new User();
        // iuser.Add(user1);
       //iuser.update(user1);
        //iuser.Delete(2);
        /*List<User> user = iuser.liste();
        for (User u : user){
            System.out.println("Prenom :"+u.getPrenom());
            System.out.println("Nom :"+u.getNom());
            System.out.println("Email :"+u.getEmail());
            System.out.println("Password :"+u.getPassword());
            System.out.println("Id :"+u.getId());
        }*/
        IProduit iprod = new ProduitImp();
        Produit p1 = new Produit();
        //iprod.Add(p1);

        List<Produit> produit = iprod.liste();

        for (Produit p : produit) {
            if (p.getRef().equals("467")) {
                System.out.println("ref :" + p.getRef());
                System.out.println("Nom :" + p.getNom());
                System.out.println("User :" + p.getUser().getId());

            }
        }
       /* List<Produit> produit = iprod.liste();
        for (Produit p : produit){
            System.out.println("ref :"+p.getRef());
            System.out.println("Nom :"+p.getNom());
            System.out.println("User :"+p.getUser().getId());

        }*/
       // iprod.Add(p1);
       // iprod.update(p1);
        //iprod.Delete("123");
    }
}
