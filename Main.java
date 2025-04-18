import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Aanbevelingen aanbevelingen = new Aanbevelingen();
        Leesoverzicht leesoverzicht = new Leesoverzicht();
        Interface eenInterface = new Interface();
        Voortgang voortgang = new Voortgang();

        // sample data

        Boek boek1 = new Boek("Dune", "2025-04-01", "Sciencefiction");
        Boek boek2 = new Boek("The Hobbit", "2025-04-01", "Fantasy");
        leesoverzicht.markeerAlsGelezen(boek1);
        leesoverzicht.markeerAlsGelezen(boek2);


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
                    List<Boek> tips = aanbevelingen.genereerAanbevelingen(Arrays.asList(boek1, boek2));
                    for (Boek b : tips) {
                        System.out.println("- " + b);
                    }
                } else if (keuze.equals("2")) {
                    System.out.print("Titel van het boek dat je wil liken: ");
                    String like = scanner.nextLine();
                    for (Boek b : aanbevelingen.genereerAanbevelingen(Arrays.asList(boek1, boek2))) {
                        if (b.getTitel().equalsIgnoreCase(like)) {
                            aanbevelingen.likeBoek(b);
                        }
                    }
                } else if (keuze.equals("3")) {
                    System.out.print("Voer een genre in: ");
                    String genre = scanner.nextLine();

                    aanbevelingen.pasVoorkeurAan(genre);
                } else if (keuze.equals("4")){
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
                    for (Boek b : Arrays.asList(boek1, boek2)) {
                        if (b.getTitel().equalsIgnoreCase(titel)) {
                            leesoverzicht.markeerAlsGelezen(b);
                        }
                    }
                } else if (keuze.equals("2")) {
                    leesoverzicht.toonLeesoverzicht();
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
                    for (Boek b : Arrays.asList(boek1, boek2)) {
                        if (b.getTitel().equalsIgnoreCase(titel)) {
                            double voortgangPercentage = eenInterface.berekenVoortgang(b);
                            System.out.println("Voortgang van \"" + b.getTitel() + "\": " + voortgangPercentage + "%");
                        }
                    }
                } else if (keuze.equals("2")) {
                    System.out.print("Nieuw boek toevoegen. Titel: ");
                    String nieuweTitel = scanner.nextLine();
                    System.out.print("Aantal pagina’s: ");
                    int paginas = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
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
                    for (Boek b : Arrays.asList(boek1, boek2)) {
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
