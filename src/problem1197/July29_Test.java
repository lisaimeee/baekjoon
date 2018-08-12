package problem1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class July29_Test {
//https://www.acmicpc.net/problem/1197
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken()); // 정점의 개수 
		int e = Integer.parseInt(st.nextToken()); // 간선의 개수 
		
		int[][] arr = new int[v+1][v+1];
		for( int [] row: arr) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		boolean[] seen = new boolean[v+1];
		for(int i =0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());  
			int b = Integer.parseInt(st.nextToken());  
			int c = Integer.parseInt(st.nextToken());  
			arr[a][b] = c;
			arr[b][a] = c;
		}
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(1,0));
		long minC = 0;
		while(!pq.isEmpty()) {
			Vertex current = pq.poll();
			while(!pq.isEmpty()) {pq.poll();}
			minC += current.c;
			seen[current.d] = true;
			for(int i = 1; i <=v; i++) {
				if(!seen[i] ) {
					pq.offer(new Vertex(i, arr[current.d][i]));
				}
			}
			if(pq.isEmpty()) {
				for( int i=1; i <=v; i++) {
					if(!seen[i]) {
						for( int j =1; j <=v; j++) {
							pq.offer(new Vertex(i, arr[j][i]));
						}
					}
					if(!pq.isEmpty()) {
						break;
					}
				}
			}
		}
		System.out.println(minC);
	}
	
	static class Vertex implements Comparable<Vertex>{
		int d;
		long c;
		public Vertex(int d , long c) {
			this.d = d ;
			this.c = c;
		}
		@Override
		public int compareTo(Vertex o) {
			long result = this.c - o.c ; 
			result = result > 0 ? 1: result == 0 ? 0: -1;
			return (int)result ;
		}
			
	}
}
