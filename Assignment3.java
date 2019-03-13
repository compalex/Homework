package hw;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/*
* Assignment 3
* @author Aliaksandr Yarmak
*/
public class Assignment3 {

    public static void main(String[] args) {
        double maxAverageScore = 0;
        int bestAthleteId = 0;
        //variables "maxScoreOfAll" and "idOfMaxScore" are for optional task:
        double maxScoreOfAll = 0;
        int idOfMaxScore = 0;

        Scanner sc = null;

        try {
            sc = new Scanner(new File("scores.txt"));

            while (sc.hasNext()) {               
                double score;
                double sum = 0;
                double maxScore = 0;
                double minScore = 10;                
                
                int athleteID = sc.nextInt();
                int judgeQuantity = sc.nextInt();
                
                for (int i = 1; i <= judgeQuantity; i++) {
                    score = sc.nextDouble();
                    sum += score;
                    if(score >= maxScore) maxScore = score;
                    if(score <= minScore) minScore = score; 
                }
                sum -= maxScore + minScore;
                double averageScore = sum / (judgeQuantity - 2);
                System.out.printf("The average score of the athlete #%d is %.3f\n", athleteID, averageScore);
                if (averageScore > maxAverageScore) {
                    maxAverageScore = averageScore;
                    bestAthleteId = athleteID;
                }
                //the next "if-statement" is for optional task
                if(maxScoreOfAll <= maxScore) {
                    maxScoreOfAll = maxScore;
                    idOfMaxScore = athleteID;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file is not found");
        } finally {
            if(sc != null) sc.close();
        }
        System.out.printf("\nThe athlete with #%d has the highest average score %f\n", bestAthleteId, maxAverageScore);
        System.out.printf("The athlete with #%d has the highest single score %f", idOfMaxScore, maxScoreOfAll);
    }

}
