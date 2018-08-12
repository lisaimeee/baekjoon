package problem13424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SecretMeeting {
	//https://www.acmicpc.net/problem/13424
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());// number of tests
		while(test-->0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());//number of rooms;
			int m = Integer.parseInt(st.nextToken());// number of edges
			int[][] d = new int[n][n];
			final int INF =Integer.MAX_VALUE/2;
			for(int[] row: d) {
				Arrays.fill(row, INF);
			}
			for(int i =0 ; i <m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				d[a-1][b-1]=c;
				d[b-1][a-1]=c;
			}
			st = new StringTokenizer(br.readLine());
			int numOfFriends = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] friends = new int [numOfFriends];
			for(int i =0; i<numOfFriends;i++) {
				friends[i] = Integer.parseInt(st.nextToken());
			}
			for(int k =0; k<n; k++) {
				for(int i =0; i<n; i++) {
					for(int j =0; j<n; j++) {
						if( i==j ) { d[i][j] = 0;}
						if( d[i][j] > d[i][k]+d[k][j]) {
							d[i][j] = d[i][k]+d[k][j];
						}
					}
				}
			}
			int min = Integer.MAX_VALUE;
			int roomNumber = 0;
			for(int k =0; k<n; k++) {
				int t = 0;
				for(int a: friends) {
					t+=d[a-1][k];
				}
				if(min>t) {
					min = t;
					roomNumber = k;
				}
			}
			System.out.println(roomNumber+1);
		}//while
	}
}
