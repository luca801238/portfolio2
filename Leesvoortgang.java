public class Leesvoortgang {
    private int gelezenPaginas;
    private int totaalPaginas;

    public Leesvoortgang(int gelezenPaginas, int totaalPaginas) {
        this.gelezenPaginas = gelezenPaginas;
        this.totaalPaginas = totaalPaginas;
    }

    public double berekenVoortgang() {
        if (totaalPaginas == 0) return 0.0;
        return (double) gelezenPaginas / totaalPaginas;
    }
}
