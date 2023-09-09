import java.util.Random;
import java.util.Scanner;

public class numberguessinggame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                hasGuessedCorrectly = true;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }

            int remainingAttempts = maxAttempts - attempts;
            System.out.println("You have " + remainingAttempts + " attempts remaining.");
        }

        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You've guessed the number (" + numberToGuess + ") correctly in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
        }

        scanner.close();
    }
}
