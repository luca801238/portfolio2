import java.util.ArrayList;
import java.util.List;

public class Voortgang {
    private List<Boek> gelezenBoeken = new ArrayList<>();

    // 16. Voer aantal gelezen pagina’s in
    public void voerGelezenPaginasIn(Boek boek, int paginas) {
        boek.setGelezenPaginas(paginas);

        if (!gelezenBoeken.contains(boek)) {
            gelezenBoeken.add(boek);
        }

        if (checkBoekVoltooid(boek)) {
            System.out.println("Gefeliciteerd! Je hebt \"" + boek.getTitel() + "\" uitgelezen.");
        } else {
            System.out.println("Voortgang bijgewerkt: " + paginas + "/" + boek.getTotaalPaginas() + " pagina's.");
        }
    }

    // 17. Genereer maandelijkse terugblik
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

    // 18. Controleer of boek uit is
    public boolean checkBoekVoltooid(Boek boek) {
        return boek.getGelezenPaginas() == boek.getTotaalPaginas();
    }
}
