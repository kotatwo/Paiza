package rankC;

import java.util.Scanner;

public class Leftovers {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		double m = scr.nextDouble();
		double p = scr.nextDouble();
		double q = scr.nextDouble();
		double result = m;
		
		result =  m*(100-p)/100;
		result = result*(100-q)/100;
		System.out.printf("%.4f\n", result);
		scr.close();
	}

}
