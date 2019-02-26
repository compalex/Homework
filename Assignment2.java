package hw;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/*
* Assignment 2
* @author Aliaksandr Yarmak
*/
public class Assignment2 {
    private static double bestAverage = 0; // optional task #2
    private static int bestTeamId = 0; // optional task #2

    public static void main(String[] args) {
        Scanner sc = null;

        try {
            sc = new Scanner(new File("teams.txt"));
            int teamsCount = 0;

            while (sc.hasNextLine()) {
                ++teamsCount;               
                int id = sc.nextInt();
                int wins = sc.nextInt();
                int loses = sc.nextInt();               
                showTeamInfo(id, wins, loses);        
            }
            System.out.println("List of teams is ended, there are " + teamsCount + " teams totally");
            System.out.printf("The best average that is equal %.4f which belongs to the team #%d", bestAverage, bestTeamId);
            
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        } finally {
            if (sc != null) sc.close();
        }
    }

    private static void showTeamInfo(int id, int wins, int losses) {
        System.out.printf("Team %d \n%d wins\t%d losses\n", id, wins, losses);

        int totalNum = wins + losses;
        System.out.printf("Total number of games played is %d\t%d games remaining\n", totalNum, 25 - totalNum);

        double winAverage = (double) wins / totalNum;
        System.out.printf("The winning average is %.4f\n", winAverage);

        if (wins <= (25 - totalNum)) {
            System.out.println("Number of games remaining is greater than or equal to number won.");
        } else {
            System.out.println("Number of games remaining is less than number won.");
        }

        if (wins < (25 - totalNum)) {
            System.out.println("Number of games remaining is greater than number lost.");
        } else {
            System.out.println("Number of games remaining is less than or equal to number won.");
        }
        
        if (totalNum < 25) { // optional task #1
            System.out.println("If this team wins the remaining games, the team's record will be:");
            int newWins = wins + 25 - totalNum;
            double newWinAverage = (double) newWins / 25;
            System.out.printf("%d wins\t%d losses %.4f winning average\n", newWins, losses, newWinAverage);
            
            System.out.println("If this team loses the remaining games, the team's record will be:");
            int newLosses = losses + 25 - totalNum;
            newWinAverage = (double) wins / 25;
            System.out.printf("%d wins\t%d losses %.4f winning average\n", wins, newLosses, newWinAverage);
        }
        
        if (winAverage > bestAverage && winAverage != 1) { // optional task #2
            bestAverage = winAverage;
            bestTeamId = id;
        }
        System.out.println();                        
    }
}