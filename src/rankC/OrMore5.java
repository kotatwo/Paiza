package rankC;

import java.util.Scanner;

public class OrMore5 {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int N = scr.nextInt();
		int Total=0, temp=0;
		for(int i=0 ; i<N ; i++) {
			 temp = scr.nextInt();
			 if(temp >=5) {Total+=temp;}
		}
		System.out.println(Total);
		scr.close();

	}

}
