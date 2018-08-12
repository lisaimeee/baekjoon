package problem1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GetPrime2 {
	//https://www.acmicpc.net/problem/1929
	public static void main(String[ ] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");
		
		// 1<= m <= n <= 1,000,000
		int m = Integer.parseInt(token[0]); // start include
		int n = Integer.parseInt(token[1]); // end include 
		
		int sqrtN = (int) Math.sqrt(n);
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;

		for(int i = 2; i <= sqrtN; i++){
			for(int j = i*i; j <= n; j += i ) {
				isPrime[j] = false;
			}
		}
		
		int count=0;
		for(int i = 1; i<=n; i++ ) {
			if(isPrime[i]) {
				count++;
				System.out.println(i);
			}
		}
		System.out.println(count);
		
		
	}
}
