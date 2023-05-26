import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ListOffer listOffer = new ListOffer();
        Scanner readerInt = new Scanner(System.in);
        Scanner readerString = new Scanner(System.in);
        Scanner readerDouble = new Scanner(System.in);

        listOffer.addOffer(new House("Akacjowa", 5, "Kartuzy", "83-300", 82.0, 830000, LocalDate.parse("2022-01-01"), 100));
        listOffer.addOffer(new House("Bukowa", 1, "Kościerzyna", "83-400", 90.0, 730000, LocalDate.parse("2024-03-03"), 80));
        listOffer.addOffer(new House("Marka Grechuty", 2, "Kielno", "84-208", 62.0, 630000, LocalDate.parse("2024-01-01"), 90));
        listOffer.addOffer(new Flat("Akacjowa", 5, "Kartuzy", "83-300", 82.0, 830000, LocalDate.parse("2024-01-01"), 2, 20));
        listOffer.addOffer(new Flat("Bukowa", 1, "Kościerzyna", "83-400", 90.0, 730000, LocalDate.parse("2024-03-03"), 5, 12));
        listOffer.addOffer(new Flat("Marka Grechuty", 2, "Kielno", "84-208", 62.0, 630000, LocalDate.parse("2024-01-01"), 7, 10));

        boolean running = true;

        while (running) {
            System.out.println("Wybierz funkcje: \n 1: Dodaj oferte domu \n 2: Dodaj oferte mieszkania \n 3: Wyswietl aktualne oferty domów \n 4: Wyswietlenie wszystkich aktualnych ofert mieszkań \n 5: Wyswietlenie domów w podanej miejscowosci i o powierzchni nie mniejszej niz podana wartosc \n 6: Wyswietlenie mieszkań w podanej miejscowosci i nie droższych niż podana wartość i od podanego piętra");
            int option = readerInt.nextInt();
            switch (option) {
                case 1 -> dodajOferteDomu(listOffer, readerInt, readerString, readerDouble);
                case 2 -> dodajOferteMieszkania(listOffer, readerInt, readerString, readerDouble);
                case 3 -> wyswietlAktualneDomy(listOffer);
                case 4 -> wyswietlAktualneMieszkania(listOffer);
                case 5 -> wyswietlAktualneDomyMiejscowosc(listOffer, readerString, readerDouble);
                case 6 -> wyswietlAktualneMieszkaniaCena(listOffer, readerDouble, readerInt, readerString);
                case 7 -> running = false;
            }
        }
        readerInt.close();
        readerString.close();
        readerDouble.close();
    }

    public static void dodajOferteDomu(ListOffer listOffer, Scanner readerInt, Scanner readerString, Scanner readerDouble) {
        System.out.println("Podaj nazwe ulicy: ");
        String street = readerString.nextLine();
        System.out.println("Podaj numer domu: ");
        int houseNumber = readerInt.nextInt();
        System.out.println("Podaj miejscowosc: ");
        String city = readerString.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String postalCode = readerString.nextLine();
        System.out.println("Podaj powierzchnie mieszkalną: ");
        double livingArea = readerDouble.nextDouble();
        System.out.println("Podaj cene: ");
        double price = readerDouble.nextDouble();
        System.out.println("Podaj date oferty: ");
        String offerData = readerString.nextLine();
        System.out.println("Podaj powierzchnie działki: ");
        double landArea = readerDouble.nextDouble();
        listOffer.addOffer(new House(street, houseNumber, city, postalCode, livingArea, price, LocalDate.parse(offerData), landArea));
    }

    public static void dodajOferteMieszkania(ListOffer listOffer, Scanner readerInt, Scanner readerString, Scanner readerDouble) {
        System.out.println("Podaj nazwe ulicy: ");
        String street = readerString.nextLine();
        System.out.println("Podaj numer domu: ");
        int houseNumber = readerInt.nextInt();
        System.out.println("Podaj miejscowosc: ");
        String city = readerString.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String postalCode = readerString.nextLine();
        System.out.println("Podaj powierzchnie mieszkalną: ");
        double livingArea = readerDouble.nextDouble();
        System.out.println("Podaj cene: ");
        double price = readerDouble.nextDouble();
        System.out.println("Podaj date oferty: ");
        String offerData = readerString.nextLine();
        System.out.println("Podaj numer mieszkania: ");
        int flatNumber = readerDouble.nextInt();
        System.out.println("Podaj pietro: ");
        int floor = readerInt.nextInt();
        listOffer.addOffer(new Flat(street, houseNumber, city, postalCode, livingArea, price, LocalDate.parse(offerData), flatNumber, floor));
    }

    public static void wyswietlAktualneDomy(ListOffer listOffer) {
        Predicate<Property> printHouses = e -> e instanceof House && (e.getDate().equals(LocalDate.now()) || e.getDate().isAfter(LocalDate.now()));
        System.out.println(listOffer.printOfferWith(printHouses));
    }

    public static void wyswietlAktualneMieszkania(ListOffer listOffer) {
        Predicate<Property> printFlats = e -> e instanceof Flat && (e.getDate().equals(LocalDate.now()) || e.getDate().isAfter(LocalDate.now()));
        System.out.println(listOffer.printOfferWith(printFlats));
    }

    public static void wyswietlAktualneDomyMiejscowosc(ListOffer listOffer, Scanner readerString, Scanner readerDouble) {
        System.out.println("Podaj miejscowośc: ");
        String city = readerString.nextLine();
        System.out.println("Podaj powierzchnie: ");
        double livingArea = readerDouble.nextDouble();
        Predicate<Property> printHouses = e -> e instanceof House && e.getLivingArea() >= livingArea && e.getCity().equals(city) && (e.getDate().equals(LocalDate.now()) || e.getDate().isAfter(LocalDate.now()));
        System.out.println(listOffer.printOfferWith(printHouses));
    }

    public static void wyswietlAktualneMieszkaniaCena(ListOffer listOffer, Scanner readerDouble, Scanner readerInt, Scanner readerString) {
        System.out.println("Podaj miejscowośc: ");
        String city = readerString.nextLine();
        System.out.println("Podaj cene: ");
        double price = readerDouble.nextDouble();
        System.out.println("Podaj piętro: ");
        int floor = readerInt.nextInt();
        Predicate<Property> printFlats = e -> e instanceof Flat && e.getCity().equals(city) && e.getPrice() <= price && ((Flat) e).getFloor() >= floor && (e.getDate().equals(LocalDate.now()) || e.getDate().isAfter(LocalDate.now()));
        System.out.println(listOffer.printOfferWith(printFlats));
    }
}
