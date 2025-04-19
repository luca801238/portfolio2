// Associatie: Boek is een subtype van Item
// User Story: Als gebruiker wil ik eenvoudig bijhouden welke boeken en tijdschriften ik heb gelezen zodat ik een overzicht heb van mijn leesgeschiedenis.
// Deze associatie zorgt ervoor dat boeken dezelfde structuur en methodes delen als tijdschriften, en dus op dezelfde manier verwerkt kunnen worden.

public class Boek extends Item {
    private int totaalPaginas; // total paginas
    private int gelezenPaginas; // gelezen paginas
    private String genre; // genre boek


    // nieuwe constructor die alles bevat
    public Boek(String titel, int totaalPaginas, String genre) {
        super(titel, null); // geen gelezenOp nodig op dit moment
        this.totaalPaginas = totaalPaginas;
        this.gelezenPaginas = 0;
        this.genre = genre;
    }

    // setter voor gelezen paginas
    public void setGelezenPaginas(int gelezen) {
        this.gelezenPaginas = gelezen;
    }
    // getter voor totale paginas
    public int getTotaalPaginas() {
        return totaalPaginas;
    }
    // getter voor genre
    public String getGenre(){
        return genre;
    }
    // getter voor gelezen paginas
    public int getGelezenPaginas() {
        return gelezenPaginas;
    }
    // override van getType uit Item (moet dus boek retourneren)
    @Override
    public String getType() {
        return "Boek";
    }
}
