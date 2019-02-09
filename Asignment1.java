/**
* Asignment 1
* @author Aliaksandr Yarmak
*/
public class Assignment1 {

    public static void main(String[] args) {
        System.out.println("Hello, my name is Aliaksandr Yarmak, and this is the output of my first program.");
        double x, y;
        int counterZero = 0, counterPos = 0, counterNeg = 0;
        double closestToZero = 0, closestX = 0;

        for (x = -3; x <= 3; x += 0.5) {
            y = (4 * Math.pow(x, 3) + 8 * Math.pow(x, 2) - 31 * x - 35)
                    / (Math.pow((3 * Math.pow(x, 2) + 1), 0.5) + 2 * Math.abs(x - 1.5));
            System.out.printf("X = %.2f\t Y = %.2f\t", x, y);
            if (y < 0) {
                System.out.println("Y is NEGATIVE.");
                counterNeg++;
            }
            if (y > 0) {
                System.out.println("Y is POSITIVE.");
                counterPos++;
            }
            if (y == 0) {
                System.out.println("Y is ZERO.");
                counterZero++;
            }
            if (y != 0) {
                if (closestToZero == 0) {           //in 1st case while closestToZero = 0 by default
                    closestToZero = Math.abs(y); 
                    closestX = x;
                }   
                if (closestToZero > Math.abs(y)) {
                    closestToZero = Math.abs(y);
                    closestX = x;
                }                                
            }
        }
        System.out.println("The main program is complete. Now optional tasks:");
        System.out.printf("Y is positive %d times.\n", counterPos);
        System.out.printf("Y is negative %d times.\n", counterNeg);
        System.out.printf("Y is zero %d times.\n", counterZero);
        System.out.printf("When X = %.1f, value of Y is closest to zero. Distance from zero: %.2f.", closestX, closestToZero);
    }
}