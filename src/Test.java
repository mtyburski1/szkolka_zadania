import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Test {
    private static int input = 0;
    private static boolean error = true;
    private static final int TRIES = 5;

    public void numberGuesser() {
        Scanner sc = new Scanner(System.in);
        int numberToGuess = new Random().nextInt(100);
        for (int i = 0; i < TRIES; i++) {
            System.out.println("Podaj liczbę z zakresu 0-99");
            do {
                try {
                    input = sc.nextInt();
                    sc.nextLine();
                    error = false;
                } catch (InputMismatchException e) {
                    System.err.println("Niedozwolone znaki.");
                    sc.nextLine();

                }
            } while (error);
            if (input > numberToGuess && i != TRIES - 1)
                System.out.println("Your number is GREATER than the one you are trying to guess");
            else if (input < numberToGuess && i != TRIES - 1)
                System.out.println("Your number is LOWER than the one you are trying to guess");
            else if (input == numberToGuess) {
                System.out.println("Brawo! liczba, którą zgadłeś wynosi: " + numberToGuess);
                return;
            }
            if (i != TRIES - 1) {
                System.out.println("Pozostało " + (TRIES - i - 1) + " prób.");
                System.out.println("Please try again.");
                error = true;
            }


        }
        System.out.println("Nie udało ci się odgadnąć liczby, która wynosiła: " + numberToGuess);
        sc.close();
    }
}
