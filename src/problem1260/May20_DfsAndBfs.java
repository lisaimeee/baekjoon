package problem1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class May20_DfsAndBfs {
//1260
	public static void main(String[] args ) {
		try(
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(in);
				){
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int numberOfNode = Integer.parseInt(tokenizer.nextToken());
			int numberOfLinks = Integer.parseInt(tokenizer.nextToken());
			int vertex = Integer.parseInt(tokenizer.nextToken());
			int[][] nodes = new int[numberOfNode+1][numberOfNode+1];
			for(int i = 1 ; i <= numberOfLinks; i++ ) {
				tokenizer = new StringTokenizer(reader.readLine());
				int one = Integer.parseInt(tokenizer.nextToken());
				int another = Integer.parseInt(tokenizer.nextToken());
				nodes[one][another] = 1;
				nodes[another][one] = 1;
			}
			boolean[] seen = new boolean[numberOfNode+1];
			dfs(nodes, seen,vertex);
			System.out.println();
			seen = new boolean[numberOfNode+1];
			bfs(nodes, seen, vertex);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// main
	
	public static void dfs(int[][] a, boolean[] seen, int v ) {
		int n = a.length;
		seen[v] = true;
		System.out.print(v+" ");
		for(int i = 1; i < n; i++) {
			if(a[v][i] == 1 && !seen[i]) {
				dfs(a, seen, i);
			}
		}
	}
	public static void bfs(int[][]a, boolean[] seen , int v) {
		Queue<Integer> q = new LinkedList<>();
		int n = a.length;
		q.offer(v);
		seen[v] = true;
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v+" ");
			for(int i = 1; i < n; i++ ) {
				if( a[v][i] == 1 && !seen[i]) {
					q.offer(i);
					seen[i] = true;
				}
			}
		}
	}
}
