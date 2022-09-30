package rankC;

import java.util.Scanner;

public class StandardInput {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		String[] name = new String[N];
		int[] age = new int[N];
		for(int i= 0; i<N ; i++) {
			name[i] = sc.next();
			age[i] = sc.nextInt()+1;
			
		}
		sc.close();
		for(int i= 0; i<N ; i++) {
			System.out.println(name[i]+" "+age[i]);
		}
	}

}
