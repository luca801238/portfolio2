public class Tijdschrift extends Item {
    private String editie; // editie van tijdschrift


    // constructor voor aanmaken van tijdschrift met titel, editie en gelezen op
    public Tijdschrift(String titel, String editie, String gelezenOp) {
        super(titel, gelezenOp);
        this.editie = editie;
    }

    // getter voor editie
    public String getEditie() {
        return editie;
    }
    // override van getType om tijdschrift te retourneren
    @Override
    public String getType() {
        return "Tijdschrift";
    }
    // override van toString voor duidelijke weergave
    @Override
    public String toString() {
        return getTitel() + " (editie: " + editie + ") - Gelezen op: " + getGelezenOp();
    }
}
