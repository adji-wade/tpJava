package sn.isi.dao;

import sn.isi.entities.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserImp  implements IUser{
    Scanner s = new Scanner(System.in);
    DB db = new DB();
    @Override
    public int Add(User u) throws Exception {
        db.open();
        System.out.println("Entrer le Prenom du user");
        u.setPrenom(s.nextLine());
        System.out.println("Entrer le nom du user");
        u.setNom(s.nextLine());
        System.out.println("Entrer le mail du user");
        u.setEmail(s.nextLine());
        System.out.println("Entrer le password du user");
        u.setPassword(s.nextLine());
        String sql = "INSERT INTO user VALUES (null, ?, ?, ?,?)";
        db.init(sql);
        db.getPst().setString(1,u.getPrenom());
        db.getPst().setString(2,u.getNom());
        db.getPst().setString(3,u.getEmail());
        db.getPst().setString(4,u.getPassword());

        int ok = db.executeUpdate();
        return ok   ;
    }

    @Override
    public int Delete(int id) throws Exception {
        User u = null;
        db.open();
        String sql = "DELETE FROM user WHERE id = ?";
        db.init(sql);
        db.getPst().setInt(1,id);
        int ok = db.executeUpdate();
        return ok;
    }

    @Override
    public int update(User u) throws Exception {
        db.open();
        System.out.println("Entrer le Prenom du user");
        u.setPrenom(s.nextLine());
        System.out.println("Entrer le nom du user");
        u.setNom(s.nextLine());
        System.out.println("Entrer le mail du user");
        u.setEmail(s.nextLine());
        System.out.println("Entrer le password du user");
        u.setPassword(s.nextLine());
        System.out.println("Entrer l'id du user");
        u.setId(Integer.parseInt(s.nextLine()));
        String sql = "UPDATE user SET prenom = ?, nom = ?, email = ?,  password = ? WHERE id = ?";
        db.init(sql);
        db.getPst().setString(1,u.getPrenom());
        db.getPst().setString(2,u.getNom());
        db.getPst().setString(3,u.getEmail());
        db.getPst().setString(4,u.getPassword());
        db.getPst().setInt(5,u.getId());


        int ok = db.executeUpdate();
        return ok;
    }

    @Override
    public User get(int id) throws Exception {
        User  u = null;
        db.open();
        String sql = "SELECT * FROM user WHERE id = ?";
        db.init(sql);
        ResultSet rset = db.executeSelect();
        db.getPst().setInt(1,id);
        if(rset.next()){
            u = new User();
            u.setId(rset.getInt(1));
            u.setPrenom(rset.getString(2));
            u.setNom(rset.getString(3));
            u.setEmail(rset.getString(4));
            u.setPassword(rset.getString(5));

        }
        return u;
    }

    @Override
    public List<User> liste() throws Exception {
        List<User> lUsers = new ArrayList<>();
        db.open();
        String sql = "SELECT * FROM user";
        db.init(sql);
        ResultSet rset = db.executeSelect();
        while(rset.next()){
            User u = new User();
            u.setId(rset.getInt(1));
            u.setPrenom(rset.getString(2));
            u.setNom(rset.getString(3));
            u.setEmail(rset.getString(4));
            u.setPassword(rset.getString(5));
            lUsers.add(u);
        }
        return lUsers;
    }

}

