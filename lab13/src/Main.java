import java.time.LocalTime;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program kalendarz");
        Calendar calendar = new Calendar();
        Scanner readerInt = new Scanner(System.in);
        Scanner readerString = new Scanner(System.in);
        calendar.addEvent(0, new Meeting("grill", LocalTime.parse("19:00"), LocalTime.parse("23:00"), 2));
        calendar.addEvent(0, new Meeting("zajecia", LocalTime.parse("09:00"), LocalTime.parse("10:00"), 1));
        calendar.addEvent(0, new Meeting("spotkanie", LocalTime.parse("11:00"), LocalTime.parse("13:00"), 0));
        calendar.addEvent(0, new Task("zrobic zadanie z javy", LocalTime.parse("09:00"), LocalTime.parse("11:00"), 1));
        calendar.addEvent(0, new Task("zrobic obiad", LocalTime.parse("11:00"), LocalTime.parse("12:00"), 2));
        calendar.addEvent(0, new Task("zadzwonic", LocalTime.parse("17:00"), LocalTime.parse("20:00"), 3));
        calendar.addEvent(1, new Meeting("grill", LocalTime.parse("19:00"), LocalTime.parse("23:00"), 2));
        calendar.addEvent(1, new Meeting("zajecia", LocalTime.parse("09:00"), LocalTime.parse("10:00"), 1));
        calendar.addEvent(1, new Meeting("spotkanie", LocalTime.parse("11:00"), LocalTime.parse("13:00"), 0));
        calendar.addEvent(1, new Task("zrobic zadanie z javy", LocalTime.parse("09:00"), LocalTime.parse("11:00"), 1));
        calendar.addEvent(1, new Task("zrobic obiad", LocalTime.parse("11:00"), LocalTime.parse("12:00"), 2));
        calendar.addEvent(1, new Task("zadzwonic", LocalTime.parse("17:00"), LocalTime.parse("20:00"), 3));
        calendar.addEvent(2, new Meeting("grill", LocalTime.parse("19:00"), LocalTime.parse("23:00"), 2));
        calendar.addEvent(2, new Meeting("zajecia", LocalTime.parse("09:00"), LocalTime.parse("10:00"), 1));
        calendar.addEvent(2, new Meeting("spotkanie", LocalTime.parse("11:00"), LocalTime.parse("13:00"), 0));
        calendar.addEvent(2, new Task("zrobic zadanie z javy", LocalTime.parse("09:00"), LocalTime.parse("11:00"), 1));
        calendar.addEvent(2, new Task("zrobic obiad", LocalTime.parse("11:00"), LocalTime.parse("12:00"), 2));
        calendar.addEvent(2, new Task("zadzwonic", LocalTime.parse("17:00"), LocalTime.parse("20:00"), 3));
        calendar.addEvent(3, new Meeting("grill", LocalTime.parse("19:00"), LocalTime.parse("23:00"), 2));
        calendar.addEvent(3, new Meeting("zajecia", LocalTime.parse("09:00"), LocalTime.parse("10:00"), 1));
        calendar.addEvent(3, new Meeting("spotkanie", LocalTime.parse("11:00"), LocalTime.parse("13:00"), 0));
        calendar.addEvent(3, new Task("zrobic zadanie z javy", LocalTime.parse("09:00"), LocalTime.parse("11:00"), 1));
        calendar.addEvent(3, new Task("zrobic obiad", LocalTime.parse("11:00"), LocalTime.parse("12:00"), 2));
        calendar.addEvent(3, new Task("zadzwonic", LocalTime.parse("17:00"), LocalTime.parse("20:00"), 3));
        calendar.addEvent(4, new Meeting("grill", LocalTime.parse("19:00"), LocalTime.parse("23:00"), 2));
        calendar.addEvent(4, new Meeting("zajecia", LocalTime.parse("09:00"), LocalTime.parse("10:00"), 1));
        calendar.addEvent(4, new Meeting("spotkanie", LocalTime.parse("11:00"), LocalTime.parse("13:00"), 0));
        calendar.addEvent(4, new Task("zrobic zadanie z javy", LocalTime.parse("09:00"), LocalTime.parse("11:00"), 1));
        calendar.addEvent(4, new Task("zrobic obiad", LocalTime.parse("11:00"), LocalTime.parse("12:00"), 2));
        calendar.addEvent(4, new Task("zadzwonic", LocalTime.parse("17:00"), LocalTime.parse("20:00"), 3));
        calendar.addEvent(5, new Meeting("grill", LocalTime.parse("19:00"), LocalTime.parse("23:00"), 2));
        calendar.addEvent(5, new Meeting("zajecia", LocalTime.parse("09:00"), LocalTime.parse("10:00"), 1));
        calendar.addEvent(5, new Meeting("spotkanie", LocalTime.parse("11:00"), LocalTime.parse("13:00"), 0));
        calendar.addEvent(5, new Task("zrobic zadanie z javy", LocalTime.parse("09:00"), LocalTime.parse("11:00"), 1));
        calendar.addEvent(5, new Task("zrobic obiad", LocalTime.parse("11:00"), LocalTime.parse("12:00"), 2));
        calendar.addEvent(5, new Task("zadzwonic", LocalTime.parse("17:00"), LocalTime.parse("20:00"), 3));
        calendar.addEvent(6, new Meeting("grill", LocalTime.parse("19:00"), LocalTime.parse("23:00"), 2));
        calendar.addEvent(6, new Meeting("zajecia", LocalTime.parse("09:00"), LocalTime.parse("10:00"), 1));
        calendar.addEvent(6, new Meeting("spotkanie", LocalTime.parse("11:00"), LocalTime.parse("13:00"), 0));
        calendar.addEvent(6, new Task("zrobic zadanie z javy", LocalTime.parse("09:00"), LocalTime.parse("11:00"), 1));
        calendar.addEvent(6, new Task("zrobic obiad", LocalTime.parse("11:00"), LocalTime.parse("12:00"), 2));
        calendar.addEvent(6, new Task("zadzwonic", LocalTime.parse("17:00"), LocalTime.parse("20:00"), 3));
        boolean running = true;
        while (running) {
            System.out.println("Wybierz funkcje: \n1: Dodaj spotkanie\n2: Dodaj zadanie\n3: Usuń spotkanie\n4: Usuń zadanie\n5: Wyswietl spotkanie\n6: Wyświetl zadanie\n7: Wyswietl spotkanie o wybranym priorytecie\n8: Wyswietl zadanie o wybranym statusie\n9: Wyświetl spotkanie w wybranym dniu od podanego czasu i z odpowiednim priorytetem\n10: Wyswietlenie do czasu i status\n11: Wyjdz z programu");
            int option = readerInt.nextInt();
            switch (option) {
                case 1 -> dodajSpotkanie(calendar, readerInt, readerString);
                case 2 -> dodajZadanie(calendar, readerInt, readerString);
                case 3 -> usunSpotkanie(calendar, readerInt, readerString);
                case 4 -> usunZadanie(calendar, readerInt, readerString);
                case 5 -> wyswietlSpotkanie(calendar, readerInt);
                case 6 -> wyswietlZadanie(calendar, readerInt);
                case 7 -> wyswietlPriorytet(calendar, readerInt);
                case 8 -> wyswietlStatus(calendar, readerInt);
                case 9 -> wyswietlOdCzasuPriorytetu(calendar, readerInt, readerString);
                case 10 -> wyswietlDoCzasuStatus(calendar, readerInt, readerString);
                case 11 -> running = false;
            }
        }
        readerInt.close();
        readerString.close();
    }

    public static void usunSpotkanie(Calendar calendar, Scanner readerInt, Scanner readerString) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Wybierz opis spotkania");
        String description = readerString.nextLine();
        Predicate<Event> deleteMeeting = e -> e instanceof Meeting && e.getDescription().equals(description);
        calendar.deleteMeeting(day - 1, deleteMeeting);
    }

    public static void usunZadanie(Calendar calendar, Scanner readerInt, Scanner readerString) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Wybierz opis spotkania");
        String description = readerString.nextLine();
        Predicate<Event> deleteTask = e -> e instanceof Task && e.getDescription().equals(description);
        calendar.deleteMeeting(day - 1, deleteTask);
    }

    public static void wyswietlSpotkanie(Calendar calendar, Scanner readerInt) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        Predicate<Event> printDay = e -> e instanceof Meeting;
        System.out.println(calendar.printDayWith(day - 1, printDay));
    }

    public static void wyswietlZadanie(Calendar calendar, Scanner readerInt) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        Predicate<Event> printDay = e -> e instanceof Task;
        System.out.println(calendar.printDayWith(day - 1, printDay));
    }

    public static void wyswietlPriorytet(Calendar calendar, Scanner readerInt) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Podaj priorytet: \n0: niski\n1: sredni\n2: wysoki");
        int priority = readerInt.nextInt();
        Predicate<Event> printDayWithPriority = e -> e instanceof Meeting && ((Meeting) e).getPriority() == Meeting.setPriority(priority);
        System.out.println(calendar.printDayWith(day - 1, printDayWithPriority));
    }

    public static void wyswietlStatus(Calendar calendar, Scanner readerInt) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Podaj status: \n0: planowany\n1: potwierdzony\n2: w realizacji\n3: done");
        int status = readerInt.nextInt();
        Predicate<Event> printDayWithPriority = e -> e instanceof Task && ((Task) e).getStatus() == Task.setStatus(status);
        System.out.println(calendar.printDayWith(day - 1, printDayWithPriority));
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
        calendar.addEvent(day - 1, new Meeting(description, LocalTime.parse(startTime), LocalTime.parse(endTime), priority));
    }

    public static void dodajZadanie(Calendar calendar, Scanner readerInt, Scanner readerString) {
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
        System.out.println("Podaj status: \n0: planowany\n1: potwierdzony\n2: w realizacji\n3: done");
        int status = readerInt.nextInt();
        calendar.addEvent(day - 1, new Task(description, LocalTime.parse(startTime), LocalTime.parse(endTime), status));
    }

    public static void wyswietlOdCzasuPriorytetu(Calendar calendar, Scanner readerInt, Scanner readerString) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Podaj czas rozpoczęcia");
        String startTime = readerString.nextLine();
        System.out.println("Podaj priorytet: \n0: niski\n1: sredni\n2: wysoki");
        int priority = readerInt.nextInt();
        Predicate<Event> printDayAfterHourAndPriority = e -> e instanceof Meeting && (e.getStartTime().isAfter(LocalTime.parse(startTime)) || e.getStartTime().equals(LocalTime.parse(startTime))) && ((Meeting) e).getPriority() == Meeting.setPriority(priority);
        System.out.println(calendar.printDayWith(day - 1, printDayAfterHourAndPriority));
    }

    public static void wyswietlDoCzasuStatus(Calendar calendar, Scanner readerInt, Scanner readerString) {
        System.out.println("Wybierz dzień tygodnia: \n1: Poniedziałek\n2: Wtorek\n3: Środa\n4: Czwartek\n5: Piątek\n6: Sobota\n7: Niedziela\n");
        int day = readerInt.nextInt();
        System.out.println("Podaj czas zakonczenia");
        String endTime = readerString.nextLine();
        System.out.println("Podaj status: \n0: planowany\n1: potwierdzony\n2: w realizacji\n3: done");
        int priority = readerInt.nextInt();
        Predicate<Event> printDayAfterHourAndPriority = e -> e instanceof Task && (e.getEndTime().isBefore(LocalTime.parse(endTime)) || e.getEndTime().equals(LocalTime.parse(endTime))) && ((Task) e).getStatus() == Task.setStatus(priority);
        System.out.println(calendar.printDayWith(day - 1, printDayAfterHourAndPriority));
    }

}