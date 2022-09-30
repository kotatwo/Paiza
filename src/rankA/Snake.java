package rankA;

import java.util.Scanner;

public class Snake {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int H = scr.nextInt();//行数
		int W = scr.nextInt();//列数
		int Y = scr.nextInt();//初期位置ｙ軸
		int X = scr.nextInt();//初期位置x軸
		int N = scr.nextInt();//方向転換回数
		int[] T = new int[N]; //方向転換する時間
		String state = "U"; //現在の進行方向　
		String[] E = new String[N]; //転換方向
		char[] TM = new char[W];//一時的に使う
		char[][] M = new char[H][W]; //MAP

		for (int i = 0; i < H; i++) {
			TM = scr.next().toCharArray();
			for (int j = 0; j < W; j++) {
				M[i][j] = TM[j];//MAPの入力

			}
		}
		for (int i = 0; i < N; i++) {
			T[i] = scr.nextInt(); //方向転換の時間の設定
			E[i] = scr.next(); //方向転換の方向
		}
		scr.close();

		for (int i = 0, k = 0; i <= 100 && Y >= 0 && Y < H && X >= 0 && X < W && M[Y][X] != '*'
				&& M[Y][X] != '#'; i++) {
			M[Y][X] = '*';
			if (i == T[k]) {
				if (state.equals("U")) {
					if (E[k].equals("R")) {
						state = "R";
					} else {
						state = "L";
					}
				} else if (state.equals("R")) {
					if (E[k].equals("R")) {
						state = "D";
					} else {
						state = "U";
					}
				} else if (state.equals("D")) {
					if (E[k].equals("R")) {
						state = "L";
					} else {
						state = "R";
					}
				} else {
					if (E[k].equals("R")) {
						state = "U";
					} else {
						state = "D";
					}
				}
				if (k != N - 1) {
					k++;
				}
			}
			if (state.equals("U")) {
				Y -= 1;
			} else if (state.equals("R")) {
				X += 1;
			} else if (state.equals("D")) {
				Y += 1;
			} else {
				X -= 1;
			}

		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(M[i][j]);
			}
			System.out.println();
		}

	}

}
//クリア！（何度か失敗）
//https://paiza.jp/works/mondai/a_rank_level_up_problems/a_rank_snake_mapmove_boss?language_uid=java
