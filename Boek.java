public class Boek extends Item {
    private int totaalPaginas;
    private int gelezenPaginas;
    private String genre;

    public Boek(String titel, String gelezenOp, String genre) {
        super(titel, gelezenOp);
        this.genre = genre;
    }

    public Boek(String titel, int totaalPaginas) {
        super(titel, null);
        this.totaalPaginas = totaalPaginas;
        this.gelezenPaginas = 0;
    }

    public void setGelezenPaginas(int gelezen) {
        this.gelezenPaginas = gelezen;
    }

    public int getTotaalPaginas() {
        return totaalPaginas;
    }

    public String getGenre(){
        return genre;
    }

    public int getGelezenPaginas() {
        return gelezenPaginas;
    }

    @Override
    public String getType() {
        return "Boek";
    }
}
