
public class Boek {
    private String titel;
    private String genre;
    private String auteur;
    private int aantalPaginas;

    public Boek(String titel, String genre, String auteur, int aantalPaginas) {
        this.titel = titel;
        this.genre = genre;
        this.auteur = auteur;
        this.aantalPaginas = aantalPaginas;

    }

    public String toonDetails() {
        return "Titel: " + titel + ", Genre: " + genre + ", Auteur: " + auteur + ", Aantal Pagina's: " + aantalPaginas;
    }

    public void markeerAlsGelezen() {
        System.out.print("a");
    }

}

