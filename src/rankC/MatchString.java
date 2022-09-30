package rankC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class MatchString {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		
		String N = reader.readLine();
		int Num = Integer.parseInt(N);
		String[] thm= new String[Num];
			int[] ph= new int[Num], 
				 pm= new int[Num],
				 h= new int[Num],
				 m = new int[Num];
	for(int i =0 ; i<Num ; i++){
			thm[i] = reader.readLine();
		}
		
		var ptn = Pattern.compile("(\\d+):(\\d+) (\\d+) (\\d+)");
		for(int i=0 ; i<Num ; i++ ) {
		var match = ptn.matcher(thm[i]);
		while(match.find()) {
		 ph[i] = Integer.parseInt(match.group(1));
		 pm[i] = Integer.parseInt(match.group(2));
		 h[i] = Integer.parseInt(match.group(3));
		 m[i] = Integer.parseInt(match.group(4));
		 int totalh=ph[i]+h[i];
		 int totalm=pm[i]+m[i];
		 if(totalm>=60) {totalm-=60; totalh++;}
		 if(totalh>=24) {totalh-=24;}
		 System.out.printf("%02d:%02d\n", totalh,totalm);
		}
		}
		 
		
		
		}

	}


