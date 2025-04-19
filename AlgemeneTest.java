// TEST KLASSE. 3 TESTS HIERONDER.

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class AlgemeneTest {

    // test op aanbevelingen op basis van genre voorkeur
    @Test
    public void testAanbevelingenOpGenreVoorkeur() {
        Aanbevelingen aanbevelingen = new Aanbevelingen();

        Boek gelezen = new Boek("Dune", 300, "Sciencefiction");
        Boek match = new Boek("Neuromancer", 299, "Sciencefiction");
        Boek geenMatch = new Boek("Emma", 391, "Romantiek");

        List<Boek> resultaat = aanbevelingen.genereerAanbevelingen(
                List.of(gelezen),
                List.of(match, geenMatch)
        );

        assertTrue(resultaat.contains(match));
        assertFalse(resultaat.contains(geenMatch));
        System.out.println("Test voltooid.");
    }

    // test maandelijkse terugblik
    @Test
    public void testMaandelijkseTerugblikFilter() {
        Leesoverzicht overzicht = new Leesoverzicht();
        Tijdschrift tijdschrift = new Tijdschrift("Editie Y", "2025", null);
        overzicht.markeerAlsGelezen(tijdschrift); // zet datum automatisch

        // Simuleer dat het op deze dag is gelezen
        tijdschrift.setGelezenOp("2025-04-01");

        List<Item> gelezen = overzicht.getGelezenItems();
        boolean gevonden = gelezen.stream()
                .anyMatch(item -> item.getGelezenOp().startsWith("2025-04"));

        assertTrue(gevonden);
        System.out.println("Test voltooid.");
    }


    // test of het filteren van boeken en tijdschriften werkt
    @Test
    public void testFilterOpBoek() {
        Leesoverzicht overzicht = new Leesoverzicht();
        overzicht.markeerAlsGelezen(new Boek("Boek A", 300, "Fantasy"));
        overzicht.markeerAlsGelezen(new Tijdschrift("Editie X", "2024", null));

        List<Item> alleenBoeken = overzicht.filterLeesoverzicht("Boek");

        assertEquals(1, alleenBoeken.size());
        assertEquals("Boek A", alleenBoeken.get(0).getTitel());
        System.out.println("Test voltooid.");
    }
}