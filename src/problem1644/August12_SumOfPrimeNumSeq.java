package problem1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class August12_SumOfPrimeNumSeq {
//https://www.acmicpc.net/problem/1644
	static boolean[] isPrime;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//1 ≤ N ≤ 4,000,000
		
		isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		int[] pTree = new int[2*n];
		int sqrtN = (int) Math.sqrt(n);
		for( int i = 2; i <=sqrtN; i++ ) {
			if(!isPrime[i]) {continue;}
			update(pTree, i, i);
			for(int j = i*i; j<=n; j+=i ) {
				isPrime[j] = false;
			}
		}
		for( int i =sqrtN+1; i<=n; i++ ) {
			if(!isPrime[i]) {continue;}
			update(pTree, i, i);
		}
		int count = 0; 
		int l = 2;
		int r = l;
		int continuousSum =0 ;
		while( l<=n && r<=n && l<=r && isPrime[l] && isPrime[r]) {
			continuousSum = query(pTree,r)-query(pTree,l-1);
			if(continuousSum == n) {
				count++;
				r = getRightOf(r);
				l = getRightOf(l);
			}else if( continuousSum > n) {
				l = getRightOf(l);
			}else {
				r = getRightOf(r);
			}
		}
		System.out.println(count);
	}
	public static int getRightOf(int current) {
		int next = current;
		while(++next<isPrime.length&&!isPrime[next]);;
		return next;
	}
	public static void update(int[] fenwick, int i, int value) {
		while(i<fenwick.length) {
			fenwick[i] += value;
			i += (i & -i);
		}
	}
	public static int query(int[] fenwick, int i) {
		int ans = 0;
		while(i>0) {
			ans+=fenwick[i];
			i -= (i&-i);
		}
		return ans;
	}
}
