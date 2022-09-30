package rankA;

import java.util.Scanner;

public class PositioningCor {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int H = scr.nextInt(); //行数
		int W = scr.nextInt(); //列数
		String N = scr.next(); //先攻は誰？AかBかで答えてください。
		int AC = 0; //最終的なAの数
		int BC = 0; //最終的なBの数
		int AE = 1; //Aの処理が全て終わると0になる
		int BE = 1; //Bの処理がすべて終わると0になる
		char[][] Map = new char[H][W]; //Map用の配列
		char[] TMap = new char[H]; //一時的に保存する用
		for (int i = 0; i < H; i++) { //Map入力
			TMap = scr.next().toCharArray();
			System.arraycopy(TMap, 0, Map[i], 0, W);
			//↑配列のコピーはSystem.arraycopy(コピー元配列名, 開始位置, コピー先配列, 開始位置, 終了位置)
		}

		while (AE == 1 || BE == 1) { //関数turnで処理がなされなかったら終了。
			if (N.equals("A") && AE != 0) {
				AE = turn(H, W, 'A', Map);
			}
			if(BE != 0) {
			BE = turn(H, W, 'B', Map);
			}						//AEが0なら呼び出さない
			
			if (N.equals("B") && AE != 0) {
				AE = turn(H, W, 'A', Map);
			}						//BEが0なら呼び出さない
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (Map[i][j] == 'A') {
					AC += 1;
				} else if (Map[i][j] == 'B') {
					BC += 1;
				}
			}
		}
		System.out.println(AC + " " + BC);
		if (AC > BC) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(Map[i][j]);
			}
			System.out.println();
		}
		scr.close();

	}

	public static int turn(int H, int W, char AB, char[][] map) {
		int end = 0;
		char ABmap[][] = new char[H][W];
		for (int i = 0; i < H; i++) {
			System.arraycopy(map[i], 0, ABmap[i], 0, W);
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (ABmap[i][j] == AB) {
					if (i != 0 && map[i - 1][j] == '.') {
						map[i - 1][j] = AB;
						end = 1;
					} //上の値の処理
					if (j != 0 && map[i][j - 1] == '.') {
						map[i][j - 1] = AB;
						end = 1;
					} //左の値の処理
					if (j != W - 1 && map[i][j + 1] == '.') {
						map[i][j + 1] = AB;
						end = 1;
					} //右の値の処理
					if (i != H - 1 && map[i + 1][j] == '.') {
						map[i + 1][j] = AB;
						end = 1;
					} //下の値の処理
				}

			}

		}
		return end;

	}

}
//https://paiza.jp/works/mondai/a_rank_level_up_problems/a_rank_camp_boss/edit?language_uid=java
//訓練校の先生に添削していただきました。