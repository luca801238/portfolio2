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
    }

    // test of boek is voltooid op basis van gelezen paginas
    @Test
    public void testBoekVoltooidWanneerAllePaginasGelezen() {
        Voortgang voortgang = new Voortgang();
        Boek boek = new Boek("1984", 200, "Dystopie");

        voortgang.voerGelezenPaginasIn(boek, 200);

        assertTrue(voortgang.checkBoekVoltooid(boek));
    }

    // test of het filteren van boeken en tijdschriften werkt
    @Test
    public void testFilterOpBoek() {
        Leesoverzicht overzicht = new Leesoverzicht();
        overzicht.markeerAlsGelezen(new Boek("Boek A", 300, "Fantasy"));
        overzicht.markeerAlsGelezen(new Tijdschrift("Editie X", "2024", "2025-04-01"));

        List<Item> alleenBoeken = overzicht.filterLeesoverzicht("Boek");

        assertEquals(1, alleenBoeken.size());
        assertEquals("Boek A", alleenBoeken.get(0).getTitel());
    }
}