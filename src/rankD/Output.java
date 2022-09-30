package rankD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Output {

	public static void main(String[] args) throws IOException {
		BufferedReader reader= new BufferedReader(
				new InputStreamReader(System.in));
		
		String n = reader.readLine();
		String h = reader.readLine();
		
		int number = Integer.parseInt(n);
		int hour = Integer.parseInt(h);
		
		System.out.println(number*hour);
		

	}

}
