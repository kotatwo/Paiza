package rankA;

import java.util.Scanner;

public class GodJanken {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int N = scr.nextInt();
		int M = scr.nextInt();
		char[] eh = scr.next().toCharArray(); //これだけでGCPという入力をeh[0]=G eh[1]=C eh[2]=Pという風にできる。
		int[] MH = new int[] { 0, 0, 0 };
		int maxWinCount = 0;
		//List<Integer> list = new ArrayList<Integer>();
		final int Cc = 2, Pp = 5;
		int[] handG = new int[N];
		int[] handC = new int[N];
		int[] handP = new int[N];
		for (int i = 0; i < N; i++) {
			switch (eh[i]) {
			case 'G': //   ' 'だとcharで," "だとStringらしい...
				MH[2]++;
				break;
			case 'C':
				MH[0]++;
				break;
			case 'P':
				MH[1]++;
				break;

			}
		}
		for (int i = 0, k = 0; i < N; i++) {
			for (int j = 0; i + j < N; j++) {
				if (i * Cc + j * Pp == M) {
					handC[k] = i;
					handP[k] = j;
					handG[k] = N - i - j;
					k++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			int preWinCount = 0;
			if (handG[i] == 0 && handC[i] == 0 && handP[i] == 0) {
				break;
			}
			preWinCount += judge(MH[0], handG[i]);
			preWinCount += judge(MH[1], handC[i]);
			preWinCount += judge(MH[2], handP[i]);
			if (maxWinCount < preWinCount) {
				maxWinCount = preWinCount;
			}

		}
		System.out.println(maxWinCount);
		scr.close();

	}

	public static int judge(int MH, int hand) {
		if (MH <= hand) {
			return MH;
		} else {
			return hand;
		}

	}

}

//https://paiza.jp/works/mondai/skillcheck_sample/janken/edit?language_uid=java