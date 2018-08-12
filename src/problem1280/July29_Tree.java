package problem1280;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class July29_Tree {
//1280
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		int[] locations = new int[200001];
		int[] costs = new int[n+1];
		
		
		int location = Integer.parseInt(br.readLine());
		locations[1]=location;
		costs[1] = 0;
		
		
		long answer = 1;
		for(int i = 2 ; i <= n; i++ ) {
			locations[i] = Integer.parseInt(br.readLine());
			int diff = locations[i] - locations[i-1];
			int cost = Math.abs(costs[i-1] = diff);
			for(int j=1; j<i-1; j++ ) {
				cost += Math.abs(costs[j] += diff);
			}
			answer *= cost;
			answer %= 1000000007;
		}
		System.out.println(answer);
	}
	
}
