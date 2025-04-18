import java.util.ArrayList;
import java.util.List;

public class AanbevelingService {
    private List<String> voorkeuren = new ArrayList<>();
    private List<String> likes = new ArrayList<>();
    private List<Boek> alleBoeken = new ArrayList<>();

    public AanbevelingService() {
        // Voorbeeldboeken met genre toegevoegd
        alleBoeken.add(new Boek("Dune", null, "Sciencefiction"));
        alleBoeken.add(new Boek("Foundation", null, "Sciencefiction"));
        alleBoeken.add(new Boek("Pride and Prejudice", null, "Romantiek"));
        alleBoeken.add(new Boek("The Hobbit", null, "Fantasy"));
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
        System.out.println("Je hebt \"" + boek.getTitel() + "\" geliked.");
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
    public List<Boek> haalVoorkeurenOp() {
        List<Boek> aanbevelingen = new ArrayList<>();
        for (Boek boek : alleBoeken) {
            if (voorkeuren.contains(boek.getGenre())) {
                aanbevelingen.add(boek);
            }
        }
        return aanbevelingen;
    }
}
