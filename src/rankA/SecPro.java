package rankA;

import java.util.Scanner;

public class SecPro {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int N = scr.nextInt();//要素数
		int K = scr.nextInt();//条件の値
		int[] A = new int[N];//数列
		int twoNumbers = 0; //2の要素数
		int total = 1; //これでKと比較
		int times = 0; //要素を使った回数

		for (int i = 0; i < N; i++) {
			A[i] = scr.nextInt();
			if (A[i] == 2) {
				twoNumbers++;
			}
		}
		if (K == 1) {
			System.out.println("1");
		} else {
			for (int i = 1; i <= twoNumbers; i++) {
				total *= 2;	
				if (total >= K) {
					times=i;
					break;
				}
				
			}
			System.out.println(times);
		}

		scr.close();

	}

}
