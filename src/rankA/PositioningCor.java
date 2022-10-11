package rankA;

import java.util.ArrayList;
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
		ArrayList<Integer> axL = new ArrayList<Integer>();
		ArrayList<Integer> ayL = new ArrayList<Integer>();
		ArrayList<Integer> bxL = new ArrayList<Integer>();
		ArrayList<Integer> byL = new ArrayList<Integer>();
		
		char[][] Map = new char[H][W]; //Map用の配列
		char[] TMap = new char[H]; //一時的に保存する用
		for (int i = 0; i < H; i++) { //Map入力
			TMap = scr.next().toCharArray();
			System.arraycopy(TMap, 0, Map[i], 0, W);
			//↑配列のコピーはSystem.arraycopy(コピー元配列名, 開始位置, コピー先配列, 開始位置, 終了位置)
		}
		for(int i = 0, AB = 0; AB != 2 ; i++) {
			for(int j = 0 ; j < W ; j++) {
				if(Map[i][j] == 'A') {
					axL.add(i);
					ayL.add(j);
					AB++;
				}else if(Map[i][j] == 'B') {
					bxL.add(i);
					byL.add(j);
					AB++;
				}
			}
		}

		while (AE == 1 || BE == 1) { //関数turnで処理がなされなかったら終了。
			if (N.equals("A") && AE != 0) {
				AE = turn(H, W, 'A', Map, axL, ayL);
			}
			if(BE != 0) {
			BE = turn(H, W, 'B', Map, bxL, byL);
			}						//AEが0なら呼び出さない
			
			if (N.equals("B") && AE != 0) {
				AE = turn(H, W, 'A', Map, axL, ayL);
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

	@SuppressWarnings("unchecked")
	public static int turn(int H, int W, char AB, char[][] map, ArrayList<Integer> xL,ArrayList<Integer> yL ) {
		int end = 0;
		ArrayList<Integer> txL = (ArrayList<Integer>) xL.clone();
		ArrayList<Integer> tyL = (ArrayList<Integer>) yL.clone();
		xL.clear();
		yL.clear();
		
		for(int i=0 ; i < txL.size() ;  i++) {
			int X = txL.get(i);
			int Y = tyL.get(i);
			
			if (map[X][Y] == AB) {
				if (X != 0 && map[X - 1][Y] == '.') {
					map[X - 1][Y] = AB;
					end = 1;
					xL.add(X-1);
					yL.add(Y);
				} //上の値の処理
				if (Y != 0 && map[X][Y - 1] == '.') {
					map[X][Y - 1] = AB;
					end = 1;
					xL.add(X);
					yL.add(Y-1);
				} //左の値の処理
				if (Y != W - 1 && map[X][Y + 1] == '.') {
					map[X][Y + 1] = AB;
					end = 1;
					xL.add(X);
					yL.add(Y + 1);
				} //右の値の処理
				if (X != H - 1 && map[X + 1][Y] == '.') {
					map[X + 1][Y] = AB;
					end = 1;
					xL.add(X+1);
					yL.add(Y);
				} //下の値の処理
			}

		}

		return end;

	}

}

//https://paiza.jp/works/mondai/a_rank_level_up_problems/a_rank_camp_boss/edit?language_uid=java
//訓練校の先生にヒントをもらい無事クリア！