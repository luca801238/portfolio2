import java.util.ArrayList;
import java.util.List;

// Associatie: Leesoverzicht <-> Item (Boek en Tijdschrift)
// Zonder deze associatie is het niet mogelijk om te registreren wat een gebruiker gelezen heeft, of dit op te vragen en filteren.



public class Leesoverzicht {
    private List<Item> gelezenItems = new ArrayList<>(); // // Lijst van items die de gebruiker heeft gelezen

    // User Story die past bij deze class.
    // Als gebruiker wil ik eenvoudig bijhouden welke boeken en tijdschriften ik heb gelezen zodat ik een overzicht heb van mijn leesgeschiedenis.

    // Markeer als gelezen
    // Deze functie voegt een item toe aan de lijst van gelezen items.
    public void markeerAlsGelezen(Item item) {
        if (!gelezenItems.contains(item)) {
            // Vul gelezenOp met de huidige datum
            String vandaag = java.time.LocalDate.now().toString(); // bv. 2025-04-20
            item.setGelezenOp(vandaag);
            gelezenItems.add(item);
        }
    }

    // getter voor gelezen items
    public List<Item> getGelezenItems() {
        return gelezenItems;
    }


    // Filter op type
    // Toont een lijst van gelezen items die overeenkomen met het opgegeven type.
    public List<Item> filterLeesoverzicht(String type) {
        List<Item> resultaat = new ArrayList<>();
        for (Item item : gelezenItems) {
            if (item.getType().equalsIgnoreCase(type)) {
                resultaat.add(item);
            }
        }
        return resultaat;
    }
}
