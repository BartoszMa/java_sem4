import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program do wyliczania walca");
        Cylinder cylinder = new Cylinder();
        Scanner reader = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Podaj opcje: \n 1 - wyświetlenie wartości walca \n 2 - Zmiana wartosci zmiennych walca \n 3 - Wyswietlanie pol powierzchni walca \n 4 - Wyjscie z programy");
            int option = reader.nextInt();
            switch (option){
                case 1:
                    System.out.println("Promień walca: " + cylinder.getRadius());
                    System.out.println("Wysokość walca: " + cylinder.getHeight());
                    break;
                case 2:
                    System.out.println("Podaj nowy promień walca");
                    cylinder.setRadius(reader.nextDouble());
                    System.out.println("Podaj nową wysokość walca");
                    cylinder.setHeight(reader.nextDouble());
                    break;
                case 3:
                    System.out.println("Pole podstawy: " + cylinder.baseArea());
                    System.out.println("Pole boczne: " + cylinder.sideArea());
                    System.out.println("Pole całkowite: " + cylinder.totalArea());
                    System.out.println("Objętość: " + cylinder.volume());
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
        reader.close();
    }
}