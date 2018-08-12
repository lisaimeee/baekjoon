package problem1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class June24_TestWormhole_Timeout {
	public static void main(String[] args) {
		try(
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
		){
			int Test = Integer.parseInt(reader.readLine());
			while(Test>0){
				Test--;
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				int N = Integer.parseInt(tokenizer.nextToken());
				int M = Integer.parseInt(tokenizer.nextToken());
				int W = Integer.parseInt(tokenizer.nextToken());
				Edge[] edges = new Edge[M+1];
				for(int i =1; i<= M; i++ ) {
					tokenizer = new StringTokenizer(reader.readLine());
					int S = Integer.parseInt(tokenizer.nextToken());
					int E = Integer.parseInt(tokenizer.nextToken());
					int T = Integer.parseInt(tokenizer.nextToken());
					edges[i]=new Edge(S,E, T);
				}
				for(int i = 1; i<=W ; i++) {
					tokenizer = new StringTokenizer(reader.readLine());
					int S = Integer.parseInt(tokenizer.nextToken());
					int E = Integer.parseInt(tokenizer.nextToken());
					int T = Integer.parseInt(tokenizer.nextToken());
					edges[i]=new Edge(S,E, -T);
				}
				int[] time = new int[N+1];
				int INF= 1000000000;
				Arrays.fill(time, INF);
				time[1]=0;
				for( int i = 0; i< N-1; i ++ ) {
					for( int j = 1; j<= M ;j++) {
						System.out.println(Arrays.toString(time)+", "+edges[j]);
						if(time[edges[j].dest] > time[edges[j].source]+ edges[j].time ) {
							time[edges[j].dest] = time[edges[j].source]+ edges[j].time;
						}
					}
				}
				boolean negativeWeightCycle = false; 
				for( int j = 1; j<= M ;j++) {
					if(time[edges[j].dest] > time[edges[j].source]+ edges[j].time ) {
						negativeWeightCycle = true;
					}
				}
				System.out.println(time[1]+", "+ negativeWeightCycle);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static class Edge {
		int source;
		int dest;
		int time; 
		
		public Edge(int source, int dest, int time) {
			this.source = source;
			this.dest = dest;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Edge [source=" + source + ", dest=" + dest + ", time=" + time + "]";
		}

	}
}
