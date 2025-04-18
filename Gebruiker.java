import java.util.List;
import java.util.ArrayList;
public class Gebruiker {
    private int id;
    private String naam;
    private String email;

    public Gebruiker(int id, String naam, String email) {
        this.id = id;
        this.naam = naam;
        this.email = email;
    }

    public void voegBoekToe() {
        System.out.print("boek toegevoegd.");
    }
    public List<BoekTip> genereerTips() {
        List<BoekTip> tips = new ArrayList<>();

        return tips;
    }

}