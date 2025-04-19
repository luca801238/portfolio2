
// Associatie: Tijdschrift is een subtype van Item
// User Story: Als gebruiker wil ik eenvoudig bijhouden welke boeken en tijdschriften ik heb gelezen zodat ik een overzicht heb van mijn leesgeschiedenis.
// Deze associatie maakt polymorfisme mogelijk binnen het leesoverzicht, zodat het werkt voor meerdere soorten leesmateriaal.

public class Tijdschrift extends Item {
    private String editie; // editie van tijdschrift


    // constructor voor aanmaken van tijdschrift met titel, editie en gelezen op
    public Tijdschrift(String titel, String editie, String gelezenOp) {
        super(titel, gelezenOp);
        this.editie = editie;
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
