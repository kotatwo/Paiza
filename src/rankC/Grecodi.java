package rankC;

import java.util.Scanner;

public class Grecodi {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int n1 = scr.nextInt();
		int n2 = scr.nextInt();
		int min = Math.min(n1, n2);
		int ans = 0;
		
		for(int i = min ; i>0 ; i--) {
			if(n1%i == 0 && n2 % i == 0 ) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
		scr.close();
	}

}
