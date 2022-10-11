package rankA;

import java.util.Scanner;

public class MaxAve {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int N = scr.nextInt(); // 日数
		int K = scr.nextInt(); //キャンペーンの日数
		int[] allDays = new int[N]; //入力される人数
		int max = 0;
		final double PT = N - (K - 1); //試行回数4
		int maxCount = 0; //候補数
		int maxStart = 0;//候補のうちの一番早い開始日の日にち




		for (int i = 0; i < PT; i++) {
			int temp = 0;
			for (int k = 0; k < K; k++) {
				if(i==0) {allDays[k] = scr.nextInt();}
				if(k == K-1 && i>0) {allDays[ k + i] = scr.nextInt();}
				temp += allDays[k + i];
			}
			if (max < temp) {
				max = temp;
				maxStart = i + 1;
				maxCount=1;
				continue;
			}
			if(max == temp) {
				maxCount++;
			}


		}

		System.out.println(maxCount + " " + maxStart);

		scr.close();
	}

}
//https://paiza.jp/works/mondai/skillcheck_archive/max_range_large/edit?language_uid=java
//ラ、ランタイムエラーです。