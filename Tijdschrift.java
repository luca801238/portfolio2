import java.util.Date;

public class Tijdschrift extends Boek {
    private String editie;
    private Date datum;

    public Tijdschrift(String titel, String genre, String auteur, int aantalPaginas, String editie, Date datum) {
        super(titel, genre, auteur, aantalPaginas);
        this.editie = editie;
        this.datum = datum;
    }

    @Override
    public String toonDetails() {
        return super.toonDetails() + ", Editie: " + editie + ", Datum: " + datum.toString();
    }
}
