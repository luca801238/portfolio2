import java.util.ArrayList;
import java.util.List;

public class Aanbevelingen {
    private List<String> voorkeuren = new ArrayList<>(); // Hier worden de voorkeuren opgeslagen
    private List<String> likes = new ArrayList<>();
    private List<Boek> alleBoeken = new ArrayList<>();

    public Aanbevelingen() {
        // Voorbeeldboeken met genre toegevoegd
        alleBoeken.add(new Boek("Dune", "2025-04-01", "Sciencefiction"));
        alleBoeken.add(new Boek("Foundation", "2025-04-01", "Sciencefiction"));
        alleBoeken.add(new Boek("Pride and Prejudice", "2025-04-01", "Romantiek"));
        alleBoeken.add(new Boek("The Hobbit", "2025-04-01", "Fantasy"));
    }

    // 6. Genereer aanbevelingen op basis van eerder gelezen boeken
    public List<Boek> genereerAanbevelingen(List<Boek> gelezenBoeken) {
        List<String> genres = new ArrayList<>();
        List<String> gelezenTitels = new ArrayList<>();

        for (Boek boek : gelezenBoeken) {
            if (!genres.contains(boek.getGenre())) {
                genres.add(boek.getGenre());
            }
            if (!gelezenTitels.contains(boek.getTitel())) {
                gelezenTitels.add(boek.getTitel());
            }
        }

        List<Boek> aanbevelingen = new ArrayList<>();
        for (Boek boek : alleBoeken) {
            if (genres.contains(boek.getGenre()) && !gelezenTitels.contains(boek.getTitel())) {
                aanbevelingen.add(boek);
            }
        }

        return aanbevelingen;
    }

    // 7. Boek liken
    public void likeBoek(Boek boek) {
        if (!likes.contains(boek.getGenre())) {
            likes.add(boek.getGenre());
        }
        System.out.println("Je hebt " + boek.getTitel() + " geliked.");
    }

    // 8. Voorkeur aanpassen
    public void pasVoorkeurAan(String nieuwGenre) {
        if (!voorkeuren.contains(nieuwGenre)) {
            voorkeuren.add(nieuwGenre);
            System.out.println("Voorkeur toegevoegd: " + nieuwGenre);
        } else {
            System.out.println("Voorkeur bestaat al.");
        }
    }

    // 9. Voorkeuren ophalen
    public void haalVoorkeurenOp() {
        System.out.println(voorkeuren);
    }
}
