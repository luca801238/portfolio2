public class Maandrapport {
    private String maand;
    private int totaalGelezen;

    public Maandrapport(String maand, int totaalGelezen) {
        this.maand = maand;
        this.totaalGelezen = totaalGelezen;
    }

    public String toonOverzicht() {
        return "Maand: " + maand + ", Totaal gelezen: " + totaalGelezen + " pagina's";
    }
}
