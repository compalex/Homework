package hw;

import java.util.Scanner;

public class Ass2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean gotTheAnswer = false;
        int idNum = 0;
        int winNum = 0;
        int losNum = 0;

        while (!gotTheAnswer) {
            System.out.println("Input the id number of the team!");
            if (!sc.hasNextInt()) {
                System.out.println("Wrong input!");
                gotTheAnswer = false;
                sc.nextLine();
            } else {
                idNum = sc.nextInt();
                gotTheAnswer = true;
            }
        }
        gotTheAnswer = false;
        
        while (!gotTheAnswer) {
            System.out.println("Input the number of wins this team has!");
            if (!sc.hasNextInt()) {
                System.out.println("Wrong input!");
                gotTheAnswer = false;
                sc.nextLine();
            } else {
                winNum = sc.nextInt();
                gotTheAnswer = true;
            }
        }
        gotTheAnswer = false;
        
        while (!gotTheAnswer) {
            System.out.println("Input the number of losses this team has!");
            if (!sc.hasNextInt()) {
                System.out.println("Wrong input!");
                gotTheAnswer = false;
                sc.nextLine();
            } else {
                losNum = sc.nextInt();
                gotTheAnswer = true;
            }
        }
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
}
