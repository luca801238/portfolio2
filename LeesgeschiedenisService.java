import java.util.ArrayList;
import java.util.List;

public class LeesgeschiedenisService {
    private List<Item> gelezenItems = new ArrayList<>();

    // 10. Markeer als gelezen
    public void markeerAlsGelezen(Item item) {
        gelezenItems.add(item);
        System.out.println("Gelezen item toegevoegd: " + item.getTitel());
    }

    // 11. Toon alles
    public List<Item> toonLeesoverzicht() {
        return gelezenItems;
    }

    // 12. Filter op type
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
