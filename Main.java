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
                System.out.println("[5] Gelikede boeken ophalen");
                System.out.println("[6] Exit");
                keuze = scanner.nextLine();
                if (keuze.equals("1")) {
                    System.out.println("Voer een boek in dat je wilt controleren:");
                    System.out.print("Titel: ");
                    String titel = scanner.nextLine();

                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();

                    Boek boek = new Boek(titel, 100, genre); // Pagina's zijn hier niet relevant

                    if (aanbevelingen.getVoorkeuren().contains(genre)) {
                        System.out.println("" + boek.getTitel() + " wordt aanbevolen op basis van je voorkeuren.");
                    } else {
                        System.out.println("" + boek.getTitel() + " valt niet binnen je leesvoorkeuren (kijkt naar je favoriete genre).");
                    }

                } else if (keuze.equals("2")) {
                    System.out.print("Titel van het boek dat je wil liken: ");
                    String like = scanner.nextLine();
                    boolean gevonden = false;

                    for (Boek b : eenInterface.getBoekenLijst()) {
                        if (b.getTitel().equalsIgnoreCase(like)) {
                            aanbevelingen.likeBoek(b);
                            gevonden = true;
                            break;
                        }
                    }

                    if (!gevonden) {
                        System.out.println("Boek niet gevonden in je bibliotheek.");
                    }
                } else if (keuze.equals("3")) {
                    System.out.print("Voer een genre in: ");
                    String genre = scanner.nextLine();
                    aanbevelingen.pasVoorkeurAan(genre);
                } else if (keuze.equals("4")) {
                    aanbevelingen.haalVoorkeurenOp();
                } else if (keuze.equals("5")) {
                    List<Boek> gelikedeBoeken = aanbevelingen.getGelikedeBoeken();
                    if (gelikedeBoeken.isEmpty()) {
                        System.out.println("Je hebt nog geen boeken geliket.");
                    } else {
                        System.out.println("Je hebt deze boeken geliket:");
                        for (Boek b : gelikedeBoeken) {
                            System.out.println("- " + b.getTitel());
                        }
                    }
                } else {
                    System.out.print("");
                }

            } else if (keuze.equals("2")) {
                System.out.println("=== MENU ===");
                System.out.println("[1] Een boek als gelezen markeren");
                System.out.println("[2] Een tijdschrift als gelezen markeren");
                System.out.println("[3] Gelezen items ophalen");
                System.out.println("[4] Gelezen items filteren");
                System.out.println("[5] Exit");
                keuze = scanner.nextLine();
                if (keuze.equals("1")) {
                    System.out.print("Titel van het boek dat je als gelezen wilt markeren: ");
                    String titel = scanner.nextLine();
                    boolean gevonden = false;

                    for (Boek b : eenInterface.getBoekenLijst()) { // Alleen boeken die je hebt toegevoegd
                        if (b.getTitel().equalsIgnoreCase(titel)) {
                            leesoverzicht.markeerAlsGelezen(b);
                            System.out.println(" " + b.getTitel() + " is gemarkeerd als gelezen.");
                            gevonden = true;
                            break;
                        }
                    }

                    if (!gevonden) {
                        System.out.println("Boek niet gevonden. Voeg het eerst toe via 'Mijn Bibliotheek > Boek toevoegen'.");
                    }

                } else if (keuze.equals("2")){
                    System.out.print("Titel van het tijdschrift dat je als gelezen wilt markeren: ");
                    String titel = scanner.nextLine();
                    boolean gevonden = false;

                    for (Tijdschrift t : eenInterface.getTijdschriftenLijst()) {
                        if (t.getTitel().equalsIgnoreCase(titel)) {
                            leesoverzicht.markeerAlsGelezen(t);
                            System.out.println("Tijdschrift " + t.getTitel() + " is gemarkeerd als gelezen.");
                            gevonden = true;
                            break;
                        }
                    }

                    if (!gevonden) {
                        System.out.println("Tijdschrift niet gevonden. Voeg het eerst toe via 'Mijn Bibliotheek > Boek toevoegen'.");
                    }
                } else if (keuze.equals("3")) {
                    List<Item> gelezen = leesoverzicht.getGelezenItems();
                    if (gelezen.isEmpty()) {
                        System.out.println("Je hebt nog geen gelezen boeken of tijdschriften.");
                    } else {
                        System.out.println("Gelezen items:");
                        for (Item item : gelezen) {
                            System.out.println("- " + item);
                        }
                    }

                } else if (keuze.equals("4")) {
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
                System.out.println("[2] Item toevoegen");
                System.out.println("[3] Boeken tonen");
                System.out.println("[4] Exit");
                keuze = scanner.nextLine();
                if (keuze.equals("1")) {
                    System.out.print("Voor welk boek wil je de voortgang berekenen?");
                    String titel = scanner.nextLine();
                    for (Boek b : eenInterface.getBoekenLijst()) {

                        if (b.getTitel().equalsIgnoreCase(titel)) {
                            double voortgangPercentage = eenInterface.berekenVoortgang(b);
                            System.out.println("Voortgang van " + b.getTitel() + ": " + String.format("%.2f", voortgangPercentage) + "%");
                        }
                    }
                } else if (keuze.equals("2")) {
                    System.out.print("Welk type wil je toevoegen? (Boek/Tijdschrift): ");
                    String type = scanner.nextLine();
                    eenInterface.toonInvoerFormulier(type);

                    if (type.equalsIgnoreCase("Boek")) {
                        System.out.print("Titel: ");
                        String titel = scanner.nextLine();

                        System.out.print("Aantal pagina’s: ");
                        String paginasInput = scanner.nextLine();
                        int paginas = 0;
                        try {
                            paginas = Integer.parseInt(paginasInput);
                        } catch (NumberFormatException e) {
                            System.out.println("Vul een geldig getal in voor aantal pagina's.");
                            return;
                        }

                        System.out.print("Genre: ");
                        String genre = scanner.nextLine();

                        Boek nieuwBoek = new Boek(titel, paginas, genre);
                        eenInterface.voegBoekToe(nieuwBoek);

                    } else if (type.equalsIgnoreCase("Tijdschrift")) {


                        System.out.print("Titel: ");
                        String titel = scanner.nextLine();

                        System.out.print("Editie: ");
                        String editie = scanner.nextLine();

                        System.out.print("Datum gelezen (bv. 2025-04-19): ");
                        String gelezenOp = scanner.nextLine();

                        Tijdschrift tijdschrift = new Tijdschrift(titel, editie, gelezenOp);
                        eenInterface.voegTijdschriftToe(tijdschrift);
                        System.out.println("Tijdschrift toegevoegd: " + tijdschrift.getTitel());

                    } else {
                        System.out.println("Ongeldig type. Alleen 'Boek' of 'Tijdschrift' toegestaan.");
                    }
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
                            if (gelezen > b.getTotaalPaginas()) {
                                System.out.println("Dat zijn meer pagina’s dan het boek bevat (" + b.getTotaalPaginas() + ").");
                            } else {
                                voortgang.voerGelezenPaginasIn(b, gelezen);
                            }
                        }
                    }
                } else if (keuze.equals("2")) {
                    System.out.print("Voor welke maand wil je de terugblik? (formaat: yyyy-MM): ");
                    String maand = scanner.nextLine();

                    List<Item> gelezen = leesoverzicht.getGelezenItems();
                    boolean ietsGevonden = false;

                    System.out.println("Gelezen in " + maand + ":");

                    for (Item item : gelezen) {
                        if (item.getGelezenOp() != null && item.getGelezenOp().startsWith(maand)) {
                            System.out.println("- " + item.getTitel() + " (" + item.getClass().getSimpleName() + ")");
                            ietsGevonden = true;
                        }
                    }

                    if (!ietsGevonden) {
                        System.out.println("Geen items gelezen in deze maand.");
                    }
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
