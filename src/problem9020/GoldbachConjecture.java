package problem9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoldbachConjecture {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int[] cases = new int[testCase];
		int max = 0;
		for(int i =0 ; i< testCase; i++) {
			cases[i] = Integer.parseInt(br.readLine());
			if( max < cases[i]) {
				max = cases[i];
			}
		}
		boolean[] isPrime = new boolean[max+1];
		Arrays.fill(isPrime, true);
		int sqrtN = (int) Math.sqrt(max);
		for(int i =2; i<= sqrtN ; i++ ) {
			for(int j = i*i; j<=max; j+=i) {
				isPrime[j] = false;
			}
		}
		
		for(int i = 0; i< testCase; i++ ) {
			int n = cases[i];
			int l = 0;
			int r = n;
			
			int answerLeft = 0; 
			int answerRight = 0;
			for(; l<=n/2; l++, r-- ) {
				if( !isPrime[l] || !isPrime[r] ) { continue;}
				if( (l+r) == n ) {
					answerLeft = l; answerRight =r;
				}
			}
			System.out.println(answerLeft +" " +answerRight);
		}
	}
}
