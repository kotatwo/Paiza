package rankC;

import java.util.Scanner;

public class Forloop {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int N = scr.nextInt(); // 参加者
		int M = scr.nextInt(); // 枚数
		int K = scr.nextInt(); // 得点得られる数字
		int score = 0;
		
		int[][] a = new int[N][M];
		
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<M ; j++) {
				a[i][j]=scr.nextInt();	
			}
		}
		
		for(int i = 0; i<N ; i++) {
			for(int j = 0 ; j<M ; j++) {
				if(a[i][j] == K) {score++;}
				
			}
			System.out.println(score);
			score=0;
		}
		scr.close();
	}

}
