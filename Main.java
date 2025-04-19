import java.util.*;

// associaties:
// Aanbevelingen <-> Boek           aanbevelingen genereren op basis van gelezen boeken/voorkeuren
// Interface <-> Boek               boeken toevoegen en beheren
// Leesoverzicht <-> Item           leesgeschiedenis bijhouden
// Voortgang <-> Boek               voortgang meten van gelezen boeken
// Tijdschrift <-> Item             polymorfisme voor leesmateriaal

// Al deze associaties zijn essentieel om de user stories volledig te ondersteunen.
// Zonder deze koppelingen zou de functionaliteit onvolledig of onbruikbaar zijn.


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Aanbevelingen aanbevelingen = new Aanbevelingen();
        Leesoverzicht leesoverzicht = new Leesoverzicht();
        Interface eenInterface = new Interface();
        Voortgang voortgang = new Voortgang();
        List<Boek> tips = new ArrayList<>();




        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("[1] Mijn aanbevelingen");
            System.out.println("[2] Mijn Boeken");
            System.out.println("[3] Mijn Bibliotheek");
            System.out.println("[4] Mijn Voortgang");
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
                    List<Item> gelezenItems = leesoverzicht.toonLeesoverzicht();
                    List<Boek> gelezenBoeken = new ArrayList<>();
                    for (Item item : gelezenItems) {
                        if (item instanceof Boek) {
                            gelezenBoeken.add((Boek) item);
                        }
                    }

                    List<Boek> beschikbareBoeken = eenInterface.getBoekenLijst(); // boeken die toegevoegd zijn
                    tips = aanbevelingen.genereerAanbevelingen(gelezenBoeken, beschikbareBoeken);

                    if (tips.isEmpty()) {
                        System.out.println("Geen aanbevelingen gevonden.");
                    } else {
                        System.out.println("📚 Aanbevolen boeken:");
                        for (Boek b : tips) {
                            System.out.println("- " + b.getTitel() + " (" + b.getGenre() + ")");
                        }
                    }

                } else if (keuze.equals("2")) {
                    System.out.print("Titel van het boek dat je wil liken: ");
                    String like = scanner.nextLine();
                    for (Boek b : tips) {

                        if (b.getTitel().equalsIgnoreCase(like)) {
                            aanbevelingen.likeBoek(b);
                        }
                    }
                } else if (keuze.equals("3")) {
                    System.out.print("Voer een genre in: ");
                    String genre = scanner.nextLine();
                    aanbevelingen.pasVoorkeurAan(genre);
                } else if (keuze.equals("4")){
                    // misschien aanpassen want als genre voorkeeur null is dan print die []
                    aanbevelingen.haalVoorkeurenOp();
                } else {
                    System.out.print("");
                }

            } else if (keuze.equals("2")) {
                System.out.println("=== MENU ===");
                System.out.println("[1] Een boek als gelezen markeren");
                System.out.println("[2] Leesoverzicht tonen");
                System.out.println("[3] Leesoverzicht filteren");
                System.out.println("[4] Exit");
                keuze = scanner.nextLine();
                if (keuze.equals("1")) {
                    System.out.println("Voer de titel van het boek in dat je wilt markeren:");
                    String titel = scanner.nextLine();
                    for (Boek b : eenInterface.getBoekenLijst()) {

                        if (b.getTitel().equalsIgnoreCase(titel)) {
                            leesoverzicht.markeerAlsGelezen(b);
                        }
                    }
                } else if (keuze.equals("2")) {
                    List<Item> overzicht = leesoverzicht.toonLeesoverzicht();
                    for (Item item : overzicht) {
                        System.out.println("- " + item);
                    }

                } else if (keuze.equals("3")) {
                    System.out.print("Filter op [Boek/Tijdschrift]:");
                    String filter = scanner.nextLine();
                    List<Item> gefilterd = leesoverzicht.filterLeesoverzicht(filter);
                    for (Item item : gefilterd) {
                        System.out.println("- " + item);
                    }
                } else {
                    System.out.print("");
                }

            } else if (keuze.equals("3")) {
                System.out.println("=== MENU ===");
                System.out.println("[1] Voortgang berekenen");
                System.out.println("[2] Boek toevoegen");
                System.out.println("[3] Boeken tonen");
                System.out.println("[4] Exit");
                keuze = scanner.nextLine();
                if (keuze.equals("1")) {
                    System.out.print("Voor welk boek wil je de voortgang berekenen?");
                    String titel = scanner.nextLine();
                    for (Boek b : eenInterface.getBoekenLijst()) {

                        if (b.getTitel().equalsIgnoreCase(titel)) {
                            double voortgangPercentage = eenInterface.berekenVoortgang(b);
                            System.out.println("Voortgang van \"" + b.getTitel() + "\": " + voortgangPercentage + "%");
                        }
                    }
                } else if (keuze.equals("2")) {
                    System.out.print("Nieuw boek toevoegen. Titel: ");
                    String nieuweTitel = scanner.nextLine();
                    System.out.print("Aantal pagina’s: ");
                    String input = scanner.nextLine();
                    // try catch gebruiken want lastig
                    int paginas = 0;
                    try {
                        paginas = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️  Vul een geldig getal in voor aantal pagina's.");
                    }

                    scanner.nextLine();
                    Boek nieuwBoek = new Boek(nieuweTitel, paginas);
                    eenInterface.voegBoekToe(nieuwBoek);
                } else if (keuze.equals("3")) {
                    eenInterface.getBoeken();
                } else {
                    System.out.print("");
                }
            } else if (keuze.equals("4")) {
                System.out.println("=== MENU ===");
                System.out.println("[1] Voer gelezen pagina's in");
                System.out.println("[2] Maandelijkse terugblik");
                System.out.println("[3] Exit");
                keuze = scanner.nextLine();
                if (keuze.equals("1")) {
                    System.out.println("Voor welk boek wil je de gelezen pagina's invoeren?");
                    String titel = scanner.nextLine();
                    for (Boek b : eenInterface.getBoekenLijst()) {
                        if (b.getTitel().equalsIgnoreCase(titel)) {
                            System.out.print("Aantal gelezen pagina's: ");
                            int gelezen = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            voortgang.voerGelezenPaginasIn(b, gelezen);
                        }
                    }
                } else if (keuze.equals("2")) {
                    System.out.print("Maand voor terugblik: ");
                    String maand = scanner.nextLine();
                    voortgang.genereerMaandelijkseTerugblik(maand);
                } else {
                    System.out.print("");
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
