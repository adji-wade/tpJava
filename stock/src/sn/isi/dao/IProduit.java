package sn.isi.dao;

import sn.isi.entities.Produit;


import java.util.List;

public interface IProduit {
    public int Add(Produit p) throws Exception;
    public int Delete(String ref) throws Exception;
    public int update(Produit P) throws  Exception;
    public Produit get(String id) throws  Exception;
    public List<Produit> liste() throws Exception;
}
