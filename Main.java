import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AanbevelingService aanbevelingService = new AanbevelingService();
        LeesgeschiedenisService leesgeschiedenisService = new LeesgeschiedenisService();
        InterfaceService interfaceService = new InterfaceService();
        VoortgangService voortgangService = new VoortgangService();

        boolean actief = true;

        while (actief) {
            System.out.println("\n=== MENU ===");
            System.out.println("[1] Aanbeveling");
            System.out.println("[2] Leesgeschiedenis");
            System.out.println("[3] Interface");
            System.out.println("[4] Voortgang");
            System.out.println("[5] Uitloggen");
            System.out.print("Kies een optie: ");

            int keuze = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (keuze) {
                case 1: // Aanbeveling
                    System.out.println("--- Aanbevelingen ---");
                    List<Boek> gelezen = Arrays.asList(new Boek("Dune", null, "Sciencefiction"));
                    List<Boek> tips = aanbevelingService.genereerAanbevelingen(gelezen);
                    for (Boek b : tips) {
                        System.out.println("- " + b);
                    }

                    System.out.println("Wil je een boek liken? Typ titel of 'nee':");
                    String like = scanner.nextLine();
                    for (Boek b : tips) {
                        if (b.getTitel().equalsIgnoreCase(like)) {
                            aanbevelingService.likeBoek(b);
                        }
                    }

                    break;

                case 2: // Leesgeschiedenis
                    System.out.println("--- Leesgeschiedenis ---");
                    System.out.print("Wat wil je toevoegen? [Boek/Tijdschrift]: ");
                    String type = scanner.nextLine();

                    System.out.print("Titel: ");
                    String titel = scanner.nextLine();

                    String datum = java.time.LocalDate.now().toString();

                    if (type.equalsIgnoreCase("Boek")) {
                        Boek boek = new Boek(titel, datum, "Sciencefiction");
                        leesgeschiedenisService.markeerAlsGelezen(boek);
                    } else if (type.equalsIgnoreCase("Tijdschrift")) {
                        System.out.print("Editie: ");
                        String editie = scanner.nextLine();
                        Tijdschrift tijdschrift = new Tijdschrift(titel, editie, datum);
                        leesgeschiedenisService.markeerAlsGelezen(tijdschrift);
                    }

                    System.out.println("Gehele leesoverzicht:");
                    for (Item i : leesgeschiedenisService.toonLeesoverzicht()) {
                        System.out.println("- " + i);
                    }

                    System.out.print("Filter op type [Boek/Tijdschrift] of leeg: ");
                    String filter = scanner.nextLine();
                    if (!filter.isEmpty()) {
                        for (Item i : leesgeschiedenisService.filterLeesoverzicht(filter)) {
                            System.out.println("- " + i);
                        }
                    }

                    break;

                case 3: // Interface
                    System.out.println("--- Interface ---");
                    System.out.print("Nieuw boek toevoegen. Titel: ");
                    String nieuweTitel = scanner.nextLine();

                    System.out.print("Aantal pagina’s: ");
                    int paginas = scanner.nextInt();
                    scanner.nextLine();

                    Boek nieuwBoek = new Boek(nieuweTitel, paginas);
                    interfaceService.voegBoekToe(nieuwBoek);

                    System.out.println("Formulier voorbeeld:");
                    interfaceService.toonInvoerFormulier("Boek");

                    break;

                case 4: // Voortgang
                    System.out.println("--- Voortgang ---");

                    List<Boek> alToegevoegd = interfaceService.getBoeken();
                    if (alToegevoegd.isEmpty()) {
                        System.out.println("Geen boeken toegevoegd via interface.");
                        break;
                    }

                    System.out.println("Welk boek wil je bijwerken?");
                    for (int i = 0; i < alToegevoegd.size(); i++) {
                        System.out.println("[" + i + "] " + alToegevoegd.get(i).getTitel());
                    }

                    int index = scanner.nextInt();
                    scanner.nextLine();

                    Boek geselecteerd = alToegevoegd.get(index);

                    System.out.print("Hoeveel pagina’s heb je gelezen? ");
                    int gelezenPaginas = scanner.nextInt();
                    scanner.nextLine();

                    voortgangService.voerGelezenPaginasIn(geselecteerd, gelezenPaginas);

                    System.out.print("Maand voor terugblik: ");
                    String maand = scanner.nextLine();
                    voortgangService.genereerMaandelijkseTerugblik(maand);

                    break;

                case 5: // Uitloggen
                    actief = false;
                    System.out.println("Tot de volgende keer!");
                    break;

                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
        }

        scanner.close();
    }
}
