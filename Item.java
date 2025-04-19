public class Item {
    private String titel; // titel
    private String gelezenOp; // gelezen op

    // constructor voor aanmaken van Item met titel en gelezen datum
    public Item(String titel, String gelezenOp) {
        this.titel = titel;
        this.gelezenOp = gelezenOp;
    }

    // getter voor titel
    public String getTitel() {
        return titel;
    }
    // getter voor gelezenop
    public String getGelezenOp() {
        return gelezenOp;
    }
    // getter voor type
    public String getType() {
        return "Item";
    }
    // override van tostring zodat het leesbaar is
    @Override
    public String toString() {
        return titel + " - Gelezen op: " + gelezenOp;
    }
}
