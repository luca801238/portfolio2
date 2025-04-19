import java.util.ArrayList;
import java.util.List;

// Associatie: Aanbevelingen <-> Boek (via methodes en parameters)
// Zonder deze associatie kan er geen aanbeveling gegenereerd worden die aansluit op de voorkeuren en leesgeschiedenis van de gebruiker.

public class Aanbevelingen {
    private List<String> voorkeuren = new ArrayList<>();    // Voorkeuren op genre
    private List<String> gelikedeGenres = new ArrayList<>(); // Gebruiker liket genre
    private List<Boek> gelikedeBoeken = new ArrayList<>();  // Gebruiker liket specifieke boeken

    // User Story:
    // Als gebruiker wil ik boekentips krijgen op basis van mijn leesvoorkeuren zodat ik sneller boeken ontdek die bij mij passen.

    // Genereer aanbevelingen op basis van gelezen boeken en voorkeuren
    public List<Boek> genereerAanbevelingen(List<Boek> gelezenBoeken, List<Boek> beschikbareBoeken) {
        List<String> genresVanLezer = new ArrayList<>();
        List<String> gelezenTitels = new ArrayList<>();

        for (Boek boek : gelezenBoeken) {
            if (boek.getGenre() != null && !genresVanLezer.contains(boek.getGenre())) {
                genresVanLezer.add(boek.getGenre());
            }
            gelezenTitels.add(boek.getTitel());
        }

        List<Boek> aanbevelingen = new ArrayList<>();
        for (Boek boek : beschikbareBoeken) {
            boolean zelfNogNietGelezen = !gelezenTitels.contains(boek.getTitel());
            boolean pastBijLezer = genresVanLezer.contains(boek.getGenre()) || voorkeuren.contains(boek.getGenre());

            if (zelfNogNietGelezen && pastBijLezer) {
                aanbevelingen.add(boek);
            }
        }

        return aanbevelingen;
    }


    // Like een specifiek boek
    public void likeBoek(Boek boek) {
        if (!gelikedeBoeken.contains(boek)) {
            gelikedeBoeken.add(boek);
            System.out.println("Je hebt \"" + boek.getTitel() + "\" geliked.");
        } else {
            System.out.println("Je hebt dit boek al eerder geliked.");
        }
    }



    // Voeg een leesvoorkeur toe (voor aanbevelingen)
    public void pasVoorkeurAan(String nieuwGenre) {
        if (!voorkeuren.contains(nieuwGenre)) {
            voorkeuren.add(nieuwGenre);
            System.out.println("Voorkeur toegevoegd: " + nieuwGenre);
        } else {
            System.out.println("Voorkeur bestaat al.");
        }
    }

    //getter voor voorkeuren
    public List<String> getVoorkeuren() {
        return voorkeuren;
    }

    // getter voor gelikede boeken
    public List<Boek> getGelikedeBoeken() {
        return gelikedeBoeken;
    }

    // Laat voorkeuren zien in console
    public void haalVoorkeurenOp() {
        System.out.println(voorkeuren);
    }
}
