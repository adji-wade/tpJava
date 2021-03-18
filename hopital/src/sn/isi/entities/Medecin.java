package sn.isi.entities;

public class Medecin extends Personne {

    private Services service;

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }
}
