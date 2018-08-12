package problem1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GetPrime {
	//2018.08.12
	// TODO: -ing
	static char[] seive; // 2bytes -> 16bit 
	public static void main(String[ ] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");
		
		// 1<= m <= n <= 1,000,000
		int m = Integer.parseInt(token[0]); // start include
		int n = Integer.parseInt(token[1]); // end include 
		seive = new char[(n>>4)+1];
		System.out.println(seive.length);

		

	}
}
