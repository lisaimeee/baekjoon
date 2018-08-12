package problem1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class August12_SumOfPrimeNumSeq2 {
//https://www.acmicpc.net/problem/1644
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//1 ≤ N ≤ 4,000,000
		
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
//		int sqrtN = (int)Math.sqrt(n);
		for( int i = 2; i<=n; i++ ) {
			if(!isPrime[i]) {continue;}
			for(int j = i*i; j<=n; j+=i ) {
				isPrime[j] = false;
			}
		}
		int count = 0; 
		int l = 2;
		int r = l;
		int sum = l; 
		
		while(l<=n && r <=n && l<=r && isPrime[l] && isPrime[r]) {
			if(sum == n ) { 
				count ++;
				while(++r<=n && !isPrime[r]);;
				if(r<=n&&isPrime[r]) { sum+=r;}
				sum-=l;
				while(++l<=n && !isPrime[l]);;
			}else if( sum < n ) { 
				while(++r <=n && !isPrime[r]);;
				if(r<=n&&isPrime[r]) { sum+=r;}
			}else {
				sum-=l;
				while(++l<=n && !isPrime[l]);;
			}
		}
		System.out.println(count);
	}
}
