package rankD;

import java.util.Scanner;

public class Amari {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int A = scr.nextInt();
		int B = scr.nextInt();
		
		System.out.println(A%B);
		scr.close();
	}

}
