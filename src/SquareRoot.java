import java.util.Scanner;

public class SquareRoot {

	private static final double FACTOR = 0.00001;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		System.out.printf("%.3f", squareRoot(n));
		in.close();
	}
	public static double squareRoot(double n)  
    {  
        double x = n;
        double root;      
        while (true) 
        {
            root = 0.5 * (x + (n / x));  
            if (Math.abs(root - x) < FACTOR) {
                break;
        	}
            x = root;  
        }
        return root;  
    }
} 

/**
 * 
 * 9
 * 0 1 2 3 4 5 6 7 8 9 10 11
 *     1 1 2 2 2     3  3
 *     
 *     100
 *     2, 4, 5, 10, 25, 50
 *     
 *     10 --> 3.1
 *   
 *     11 --> 3.31
 *     
 *      
 * 
 */
