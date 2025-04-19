import java.util.ArrayList;
import java.util.List;

// Associatie: Interface <-> Boek
// Deze associatie is nodig om boeken aan de bibliotheek van de gebruiker toe te voegen en te gebruiken voor verdere interacties.


public class Interface {
    private List<Boek> boeken = new ArrayList<>(); // // Lijst van boeken die de gebruiker heeft toegevoegd.

    // passende user story:
    // Als gebruiker wil ik een eenvoudige interface zodat ik zonder moeite mijn boeken en voortgang kan bijhouden.

    // Berekent voortgang als percentage
    // // Deze methode berekent de voortgang van een boek op basis van het aantal gelezen pagina's
    public double berekenVoortgang(Boek boek) {
        if (boek.getTotaalPaginas() == 0) return 0;
        return ((double) boek.getGelezenPaginas() / boek.getTotaalPaginas()) * 100;
    }

    // Voeg boek toe
    // Voegt een nieuw boek toe aan de lijst van boeken.
    public void voegBoekToe(Boek boek) {
        boeken.add(boek);
        System.out.println("Boek toegevoegd: " + boek.getTitel());
    }

    // Toon invoervelden afhankelijk van type
    // Deze methode toont invoervelden afhankelijk van het type item (bijv. boek of tijdschrift).
    public void toonInvoerFormulier(String type) {
        if (type.equalsIgnoreCase("Boek")) {
            System.out.println("Voer in: Titel, Aantal Pagina’s");
        } else if (type.equalsIgnoreCase("Tijdschrift")) {
            System.out.println("Voer in: Titel, Editie, Datum");
        } else {
            System.out.println("Onbekend type.");
        }
    }

    // Toon alle boeken die zijn toegevoegd
    public void getBoeken() {
        System.out.println(boeken);
    }

    // Return de lijst van boeken
    public List<Boek> getBoekenLijst() {
        return boeken;
    }
}
