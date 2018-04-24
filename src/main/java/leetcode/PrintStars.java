package leetcode;

public class PrintStars {

    public static void main(String[] args) {
        printStars(6, 0);
    }

    public static void printStars(int n, int iter) {
        if (iter <= n) {
            printStartSubroutineSpace((2 * (n + 1) - 1) / 2 - iter, 0);
            printStartSubroutineStars(iter, 0);
            System.out.println();
            printStars(n, iter + 1);
        }
    }

    public static void printStartSubroutineSpace(int numSpaces, int iter) {
        if (iter < numSpaces) {
            System.out.print(" ");
            printStartSubroutineSpace(numSpaces, iter + 1);
        }
    }

    public static void printStartSubroutineStars(int totalStars, int iter) {
        if (iter < totalStars) {
            System.out.print("* ");
            printStartSubroutineStars(totalStars, iter + 1);
        }
    }

}
