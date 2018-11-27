package problem2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbUpStepsDP {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] points = new int[n+1];
		for(int i = 1; i <= n; i++ ) {
			points[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[n+1];
		dp[1] = points[1];
		dp[2] = points[2]+points[1];
		for(int i = 3; i<=n ; i++ ) {
			dp[i] = Math.max(dp[i-2] + points[i], dp[i-3] + points[i-1] + points[i]);			
		}
		System.out.println(dp[n]);
	}
	
}
