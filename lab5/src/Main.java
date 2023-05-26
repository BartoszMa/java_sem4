import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Program do wyliczania ocen studenta");
        GradeList gradeList = new GradeList();
        Scanner reader = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Podaj opcje: \n 1 - Dodanie nowej oceny \n 2 - Wyliczanie sredniej ocen \n 3 - Wyswietlanie najwyzszej oceny \n 4 - Wyswietlanie najnizszej oceny \n 5 - Wyjscie z programy");
            int option = reader.nextInt();
            switch (option){
                case 1:
                    System.out.println("Podaj nową ocene");
                    gradeList.addGrade(reader.nextDouble());
                    break;
                case 2:
                    if (gradeList.isArrayEmpty()) {
                        System.out.println("Tablica jest pusta");
                    } else {
                        System.out.println("Średnia ocen to: " + gradeList.averageGrade());
                    };
                    break;
                case 3:
                    if (gradeList.isArrayEmpty()) {
                        System.out.println("Tablica jest pusta");
                    } else {
                        System.out.println("Najwyższa ocena to: " + gradeList.maxGrade());
                    };
                    break;
                case 4:
                    if (gradeList.isArrayEmpty()) {
                        System.out.println("Tablica jest pusta");
                    } else {
                        System.out.println("Najniższa ocena to: " + gradeList.minGrade());
                    };
                    break;
                case 5:
                    running = false;
                    break;
            }
        }
        reader.close();
    }
}