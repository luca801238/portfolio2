public class Item {
    private String titel;
    private String gelezenOp;

    public Item(String titel, String gelezenOp) {
        this.titel = titel;
        this.gelezenOp = gelezenOp;
    }

    public String getTitel() {
        return titel;
    }

    public String getGelezenOp() {
        return gelezenOp;
    }

    public String getType() {
        return "Item";
    }

    @Override
    public String toString() {
        return titel + " - Gelezen op: " + gelezenOp;
    }
}
