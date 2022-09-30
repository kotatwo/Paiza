package rankC;

import java.util.Scanner;

public class Handle {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String name = scr.next();
		String handle = name;
		String[] mother = {"a","i","u","e","o","A","I","U","E","O"};
				
		
		for (int i = 0; i < mother.length; i++) {
			handle = handle.replace(mother[i], "");
		}
		System.out.println(handle);
		scr.close();

	}

}
