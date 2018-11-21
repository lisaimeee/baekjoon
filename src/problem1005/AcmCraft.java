package problem1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class AcmCraft {
//https://www.acmicpc.net/problem/1005
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			// line2: N K
			// line3: D
			// line3~K+2: order X Y 
			// line last: W 
			int n, k, w;
			int[] d;
			ArrayList<Integer>[] orders;
			int[] indegrees;
			
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			d = new int[n+1];			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= n; i++ ) {
				d[i] = Integer.parseInt(st.nextToken());
			}
			
			orders = new ArrayList[k+1];
			indegrees = new int[n+1];
			for(int i = 1; i <= k; i++) {
				orders[i] = new ArrayList<Integer>();
			}
			
			for(int i =1; i <= k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				orders[x].add(y);
				indegrees[y]++;
			}
											
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<>();
			int[] waitTable = new int[n+1];
			for(int i = 1; i<=n; i++) {
				if(indegrees[i] == 0) {
					q.add(i);
					indegrees[i]--;
					waitTable[i] = d[i];
				}
			}
			
			while(!q.isEmpty()) {
				int current = q.poll();
				if(current == w ) {
					System.out.println(waitTable[w]);
					break;
				}
				
				for(int next : orders[current]) {
					indegrees[next]--;
					waitTable[next] = Math.max(waitTable[current] + d[next], waitTable[next]);
				}
				
				for(int i = 1; i<=n ; i++ ) {
					if(indegrees[i]==0 ) {
						indegrees[i]--;
						q.add(i);
					}
				}
				
			}
			
		}
	}
}
