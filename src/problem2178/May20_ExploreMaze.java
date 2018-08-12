package problem2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class May20_ExploreMaze {
	//2178
	public static void main(String[] args) {
		try(
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(in);
		){
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int N = Integer.parseInt(tokenizer.nextToken());
			int M = Integer.parseInt(tokenizer.nextToken());
			int[]maze = new int [N*M+1];
			for(int i = 0 ; i <N; i++ ) {
				String line = reader.readLine();
				for(int j=1; j <=M; j++) {
					maze[i*M+j]=line.charAt(j-1)-48;
				}
			}
			
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[N*M+1]; 
			for (int i = 1; i <= N*M; i++) { 
				a[i] = new ArrayList<>(); 
			} 
			for (int i = 1; i <=N*M; i++) { 
				int v1=i;
				int v2=i+1;
				int v3=i+M;
				if(maze[v1] == 0 ) {
					continue;
				}
				if(v2<=N*M && v1%M!=0 && maze[v2]==1 ) {
					a[v1].add(v2);
					a[v2].add(v1);
				}
				if(v3<=N*M && maze[v3]==1) {
					a[v1].add(v3);
					a[v3].add(v1);
				}
			}
			Queue<Integer> q = new LinkedList<>();
			boolean[] seen = new boolean[M*N+1];
			int [] routeNum = new int [M*N+1];
			int v =1;
			q.offer(1);
			seen[v] = true;
			routeNum[v] = 1;
			while(!q.isEmpty()) {
				v=q.poll();
				for(int route:a[v]) {
					if(!seen[route]) {
						q.offer(route);
						seen[route] = true;
						if(routeNum[route]==0 || routeNum[route]> routeNum[v]+1) {
							routeNum[route] = routeNum[v]+1;
						}
					}
				}
			}
			System.out.println(routeNum[M*N]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main
}
