import java.util.ArrayList;
import java.util.List;

public class Leesvoorkeur {
    private List<String> favorieteGenres = new ArrayList<>();
    private List<Boek> gelezenBoeken = new ArrayList<>();

    public void voegGenreToe(String genre) {
        favorieteGenres.add(genre);
    }

    public List<String> getFavorieteGenres() {
        return favorieteGenres;
    }

    public List<Boek> getGelezenBoeken() {
        return gelezenBoeken;
    }
}
