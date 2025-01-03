package w1_5_debugger;

import java.util.Scanner;

public class FactorialCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a non-negative integer to calculate its factorial: ");
        int n = scanner.nextInt();
        
        int result = calculateFactorial(n);
        
        System.out.println("Factorial of " + n + " is: " + result);
        
        scanner.close();
    }

    private static int calculateFactorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Input should be a non-negative integer.");
        }
        
        if (num == 0 || num == 1) {
            return 1;
        } else {
            // Set a breakpoint on the line below to start debugging from here
            int partialResult = num * calculateFactorial(num - 1);
            return partialResult;
        }
    }
}