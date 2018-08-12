package problem1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class June3_TestRgbDistance {
	//https://www.acmicpc.net/problem/1149
	static final int RED = 0;
	static final int GREEN = 1;
	static final int BLUE = 2;
	public static void main(String[] args) {
		try(
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
		){
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int[][] houses = new int[n][3]; 
			for(int i =0; i<n;i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				houses[i][0] = Integer.parseInt(tokenizer.nextToken());
				houses[i][1] = Integer.parseInt(tokenizer.nextToken());
				houses[i][2] = Integer.parseInt(tokenizer.nextToken());
			}
			int cost[][] = new int[n][3];
			cost[0][RED] = houses[0][RED];
			cost[0][GREEN] = houses[0][GREEN];
			cost[0][BLUE] = houses[0][BLUE];
			for(int i =1; i <n ; i++) {
				cost[i][RED] = Math.min(cost[i-1][GREEN], cost[i-1][BLUE])+houses[i][RED];
				cost[i][GREEN] = Math.min(cost[i-1][RED], cost[i-1][BLUE])+houses[i][GREEN];
				cost[i][BLUE] = Math.min(cost[i-1][GREEN], cost[i-1][RED])+houses[i][BLUE];
			}
			System.out.println(Math.min(cost[n-1][RED], Math.min(cost[n-1][GREEN], cost[n-1][BLUE])));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
