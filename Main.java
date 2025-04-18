import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Aanbevelingen aanbevelingen = new Aanbevelingen();
        Leesoverzicht leesoverzicht = new Leesoverzicht();
        Interface eenInterface = new Interface();
        Voortgang voortgang = new Voortgang();

        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("[1] Aanbeveling");
            System.out.println("[2] Leesoverzicht");
            System.out.println("[3] Interface");
            System.out.println("[4] Voortgang");
            System.out.println("[5] Uitloggen");
            System.out.print("Kies een optie: ");

            String keuze = scanner.nextLine();

            if (keuze.equals("1")){
                System.out.println("=== MENU ===");
                System.out.println("[1] Een aanbeveling krijgen");
                System.out.println("[2] Een boek liken");
                System.out.println("[3] Leesvoorkeur aanpassen");
                System.out.println("[4] Leesvoorkeur ophalen");
                System.out.println("[5] Exit");
                keuze = scanner.nextLine();
                if (keuze.equals("1")) {
                    aanbevelingen.genereerAanbevelingen();
                } else if (keuze.equals("2")) {
                    aanbevelingen.likeBoek();
                } else if (keuze.equals("3")) {
                    aanbevelingen.pasVoorkeurAan();
                } else if (keuze.equals("4")){
                    aanbevelingen.haalVoorkeurenOp();
                } else {
                    break;
                }

            } else if (keuze.equals("2")) {
                System.out.println("=== MENU ===");
                System.out.println("[1] Een boek als gelezen markeren");
                System.out.println("[2] Leesoverzicht tonen");
                System.out.println("[3] Leesoverzicht filteren");
                System.out.println("[4] Exit");
                keuze = scanner.nextLine();
                if (keuze.equals("1")) {
                    leesoverzicht.markeerAlsGelezen();
                } else if (keuze.equals("2")) {
                    leesoverzicht.toonLeesoverzicht();
                } else if (keuze.equals("3")) {
                    leesoverzicht.filterLeesoverzicht();
                } else {
                    break;
                }

            } else if (keuze.equals("3")) {
                System.out.println("=== MENU ===");
                System.out.println("[1] Voortgang berekenen");
                System.out.println("[2] Boek toevoegen");
                System.out.println("[3] Boeken tonen");
                System.out.println("[4] Exit");
                keuze = scanner.nextLine();
                if (keuze.equals("1")) {
                    eenInterface.berekenVoortgang();
                } else if (keuze.equals("2")) {
                    eenInterface.voegBoekToe();
                } else if (keuze.equals("3")) {
                    eenInterface.getBoeken();
                } else {
                    break;
                }
            } else if (keuze.equals("4")) {
                System.out.println("=== MENU ===");
                System.out.println("[1] Voer gelezen pagina's in");
                System.out.println("[2] Maandelijkse terugblik");
                System.out.println("[3] Exit");
                keuze = scanner.nextLine();
                if (keuze.equals("1")) {
                    voortgang.voerGelezenPaginasIn();
                } else if (keuze.equals("2")) {
                    voortgang.genereerMaandelijkseTerugblik();
                } else {
                    break;
                }
            } else if (keuze.equals("5")) {
                break;
            } else {
                System.out.println("Voer het getal 1, 2, 3, 4 of 5 in.");
            }

        }

        scanner.close();
    }
}
