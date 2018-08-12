package problem6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoldbachConjecture {
// 2018. 08. 12
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/**
		 * 8 = 3 + 5
		 * */
		final int MAX = 1000000;
		boolean[] isPrime = new boolean[MAX+1];
		Arrays.fill(isPrime, true);
		int sqrtN = (int) Math.sqrt(MAX);
		isPrime[1] = false;
		for(int i=2; i<=sqrtN ; i++ ) {
			for(int j = i*i ; j<=MAX; j+=i ) {
				isPrime[j] = false;
			}
		}
		
		int testcase=0;
		while(0 < (testcase = Integer.parseInt(br.readLine())) ) {
			boolean isWrong = true;
			int l = 1;
			int r = testcase-1;
			for(; l<=testcase/2; l+=2, r-=2) {
				if( !isPrime[l] || !isPrime[r] ) {continue;}
				if( (l+r) == testcase ) {
					isWrong = false;
					System.out.println(testcase +" = " + l +" + "+ r);
					break;
				}
			}
			if(isWrong) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
				
	}
}
