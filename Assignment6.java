package hw;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
* Assignment 5
* @author Aliaksandr Yarmak
*/
public class Assignment6 {
    public static final String SIZE_PROMPT_MSG = "Please, input how many items the array has";
    public static final String ARRAY_PROMPT_MSG = "Please, input what elements the array has";
    public static final String FIRST_ARR_MSG = "Here's the original array:";
    public static final String SECOND_ARR_MSG = "Here is the new array:";
    public static final String AVERAGE_MSG = "Average of array is %.3f";
    private static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        try {
            System.out.println(SIZE_PROMPT_MSG);
            int size = sc.nextInt();
            double[] firstArr = new double[size];            
            System.out.println(ARRAY_PROMPT_MSG);
            firstArr = readData(size, firstArr);
            System.out.println(FIRST_ARR_MSG);
            printArray(size, firstArr);
            double avg = findAverage(size, firstArr);
            System.out.printf(AVERAGE_MSG, avg);
            System.out.println();
            double[] secondArr = howFarAway(size, avg, firstArr);
            System.out.println(SECOND_ARR_MSG);
            printArray(size, secondArr);
            avg = findAverage(size, secondArr);
            System.out.printf(AVERAGE_MSG, avg);
        } catch (InputMismatchException e) {
            System.err.println(e);
        } finally {
            sc.close();
        }
    }

    private static double[] readData(int n, double[] numbers) {
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextDouble();
        }
        return numbers;
    }

    private static void printArray(int q, double[] numb) {
        for (int i = 0; i < q; i++) {
            if (i % 5 == 0 && i != 0) {
                System.out.println();
            }
            System.out.printf("%.2f     ", numb[i]);
        }
        System.out.println();
    }

    private static double findAverage(int k, double[] p) {
        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum += p[i];
        }
        return sum / k;
    }

    private static double[] howFarAway(int m, double avg, double[] r) {
        double[] s = new double[m];

        for (int i = 0; i < m; i++) {
            s[i] = r[i] - avg;
        }
        return s;
    }
}
