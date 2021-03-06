package hw;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Assignment 5
* @author Aliaksandr Yarmak
*/
public class Assignment5 {
    public enum Result {
        WIN, LOSS, CONTINUE, EXIT
    }
    public static final String PROMPT_MSG = "Input 2 integer values in the range of 1 to 6. (0 to exit)";
    public static final String INPUT_DISPLAY = "Your input: %d, %d.";
    public static final String WIN_MSG = "Congratulations! You win!";
    public static final String LOSS_MSG = "Sorry, but you lose!";
    public static final String CONTINUATION_MSG = "You don't win or lose, so let's continue the game.";
    public static final String EXIT_MSG = "The game is over";
    public static final String ERROR_MSG = "Error: Invalid input";
    private static Scanner sc = null;

    public static void main(String[] args) {
        boolean isRunning = true;
        sc = new Scanner(System.in);
        try {
            while (isRunning) {
                System.out.println(PROMPT_MSG);
                int die1 = sc.nextInt();
                int die2 = sc.nextInt();
                System.out.printf(INPUT_DISPLAY, die1, die2);
                System.out.println();

                if (isValidInput(die1, die2)) {
                    Result result = outcome(die1, die2);
                    switch (result) {
                    case WIN:
                        System.out.println(WIN_MSG);
                        break;
                    case LOSS:
                        System.out.println(LOSS_MSG);
                        break;
                    case CONTINUE:
                        System.out.println(CONTINUATION_MSG);
                        continuation(die1 + die2);
                        break;
                    case EXIT:
                        System.out.println(EXIT_MSG);
                        isRunning = false;
                    }
                } else {
                    System.out.println(ERROR_MSG);
                }
            }
        } catch (InputMismatchException e) {
            System.err.println(e);
        } finally {
            sc.close();
        }
    }

    private static Result outcome(int die1, int die2) {
        int sum = die1 + die2;
        if (die1 == 0 || die2 == 0) {
            return Result.EXIT;
        } else if (sum == 2 || sum == 12) {
            return Result.LOSS;
        } else if (sum == 7 || sum == 11) {
            return Result.WIN;
        } else {
            return Result.CONTINUE;
        }
    }

    private static void continuation(int sum) {
        System.out.println(PROMPT_MSG);
        int die1 = sc.nextInt();
        int die2 = sc.nextInt();
        System.out.printf(INPUT_DISPLAY, die1, die2);
        System.out.println();

        if (isValidInput(die1, die2)) {
            int newSum = die1 + die2;
            if (newSum == 7) {
                System.out.println(LOSS_MSG);
            } else if (newSum == sum) {
                System.out.println(WIN_MSG);
            } else {
                System.out.println(CONTINUATION_MSG);
                continuation(sum);
            }
        } else {
            System.out.println(ERROR_MSG);
            continuation(sum);
        }
    }

    private static boolean isValidInput(int die1, int die2) {
        return (die1 >= 0 && die1 <= 6) && (die2 >= 0 && die2 <= 6);
    }
}
