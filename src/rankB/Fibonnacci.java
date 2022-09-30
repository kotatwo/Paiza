package rankB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonnacci {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int N = scr.nextInt();
		List<Integer> I = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			I.add(Fibonacci(scr.nextInt()));

		}
		for (var result : I) {
			System.out.println(result);
		}
		scr.close();
	}

	private static Integer Fibonacci(int Inp) {
		if (Inp == 1 || Inp == 2) {
			return 1;
		} else {
			return Fibonacci(Inp - 2) + Fibonacci(Inp - 1);
		}

	}

}
