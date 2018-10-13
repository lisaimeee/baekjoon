package problem2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wire {
//https://www.acmicpc.net/problem/2565
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 100 이하의 자연수 
		int[] s = new int[501]; // 500이하의 자연수 
		// a에 따른 b의 LIS
		for(int i =1; i<= n; i++) {
			String[] tokens = br.readLine().split(" ");
			int numA = Integer.parseInt(tokens[0]);
			int numB = Integer.parseInt(tokens[1]);
			s[numA] = numB;
		}
		
		int[] dp = new int[n];
		int pointer = 0;
		for ( int num : s ) {
			if ( num == 0 ) continue;
			if ( pointer == 0 ) {
				dp[pointer++] = num;
				continue;
			}
			if( dp[pointer-1] < num) {
				dp[pointer++] = num;
			}else {
				int location = lowerBound(dp, 0, pointer-1, num);
				dp[location] = num;
			}
		}
		System.out.println(n-pointer);
	}
	static int lowerBound(int[] dp, int start,int end, int num) {
		while(start<end) {
			int mid = (start+end)/2;
			if(dp[mid]>=num) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return end;
	}
}
