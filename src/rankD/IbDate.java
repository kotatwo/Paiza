package rankD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IbDate {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in)
		);
		int i =Integer.parseInt(reader.readLine());
		System.out.println(i-1);
		reader.close();
	}

}
