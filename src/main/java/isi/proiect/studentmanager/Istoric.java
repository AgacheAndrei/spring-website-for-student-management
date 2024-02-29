package isi.proiect.studentmanager;

public class Istoric {

    private int id_eveniment;
    private String user;
    private String eveniment;

    public Istoric()
    {

    }
    public Istoric(String user, String eveniment) {
        this.user = user;
        this.eveniment = eveniment;
    }

    public int getId_eveniment() {
        return id_eveniment;
    }

    public void setId_eveniment(int id_eveniment) {
        this.id_eveniment = id_eveniment;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEveniment() {
        return eveniment;
    }

    public void setEveniment(String eveniment) {
        this.eveniment = eveniment;
    }

}
