import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    static int NUM_INTERVAL = 100;

    public static int generateNumber(){
        Random random = new Random();
        return random.nextInt(NUM_INTERVAL + 1);
    }

    public static int userGuessNumber(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        return input.nextInt();
    }

    public static int checkGuess(int random, int number){
        return Integer.compare(number, random);
    }

    public static void main(String[] args) {

        int randomNumber = generateNumber();
        int number = userGuessNumber();
        while (checkGuess(randomNumber, number) != 0){
            if (checkGuess(randomNumber, number) == -1){
                System.out.println("Too low");
            } else if (checkGuess(randomNumber, number) == 1) {
                System.out.println("Too high");
            }
            else{
                break;
            }
            number = userGuessNumber();
        }
        System.out.println("Congratulations, you won !");

    }

}
