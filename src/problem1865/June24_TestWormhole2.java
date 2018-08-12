package problem1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class June24_TestWormhole2 {
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
				int[][] nodes = new int [N+1][N+1];
				for(int i = 0 ; i<=N; i ++) {
					Arrays.fill(nodes[i], Integer.MAX_VALUE);
				}
				for(int i =1; i<= M; i++ ) {
					tokenizer = new StringTokenizer(reader.readLine());
					int S = Integer.parseInt(tokenizer.nextToken());
					int E = Integer.parseInt(tokenizer.nextToken());
					int T = Integer.parseInt(tokenizer.nextToken());
					nodes[S][E] = T;
					nodes[E][S] = T;
				}
				Node[] wormholes = new Node[N+1];
				for(int i = 1; i<=W ; i++) {
					tokenizer = new StringTokenizer(reader.readLine());
					int S = Integer.parseInt(tokenizer.nextToken());
					int E = Integer.parseInt(tokenizer.nextToken());
					int T = Integer.parseInt(tokenizer.nextToken());
					wormholes[S]= new Node(E, T);
				}
				int[] go = null;
				int[] timeTakenToWormhole= new int [N+1];
				PriorityQueue<Node> q = new PriorityQueue<>();
				boolean[] seen = new boolean[N+1];
				for( int j = 0 ; j <= N ; j++ ) {
					if(wormholes[j]==null) continue;
					seen[j] = true;
					for(int i = 1; i <=N; i++) {
						if(nodes[j][i]!=Integer.MAX_VALUE)
						q.offer(new Node(i, nodes[j][i] )); 
					}
					go = new int [N+1];
					Arrays.fill(go, Integer.MAX_VALUE);
					while(!q.isEmpty()) {
						Node n = q.poll();
						go[n.vertex] = n.time;
						if(n.vertex ==1 ) {
							break;
						}
						seen[n.vertex] = true;
						for(int i = 1; i<=N; i++) {
							if(!seen[i]&&nodes[n.vertex][i]!=Integer.MAX_VALUE) {
								q.offer(new Node(i, go[n.vertex]+nodes[n.vertex][i]));
							}
						}
					}
					timeTakenToWormhole[j] = go[1];
				}
				/// back to 1
				seen = new boolean[N+1];
				for(int j = 1; j<=N; j++) {
					Node wormhole = wormholes[j];
					if( wormhole == null ) continue;
					q = new PriorityQueue<>();
					seen[wormhole.vertex] = true;
					q.offer(new Node(wormhole.vertex, timeTakenToWormhole[j]-wormhole.time));
					while(!q.isEmpty()) {
						Node n = q.poll();
						seen[n.vertex] = true;
						if(n.vertex ==1) {
							System.out.println(n.time<0? "YES":"NO");
							break;
						}
						for(int i=1; i<= N; i++) {
							if(!seen[i]) {
								q.offer(new Node(i, n.time+nodes[n.vertex][i]));
							}
						}
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static class Node implements Comparable<Node> {
		int vertex;
		int time; 
		
		public Node(int vertex, int time) {
			this.vertex = vertex;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time-o.time;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", time=" + time + "]";
		}
		
	}
}

