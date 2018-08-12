package problem4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class June24_Jelda {
//https://www.acmicpc.net/problem/4485
	public static void main(String[] args) {
		try (
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
		){
			int N = Integer.parseInt(reader.readLine());
			int n = 0;
			while( N!=0 ){
				n++;
				int[][] cave = new int[N][N];
				StringTokenizer tokenizer = null;
				for(int i = 0; i<N ; i ++) {
					tokenizer = new StringTokenizer(reader.readLine());
					for(int j =0; j<N; j++) {
						cave[i][j] = Integer.parseInt(tokenizer.nextToken());
					}
				}
				int lost =0 ; 
				lost = escape(cave);
				System.out.println("Problem "+n+": "+ lost);
				
				N = Integer.parseInt(reader.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static int[] moveX = {-1,1,0,0};
	static int[] moveY = {0,0,-1,1};
	public static int escape(int[][] cave) {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		int x= 0, y=0, n = cave.length;
		boolean[][] seen = new boolean[n][n];
		int lost=cave[x][y];
		seen[x][y] = true;
		for(int i =0;i<4; i++) {
			int newX = x+moveX[i];
			int newY = y + moveY[i];
			if(newX<0||newX>=n||newY<0||newY>=n) {
				continue;
			}
			q.offer(new Pair(newX,newY,lost+cave[newX][newY]));
		}
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x=p.x;
			y=p.y;
			seen[x][y] = true;
			lost = p.lost;
			if(x==n-1&&y==n-1) {
				break;
			}
			for(int i =0;i<4; i++) {
				int newX = x+moveX[i];
				int newY = y + moveY[i];
				if(newX<0||newX>=n||newY<0||newY>=n || seen[newX][newY]) {
					continue;
				}
				q.offer(new Pair(newX,newY,lost+cave[newX][newY]));
			}
		}
		return lost;
	}
	public static class Pair implements Comparable<Pair>{
		int x;
		int y; 
		int lost;
		public Pair(int x, int y, int lost) {
			super();
			this.x = x;
			this.y = y;
			this.lost = lost;
		}
		@Override
		public int compareTo(Pair o) {
			return this.lost-o.lost;
		}
		
	}
}
