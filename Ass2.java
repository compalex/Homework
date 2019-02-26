package hw;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ass2 {

    public static void main(String[] args) {
        int idNum = getFromScanner("Input the id number of the team:");
        int winNum = getFromScanner("Input the number of wins this team has:");
        int losNum = getFromScanner("Input the number of losses this team has:");        
        System.out.printf("Team %d \n%d wins\t%d losses\n", idNum, winNum, losNum);
        int totalNum = winNum + losNum;
        System.out.printf("Total number of games played is %d\t%d games remaining\n", totalNum, 25 - totalNum);
        double winAverage = (double) winNum / totalNum;
        System.out.printf("The winning average is %.4f\n", winAverage);
        if (winNum <= (25 - totalNum)) {
            System.out.println("Number of games remaining is greater than or equal to number won.");
        } else {
            System.out.println("Number of games remaining is less than number won.");
        }
        if (losNum < (25 - totalNum)) {
            System.out.println("Number of games remaining is greater than number lost.");
        } else {
            System.out.println("Number of games remaining is less than or equal to number won.");
        }
    }
    
    private static int getFromScanner(String promptInput) {
        System.out.println(promptInput);
        Scanner sc = new Scanner(System.in);   
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input! Try again.");
            
            return getFromScanner(promptInput);
        } finally {
            sc.close();
        }
    }        
}
