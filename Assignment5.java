package hw;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
* Assignment 5
* @author Aliaksandr Yarmak
*/
public class Assignment5 {
    public static final String PROMPT_MSG = "Input 2 integer values in the range of 1 to 6.";
    public static final String INPUT_DISPLAY = "Your input: %d, %d.\n";
    public static final String WIN_MSG = "Congratulations! You win!";
    public static final String LOSS_MSG = "Sorry, but you lose!";
    public static final String CONTINUATION_MSG = "You don't win or lose, so let's continue the game.";
    public static final String EXIT_MSG = "To stop the game, input 0.";
    public static final String ERROR_MSG = "Error! Please, enter what the program asks!";
    public static Scanner sc = null;

    public static void main(String[] args) {
        boolean needToRepeat = true;
        sc = new Scanner(System.in);
        try {
            while (needToRepeat) {
                System.out.println(PROMPT_MSG);
                int die1 = sc.nextInt();
                int die2 = sc.nextInt();
                System.out.printf(INPUT_DISPLAY, die1, die2);
                
                if (die1 > 0 && die1 < 7 && die2 > 0 && die2 < 7) {
                    String result = outcome(die1, die2);
                    System.out.println(result);
                    if (result == CONTINUATION_MSG) {
                        continuation(die1 + die2);
                    }
                    System.out.println(EXIT_MSG);
                } else if (die1 == 0 || die2 == 0) {
                    needToRepeat = false;
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

    public static String outcome(int d1, int d2) {
        if (d1 + d2 == 7 || d1 + d2 == 11) {
            return WIN_MSG;
        } else if (d1 + d2 == 2 || d1 + d2 == 12) {
            return LOSS_MSG;
        } else {
            return CONTINUATION_MSG;
        }
    }

    public static void continuation(int sum) {
        System.out.println(PROMPT_MSG);
        int dice1 = sc.nextInt();
        int dice2 = sc.nextInt();
        System.out.printf(INPUT_DISPLAY, dice1, dice2);
        
        if (dice1 > 0 && dice1 < 7 && dice2 > 0 && dice2 < 7) {
            if (dice1 + dice2 == 7) {
                System.out.println(LOSS_MSG);
            } else if (dice1 + dice2 == sum) {
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
}
