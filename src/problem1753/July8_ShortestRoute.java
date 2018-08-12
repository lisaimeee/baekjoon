package problem1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class July8_ShortestRoute {
	//https://www.acmicpc.net/problem/1753
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int v= Integer.parseInt(tokenizer.nextToken());
		int e= Integer.parseInt(tokenizer.nextToken());
		tokenizer = new StringTokenizer(reader.readLine());
		int s= Integer.parseInt(tokenizer.nextToken());
		
		ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
		for(int i = 0; i<=v; i++) {
			edges.add(new ArrayList<>());
		}
		for(int i =1; i <=e; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int u= Integer.parseInt(tokenizer.nextToken());
			int d= Integer.parseInt(tokenizer.nextToken());
			int w= Integer.parseInt(tokenizer.nextToken());
			edges.get(u).add(new Edge(u, d, w));
		}
		
		int[] weight = new int[v+1];
		final int INF = Integer.MAX_VALUE/2;
		Arrays.fill(weight, INF);
		weight[s] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(s,s,0));
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			for(Edge next:edges.get(current.d)) {
				if(weight[next.d] > weight[next.u]+next.w) {
					weight[next.d] = weight[next.u]+next.w;
					pq.offer(new Edge(next.u, next.d, weight[next.u]+next.w));
				}
			}
		}
		for(int i =1; i<=v; i++) {
			if(weight[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(weight[i]);
			}
		}
	}
	public static class Edge implements Comparable<Edge>{
		int u;
		int d;
		int w;
		
		public Edge(int u, int d, int w) {
			this.u = u;
			this.d = d;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
		
	}
}

