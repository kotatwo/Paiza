package rankC;

import java.util.Scanner;

public class Shiritori {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int N = scr.nextInt();
		String[] Wo = new String[N];
		int judge = 0;
		for(int i = 0; i<N ; i++) {
			Wo[i] = scr.next();
		}
		for(int i = 0; i<N-1 ; i++) {
			if(!Wo[i].substring(Wo[i].length()-1,Wo[i].length() ).equals( Wo[i+1].substring(0, 1))) {
				System.out.println(Wo[i].substring(Wo[i].length()-1, Wo[i].length()) + " " + Wo[i+1].substring(0, 1));
				judge=1;
				break;
			}
		}
		if(judge == 0) {System.out.println("Yes");}
		scr.close();
	}

}
