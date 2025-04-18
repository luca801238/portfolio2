import java.util.ArrayList;
import java.util.List;

public class Interface {
    private List<Boek> boeken = new ArrayList<>();

    // 13. Berekent voortgang als percentage
    public double berekenVoortgang(Boek boek) {
        if (boek.getTotaalPaginas() == 0) return 0;
        return ((double) boek.getGelezenPaginas() / boek.getTotaalPaginas()) * 100;
    }

    // 14. Voeg boek toe
    public void voegBoekToe(Boek boek) {
        boeken.add(boek);
        System.out.println("Boek toegevoegd: " + boek.getTitel());
    }

    // 15. Toon invoervelden afhankelijk van type
    public void toonInvoerFormulier(String type) {
        if (type.equalsIgnoreCase("Boek")) {
            System.out.println("Voer in: Titel, Aantal Pagina’s");
        } else if (type.equalsIgnoreCase("Tijdschrift")) {
            System.out.println("Voer in: Titel, Editie, Datum");
        } else {
            System.out.println("Onbekend type.");
        }
    }

    public void getBoeken() {
        System.out.println(boeken);
    }
}
