package hw;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
* Assignment 2
* @author Aliaksandr Yarmak
*/
public class Assignment2 {

    public static void main(String[] args) {

        int idNum = 0, winNum = 0, losNum = 0;
        int teamsQuant = 0;
        Scanner sc;

        for (int i = 0; i <= teamsQuant; i++) {

            try {
                sc = new Scanner(new File("teams.txt"));
                for (int j = 0; j < i; j++) {
                    sc.nextLine();
                }
                idNum = sc.nextInt();
                winNum = sc.nextInt();
                losNum = sc.nextInt();
                System.out.printf("Team %d \n%d wins\t%d losses\n", idNum, winNum, losNum);

                int totalNum = winNum + losNum;
                System.out.printf("Total number of games played is %d\t%d games remaining\n", totalNum, 25 - totalNum);

                double winAverage = (double) winNum / totalNum;
                System.out.printf("The winning average is %.4f\n", winAverage);

                if (winNum <= (25 - totalNum)) {
                    System.out.println("Number of games remaining is greater than or equal to number won.");
                } else
                    System.out.println("Number of games remaining is less than number won.");

                if (losNum < (25 - totalNum)) {
                    System.out.println("Number of games remaining is greater than number lost.");
                } else
                    System.out.println("Number of games remaining is less than or equal to number won.");
                teamsQuant++;

            } catch (FileNotFoundException e) {
                System.out.println("File is not found");
            } catch (NoSuchElementException e) {
                System.out.println("List of teams is ended, there are " + teamsQuant + " teams totally");
            }

            System.out.println("\n");
        }
    }
}
