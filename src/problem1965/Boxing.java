package problem1965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boxing {
//https://www.acmicpc.net/problem/1965
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		String[] tokens = br.readLine().split(" ");
		for(int i=0; i< n; i++) {
			a[i] = Integer.parseInt(tokens[i]);
		}
		
		int[] dp = new int[n];
		int tail = 0;
		dp[tail++] = a[0];
		for(int i = 1; i< n; i++) {
			if(dp[tail-1]<a[i]) {
				dp[tail++] = a[i];
			}else {
				int pointer = lowerbound(dp, 0, tail-1, a[i]);
				dp[pointer] = a[i];
			}
		}
		System.out.println(tail);
	}
	static int lowerbound(int[] dp, int start, int end, int n) {
		while(start<end) {
			int mid = (start+end)/2;
			if( dp[mid] >= n ) {
				end = mid;
			} else {
				start =mid+1;
			}
		}
		return end;
	}
}
