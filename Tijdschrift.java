public class Tijdschrift extends Item {
    private String editie;

    public Tijdschrift(String titel, String editie, String gelezenOp) {
        super(titel, gelezenOp);
        this.editie = editie;
    }

    public String getEditie() {
        return editie;
    }

    @Override
    public String getType() {
        return "Tijdschrift";
    }

    @Override
    public String toString() {
        return getTitel() + " (editie: " + editie + ") - Gelezen op: " + getGelezenOp();
    }
}
