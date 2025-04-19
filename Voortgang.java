import java.util.ArrayList;
import java.util.List;

public class Voortgang {
    private List<Boek> gelezenBoeken = new ArrayList<>(); // Lijst van gelezen boeken

    // Passende User Story:
    // Als gebruiker wil ik mijn leesvoortgang eenvoudig kunnen bijhouden zodat ik een duidelijk overzicht heb van mijn vooruitgang.

    // Voer aantal gelezen pagina’s in
    // Deze methode stelt de gebruiker in staat om het aantal gelezen pagina's voor een boek bij te werken.
    public void voerGelezenPaginasIn(Boek boek, int paginas) {
        boek.setGelezenPaginas(paginas);

        if (!gelezenBoeken.contains(boek)) {
            gelezenBoeken.add(boek);
        }

        if (checkBoekVoltooid(boek)) {
            System.out.println("Gefeliciteerd! Je hebt " + boek.getTitel() + " uitgelezen.");
        } else {
            System.out.println("Voortgang bijgewerkt: " + paginas + "/" + boek.getTotaalPaginas() + " pagina's.");
        }
    }

    // Genereer maandelijkse terugblik
    // Deze methode toont een terugblik op de boeken die in de opgegeven maand volledig zijn gelezen.
    public void genereerMaandelijkseTerugblik(String maandNaam) {
        System.out.println("\n📅 Terugblik voor " + maandNaam + ":");

        int totaalPaginas = 0;
        for (Boek boek : gelezenBoeken) {
            if (boek.getGelezenPaginas() == boek.getTotaalPaginas()) {
                System.out.println("- " + boek.getTitel());
                totaalPaginas += boek.getTotaalPaginas();
            }
        }

        System.out.println("Totaal gelezen pagina’s: " + totaalPaginas);
    }

    // Controleer of boek uit is
    // Deze methode controleert of een boek volledig is gelezen.
    public boolean checkBoekVoltooid(Boek boek) {
        return boek.getGelezenPaginas() == boek.getTotaalPaginas();
    }
}
