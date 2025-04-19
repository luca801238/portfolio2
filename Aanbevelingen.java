import java.util.ArrayList;
import java.util.List;

// Associatie: Aanbevelingen <-> Boek (via methodes en parameters)
// Zonder deze associatie kan er geen aanbeveling gegenereerd worden die aansluit op de voorkeuren en leesgeschiedenis van de gebruiker.


public class Aanbevelingen {
    private List<String> voorkeuren = new ArrayList<>(); // Wordt gebruikt om aanbevelingen te filteren op genres die de gebruiker interessant vindt.
    private List<String> likes = new ArrayList<>(); // Likes geven voorkeuren aan, wat toekomstige aanbevelingen kan beïnvloeden.

    // Alle functies hier zijn van dezelfde User Story.
    // User Story: Als gebruiker wil ik boekentips krijgen op basis van mijn leesvoorkeuren zodat ik sneller boeken ontdek die bij mij passen.


    // Genereer aanbevelingen op basis van eerder gelezen boeken
    // Doet het belangrijkste van de User Story: geeft boekentips die passen bij wat de gebruiker leuk vindt.
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

    //  Het liken van een boek
    // Likes helpen voorkeuren bepalen: maakt aanbevelingen persoonlijker.
    public void likeBoek(Boek boek) {
        if (!likes.contains(boek.getGenre())) {
            likes.add(boek.getGenre());
        }
        System.out.println("Je hebt " + boek.getTitel() + " geliked.");
    }

    // Leesvoorkeur aanpassen
    // Gebruiker kan voorkeuren zelf instellen: zorgt voor betere tips.
    public void pasVoorkeurAan(String nieuwGenre) {
        if (!voorkeuren.contains(nieuwGenre)) {
            voorkeuren.add(nieuwGenre);
            System.out.println("Voorkeur toegevoegd: " + nieuwGenre);
        } else {
            System.out.println("Voorkeur bestaat al.");
        }
    }

    // Leesvoorkeur ophalen
    // Laat voorkeuren zien: zodat de gebruiker ze kan bekijken of aanpassen.
    public void haalVoorkeurenOp() {
        System.out.println(voorkeuren);
    }
}
