package sn.isi.entities;

public class MedecinGeneraliste extends Medecin {
    private String listeSpecialistes;

    public String getListeSpecialistes() {
        return listeSpecialistes;
    }

    public void setListeSpecialistes(String listeSpecialistes) {
        this.listeSpecialistes = listeSpecialistes;
    }
}
