import java.util.ArrayList;
import java.util.List;

public class Leesoverzicht {
    private List<Item> gelezenItems = new ArrayList<>(); // // Lijst van items die de gebruiker heeft gelezen

    // User Story die past bij deze class.
    // Als gebruiker wil ik eenvoudig bijhouden welke boeken en tijdschriften ik heb gelezen zodat ik een overzicht heb van mijn leesgeschiedenis.

    // Markeer als gelezen
    // Deze functie voegt een item toe aan de lijst van gelezen items.
    public void markeerAlsGelezen(Item item) {
        gelezenItems.add(item);
        System.out.println("Gelezen item toegevoegd: " + item.getTitel());
    }

    // Toon alles
    // Toont een lijst van alle gelezen items.
    public List<Item> toonLeesoverzicht() {
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
