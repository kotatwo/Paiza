package rankA;

import java.util.Scanner;

public class Connect {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt(); //頂点数
		int m = scr.nextInt(); //辺数
		int[] graph = new int[n]; //グラフ。すべて1になれば初期化成功	
		String answer = "YES";

		for (int i = 0; i < n; i++) {
			graph[i] = 0;
		}

		for (int i = 0, j = 1; i < m; i++) {
			int t1 = scr.nextInt() - 1;
			int t2 = scr.nextInt() - 1; //t1,t2 辺の両端の頂点の番号
			if (graph[t1] == 0 && graph[t2] == 0) {//どちらも連結してない場合
				graph[t1] = j;
				graph[t2] = j;
				j++;
			} else if (graph[t1] != 0 && graph[t2] != 0) {//どちらも連結している場合
				int cpa = Math.min(graph[t1], graph[t2]); //こっちで染める
				int cpb = Math.max(graph[t1], graph[t2]); //染められる方
				bothConnect(graph, cpa, cpb, n);//cpbをcpaの値で上書きする

			} else {//どちらかが連結している場合
				int cp = Math.max(graph[t1], graph[t2]);
				graph[t1] = cp;
				graph[t2] = cp;

			}

		}

		for (int i = 0; i < n; i++) {
			//System.out.println(graph[i]);  これが全部１でYES
			if (graph[i] != 1) {
				answer = "NO";
			}
		}
		System.out.println(answer);
		scr.close();
	}

	public static void bothConnect(int[] graph, int cpa, int cpb, int n) {
		for (int i = 0; i < n; i++) {
			if (graph[i] == cpb) {
				graph[i] = cpa;
			}
		}

	}

}
//https://paiza.jp/works/mondai/a_rank_level_up_problems/a_rank_graph_boss/edit?language_uid=java
//やったぜ★