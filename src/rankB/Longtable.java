package rankB;

import java.util.Arrays;
import java.util.Scanner;

public class Longtable {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int N = scr.nextInt();//座席数
		int M = scr.nextInt();//グループ数
		int[] S = new int[N];
		int No = 0;

		for (int i = 0; i < M; i++) {
			int J = scr.nextInt();//グループの人数
			int T = scr.nextInt();//開始位置
			for (int j = T - 1, k = T - 1; j < T + J - 1; j++, k++) {//誰か座ってないか確認
				if (k > N - 1) {
					k = 0;
				}
				if (S[k] != 0) {
					No = 1;
					break;
				}
			}
			if (No != 1) {
				for (int j = T - 1,k = T - 1; j < T + J - 1; j++, k++) {//座ってないなら座る
					if (k > N - 1) {
						k=0;
					}
					S[k] = 1;
				}
				
			}
			No=0;
		}
		System.out.println(Arrays.stream(S).sum());
		scr.close();
	}

}
//https://paiza.jp/works/mondai/skillcheck_sample/long-table/edit?language_uid=java