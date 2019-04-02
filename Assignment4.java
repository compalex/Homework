package hw;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Assignment 4
* @author Aliaksandr Yarmak
*/
public class Assignment4 {
    
    public static final String INTRO1 = "This program asks user to input 3 nums, then it finds the sum of them and prints a name";
    public static final String INTRO2 = "You need to input '-2', '-2', '-8' consistently to stop the program";
    public static final String PROMPT = "Type in three original integers:    (type in '-2', '-2', '-8' to stop)";
    public static final String NUMS_INTRO = "The three original integers are: %d, %d, %d \n";
    public static final String IMPOSSIBLE = "It is not possible to print the name!";
    public static final String NAME = "Alex Yarmak";
    public static final String SUM_INTRO = "The sum of the larger 2 of the three values is: ";
    public static final String EVEN_INTRO = "There is/are %d even number(s) \n";
    public static final String SETS_INTRO = "%d sets of three date values were entered and processed\n";
    public static final String LARGEST_SUM_INTRO = "The largest value ever computed for the sum is ";
    public static final String SMALLEST_SUM_INTRO = "The smallest value ever computed for the sum is ";
    public static final String NAMES_COUNTER_INTRO = "The total number of time a name was printed: ";
    public static int namePrintCounter = 0;
    
    public static void main(String[] args) {   
        introduction();
        
        int setsCounter = 0;
        //largestSum and smallestSum are used for optional task #2 
        int largestSum = 0;
        int smallestSum = 0;
        
        Scanner sc = new Scanner(System.in);
        
        try {
            while (true) {  
                System.out.println(PROMPT);                
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                int num3 = sc.nextInt();
                
                if(num1 == -2 && num2 == -2 && num3 == -8) {
                    break;
                }                
                System.out.printf(NUMS_INTRO, num1, num2, num3);
                
                int sum = findSum(num1, num2, num3);
                System.out.println(SUM_INTRO + sum);
                
                printMyName(sum);
                
                int evenNums = howManyEven(num1, num2, num3);
                System.out.printf(EVEN_INTRO, evenNums);
                System.out.println("\n\n");
                setsCounter++;
                //the next if-statements are for optional task #2
                if(sum > largestSum) {
                    largestSum = sum;
                }
                if(sum < smallestSum) {
                    smallestSum = sum;
                }
            }
        } catch (InputMismatchException e) {
            System.err.println(e);
        } finally {
            sc.close();
        }       
        System.out.printf(SETS_INTRO, setsCounter);
        System.out.println(NAMES_COUNTER_INTRO + namePrintCounter);
        System.out.println(LARGEST_SUM_INTRO + largestSum);
        System.out.println(SMALLEST_SUM_INTRO + smallestSum);
    }

    public static void introduction() {
        System.out.println(INTRO1);
        System.out.println(INTRO2);
    }
    
    public static int findSum(int num1, int num2, int num3) {
        if(num1 >= num2) {
            if(num2 >= num3) {
                return (num1 + num2);
            } else {
                return (num1 + num3);
            }
        } else {
            if(num1 >= num3) {
                return (num1 + num2);
            } else {
                return (num2 + num3);
            }            
        }
    }
    
    private static void printMyName(int sum) {
        if(sum <= 0 || sum > 10) {
            System.out.println(IMPOSSIBLE);
        } else {
            for(int i = 0; i < sum; i++) {
                System.out.println(NAME);
                namePrintCounter++;
            }
        }
    }
    
    private static int howManyEven(int num1, int num2, int num3) {
        int counter = 0;
        if (num1 %2 == 0) {
            counter++;
        }
        if (num2 %2 == 0) {
            counter++;
        }
        if (num3 %2 == 0) {
            counter++;
        }
        return counter;
    }
}