import java.time.LocalTime;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program kalendarz");
        Calendar calendar = new Calendar();
        Scanner readerInt = new Scanner(System.in);
        Scanner readerString = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Wybie1rz funkcje: \n1: Dodaj spotkanie\n2: Usuń spotkanie\n3: Wyswietl spotkanie\n4: Wyswietl spotkanie o wybranym priorytecie\n5: Wyświetl spotkanie w wybranym dniu od podanego czasu\n6: Wyświetl spotkanie w wybranym dniu od pomiedzy czasami\n7: Wyświetl spotkanie w wybranym dniu od podanego czasu i z odpowiednim priorytetem\n8: Wyjdz z programu");
            int option = readerInt.nextInt();
            switch (option) {
                case 1 -> dodajSpotkanie(calendar, readerInt, readerString);
                case 2 -> usunSpotkanie(calendar, readerInt);
                case 3 -> wyswietlSpotkanie(calendar, readerInt);
                case 4 -> wyswietlPriorytet(calendar, readerInt);
                case 5 -> wyswietlOdCzasu(calendar, readerInt, readerString);
                case 6 -> wyswietlPomiedzyCzasami(calendar, readerInt, readerString);
                case 7 -> wyswietlOdCzasuPriorytetu(calendar, readerInt, readerString);
                case 8 -> running = false;
            }
        }
        readerInt.close();
        readerString.close();
    }

    public static void usunSpotkanie(Calendar calendar, Scanner readerInt) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Wybierz numer Spotkania");
        int num = readerInt.nextInt();
        calendar.deleteMeeting(day, num);
    }

    public static void wyswietlSpotkanie(Calendar calendar, Scanner readerInt) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        Predicate<Meeting> printDay = e -> true;
        System.out.println(calendar.printDayWith(day, printDay));
    }

    public static void wyswietlPriorytet(Calendar calendar, Scanner readerInt) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Podaj priorytet: \n0: niski\n1: sredni\n2: wysoki");
        int priority = readerInt.nextInt();
        Predicate<Meeting> printDayWithPriority = e -> e.getPriority() == Meeting.setPriority(priority);
        System.out.println(calendar.printDayWith(day, printDayWithPriority));
    }

    public static void dodajSpotkanie(Calendar calendar, Scanner readerInt, Scanner readerString) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Podaj opis spotkania");
        String description = readerString.nextLine();
        System.out.println("Podaj czas rozpoczęcia");
        String startTime;
        while (true) {
            startTime = readerString.nextLine();
            if (LocalTime.parse(startTime).compareTo(Meeting.TIME) >= 0) {
                break;
            }
            System.out.println("Rozpoczecie spotkania nie moze byc przed " + Meeting.TIME);
        }
        System.out.println("Podaj czas zakonczenia");
        String endTime = readerString.nextLine();
        System.out.println("Podaj priorytet: \n0: niski\n1: sredni\n2: wysoki");
        int priority = readerInt.nextInt();
        calendar.addMeeting(day, description, LocalTime.parse(startTime), LocalTime.parse(endTime), priority);
    }

    public static void wyswietlOdCzasu(Calendar calendar, Scanner readerInt, Scanner readerString) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Podaj czas rozpoczęcia");
        String startTime = readerString.nextLine();
        Predicate<Meeting> printDayAfterHour = e -> e.getStartTime().isAfter(LocalTime.parse(startTime));
        System.out.println(calendar.printDayWith(day, printDayAfterHour));
    }

    public static void wyswietlPomiedzyCzasami(Calendar calendar, Scanner readerInt, Scanner readerString) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Podaj czas rozpoczęcia");
        String startTime = readerString.nextLine();
        System.out.println("Podaj czas zakonczenia");
        String endTime = readerString.nextLine();
        Predicate<Meeting> printDayBetweenHour = e -> e.getStartTime().isAfter(LocalTime.parse(startTime)) && e.getEndTime().isBefore(LocalTime.parse(endTime));
        System.out.println(calendar.printDayWith(day, printDayBetweenHour));
    }

    public static void wyswietlOdCzasuPriorytetu(Calendar calendar, Scanner readerInt, Scanner readerString) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Podaj czas rozpoczęcia");
        String startTime = readerString.nextLine();
        System.out.println("Podaj priorytet: \n0: niski\n1: sredni\n2: wysoki");
        int priority = readerInt.nextInt();
        Predicate<Meeting> printDayAfterHourAndPriority = e -> e.getStartTime().isAfter(LocalTime.parse(startTime)) && e.getPriority() == Meeting.setPriority(priority);
        System.out.println(calendar.printDayWith(day, printDayAfterHourAndPriority));
    }
}