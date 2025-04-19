// Associatie: Item <-> subklassen (boek, tijdschrift), leesoverzicht <-> item
// User Story: Als gebruiker wil ik eenvoudig bijhouden welke boeken en tijdschriften ik heb gelezen zodat ik een overzicht heb van mijn leesgeschiedenis.
// Zonder deze associatie kan het systeem niet op een juiste manier bijhouden wat de gebruiker heeft gelezen, of daar later op filteren.

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
