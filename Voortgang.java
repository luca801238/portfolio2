import java.util.ArrayList;
import java.util.List;

// Associatie: Voortgang <-> Boek
// Zonder deze associatie is het niet mogelijk om voortgang te registreren, controleren of berekeningen te doen op gelezen pagina's.



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



    // Controleer of boek uit is
    // Deze methode controleert of een boek volledig is gelezen.
    public boolean checkBoekVoltooid(Boek boek) {
        return boek.getGelezenPaginas() == boek.getTotaalPaginas();
    }
}
