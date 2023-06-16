//Step 6: Set up a random power ball generator
import java.util.Random;

//Step 5: Set up a simple interaction with the user
import java.util.Scanner;

//Step 1: Create a separate class that will
//print valid characters to the user that
//is called from the main() method

public class AsciiChars {
//Step 2: Using an ASCII chart,
// find the range of values for each character set
//Step 3: Using a for loop, print the valid values in each set
//called from within the main() method
    public static void printNumbers() {
        int start = 48; // ASCII value for '0'
        int end = 57; //ASCII value for '9'

        System.out.print("Numbers: ");
        for (int i = start; i <= end; i++) {
            System.out.print((char) i + " ");
        }
        System.out.println();
    }
    public static void printLowerCaseLetters() {
        int start = 97; //ASCII value for 'a'
        int end = 122; //ASCII value for 'z'

        System.out.print("Lowercase letters: ");
        for (int i = start; i<= end; i++) {
            System.out.print((char) i + " ");
        }
        System.out.println();
    }

    public static void printUpperCaseLetters() {
        int start = 65; //ASCII value for 'A'
        int end = 90; //ASCII value for 'Z'

        System.out.print("Uppercase letters: ");
        for (int i = start; i <= end; i++) {
            System.out.print((char) i + " ");
        }
        System.out.println();
    }

//Step 4: print the valid characters for input called within the main() method
    public static void main(String[] args) {
        printNumbers();
        printLowerCaseLetters();
        printUpperCaseLetters();

        //Create question: "Please enter your name:".
        // When user inputs name, echo back "Hello (Name)".
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello " + name);

        System.out.print("Do you wish to continue to the interactive portion? (yes/no): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            System.out.println("Continuing to the interactive portion...");

            do {
                String favoritePetName;
                int luckyNumber;
                int favoriteQuarterbackNumber;
                int carModelYear;
                String favoriteActorActressName;
                int randomNumber;

            // Gather random information

                System.out.print("What is the name of your favorite pet? ");
                favoritePetName = scanner.nextLine();

                while (favoritePetName.isEmpty()) {
                    System.out.print("Please enter a valid pet name: ");
                    favoritePetName = scanner.nextLine();
                }


                System.out.print("What is your lucky number? ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Please enter a valid lucky number: ");
                    scanner.next();
                }
                luckyNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Do you have a favorite quarterback? (yes/no): ");
                String hasFavoriteQuarterback = scanner.nextLine();

                while (!hasFavoriteQuarterback.equalsIgnoreCase("yes") && !hasFavoriteQuarterback.equalsIgnoreCase("no") &&
                        !hasFavoriteQuarterback.equalsIgnoreCase("y") && !hasFavoriteQuarterback.equalsIgnoreCase("n")) {
                    System.out.print("Please enter a valid response (yes/no): ");
                    hasFavoriteQuarterback = scanner.nextLine();
                }

                if (hasFavoriteQuarterback.equalsIgnoreCase("yes") || hasFavoriteQuarterback.equalsIgnoreCase("y")) {
                    System.out.print("What is their jersey number? ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Please enter a valid jersey number: ");
                        scanner.next();
                    }
                    favoriteQuarterbackNumber = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    favoriteQuarterbackNumber = 0; // Default value if no favorite quarterback
                }

                System.out.print("What is the two-digit model year of your car? ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Please enter a valid car model year: ");
                    scanner.next();
                }
                carModelYear = scanner.nextInt();
                scanner.nextLine();

                System.out.print("What is the first name of your favorite actor or actress? ");
                favoriteActorActressName = scanner.nextLine();

                while (favoriteActorActressName.isEmpty()) {
                    System.out.print("Please enter a valid actor/actress name: ");
                    favoriteActorActressName = scanner.nextLine();
                }

                System.out.print("Enter a random number between 1 and 50: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Please enter a valid random number: ");
                    scanner.next();
                }
                randomNumber = scanner.nextInt();
                scanner.nextLine();

                // Constants for max values
                final int MAX_MAGIC_BALL = 75;
                final int MAX_LOTTERY_NUMBER = 65;

                // Generate Powerball numbers
                int magicBall;
                int[] lotteryNumbers = new int[5];

                if (favoriteQuarterbackNumber != 0) {
                    magicBall = (favoriteQuarterbackNumber * luckyNumber * random.nextInt(3)) % MAX_MAGIC_BALL;
                } else {
                    magicBall = (luckyNumber * random.nextInt(3)) % MAX_MAGIC_BALL;
                }

                lotteryNumbers[0] = (int) favoritePetName.charAt(2) % MAX_LOTTERY_NUMBER;
                lotteryNumbers[1] = (carModelYear + luckyNumber) % MAX_LOTTERY_NUMBER;
                lotteryNumbers[2] = (randomNumber - random.nextInt(3)) % MAX_LOTTERY_NUMBER;
                lotteryNumbers[3] = (int) favoriteActorActressName.charAt(0) % MAX_LOTTERY_NUMBER;
                lotteryNumbers[4] = (int) favoriteActorActressName.charAt(favoriteActorActressName.length() - 1) % MAX_LOTTERY_NUMBER;

                System.out.print("Lottery numbers: ");
                for (int i = 0; i < 5; i++) {
                    if (lotteryNumbers[i] < 0) {
                        lotteryNumbers[i] += MAX_LOTTERY_NUMBER;
                    }
                    System.out.print(lotteryNumbers[i] + " ");
                }
                System.out.println("Magic ball: " + magicBall);

                System.out.print("Would you like to generate another set of numbers? (yes/no): ");
                String generateAgain = scanner.nextLine();

                if (!generateAgain.equalsIgnoreCase("yes") && !generateAgain.equalsIgnoreCase("y")) {
                    break;
                }
            } while (true);
        } else {
            System.out.println("Please return later to complete the survey.");
        }

        System.out.println("Thank you for using the program!");
    }
}
