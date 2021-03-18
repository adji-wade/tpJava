package sn.isi.dao;

import sn.isi.entities.Produit;
import sn.isi.entities.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProduitImp implements IProduit {
    Scanner s = new Scanner(System.in);
    DB db = new DB();
    @Override
    public int Add(Produit p) throws Exception {
        db.open();

        System.out.println("Entrer la reference du produit");
        p.setRef(s.nextLine());
        System.out.println("Entrer le nom du produit");
        p.setNom(s.nextLine());
        System.out.println("Entrer l'id du user");
        p.getUser().setId(Integer.parseInt(s.nextLine()));
        String sql = "INSERT INTO produit VALUES (?, ?, ?)";
        db.init(sql);
        db.getPst().setString(1,p.getRef());
        db.getPst().setString(2,p.getNom());
        db.getPst().setInt(3,p.getUser().getId());

        int ok = db.executeUpdate();
        return ok   ;
    }

    @Override
    public int Delete(String  ref) throws Exception {
        Produit p = null;
        db.open();
        String sql = "DELETE FROM produit WHERE ref = ?";
        db.init(sql);
        db.getPst().setString(1,ref);
        int ok = db.executeUpdate();

        return ok;
    }

    @Override
    public int update(Produit P) throws Exception {
        db.open();

        System.out.println("Entrer la reference du produit");
        P.setRef(s.nextLine());
        System.out.println("Entrer le nom du produit");
        P.setNom(s.nextLine());
        String sql = "UPDATE produit  SET nom = ? WHERE ref = ? ";
        db.init(sql);
        db.getPst().setString(1,P.getNom());
        db.getPst().setString(2,P.getRef());
      
        int ok = db.executeUpdate();
       return ok;
    }

    @Override
    public Produit get(String id) throws Exception {
        Produit  p = null;
        User u = null;
        db.open();
        String sql = "SELECT * FROM produit WHERE ref = ? ";
        db.init(sql);
        db.getPst().setString(1,id);
        ResultSet rset = db.executeSelect();
      if(rset.next()) {
            p = new Produit();
            p.setRef(rset.getString(1));
            p.setNom(rset.getString(2));
            p.getUser().setId(rset.getInt(3));

        }
   return p;

        }

    @Override
    public List<Produit> liste() throws Exception {
        List<Produit> lProd = new ArrayList<>();
        Produit p = null;
        db.open();
        String sql = "SELECT * FROM produit,user WHERE  id = idU";
        db.init(sql);
        ResultSet rset = db.executeSelect();
        while(rset.next()){
            p = new Produit();
            p.setRef(rset.getString(1));
            p.setNom(rset.getString(2));
            p.getUser().setId(rset.getInt(3));
            lProd.add(p);
        }
        return lProd;
    }
}
