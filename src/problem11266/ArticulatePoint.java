package problem11266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArticulatePoint {
//https://www.acmicpc.net/problem/11266
	static boolean[] isCut;
	static boolean[] seen;
	static int[] discovered;
	static int visitNumber;
	static ArrayList<Integer>[] nodes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		nodes = new ArrayList[v+1];
		for(int i = 1; i <=  v; i++ ) {
			nodes[i] = new ArrayList<Integer>();
		}
		discovered = new int[v+1];
		isCut = new boolean[v+1];
		seen = new boolean[v+1];
			
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a].add(b);
			nodes[b].add(a);
		}
		
		for (int i = 1; i < v; i++) {
			if( !seen[i] ) {
				dfs(i, true);
			}
		}
		
		int count = 0; 
		for (int i = 1; i <= v; i++) {
			if (isCut[i]) {
				count++;
			}
		}
		System.out.println(count);
		
		for (int i = 1; i <= v; i++) {
			if (isCut[i]) {
				System.out.print(i+" ");
			}
		}
	}
	
	static int dfs(int current, boolean isRoot) {
		seen[current] = true;
		discovered[current] = ++visitNumber;
		int min = discovered[current];
		
		int child = 0;
		for ( int next : nodes[current]) {
			if (discovered[next] > 0) {
				min = Math.min(min, discovered[next]);
				continue;
			}
		
			child++;
			int prev = dfs(next, false);
			
			if (!isRoot && prev >= discovered[current]) {
				isCut[current] = true;
			}
			
			min = Math.min(min, prev);
		}
		if (isRoot) {
			isCut[current] = child >= 2;
		}
		
		return min;
	}
}
