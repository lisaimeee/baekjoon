package problem1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class June24_Party {
//https://www.acmicpc.net/problem/1238
	public static void main(String[] args) {
		try(
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
		){
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int N = Integer.parseInt(tokenizer.nextToken()); // number of houses
			int M = Integer.parseInt(tokenizer.nextToken()); // number of routes
			int X = Integer.parseInt(tokenizer.nextToken()); // where party held
			ArrayList<Route>[] routes= new ArrayList[N+1];
			for( int i = 0 ; i <=N; i++) {
				routes[i] = new ArrayList<>();
			}
			for( int i =1 ; i <=M; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int position = Integer.parseInt(tokenizer.nextToken());
				routes[position].add(new Route(position, tokenizer.nextToken(), tokenizer.nextToken()));
			}
			int[][] go = new int[N+1][N+1];
			for(int i = 1; i<=N; i++) {
				if ( i == X ) continue;
				int start = i;
				PriorityQueue<Pair> q= new PriorityQueue<>();
				for(Route route : routes[start]) {
					q.offer(new Pair(route.destination, route.time));
				}
				while(!q.isEmpty()) {
					Pair p = q.poll();
					go[start][p.position] = p.time;
					if(p.position==X ) {
						break;
					}
					for( Route r: routes[p.position]) {
						if(go[i][r.destination]==0&&r.destination!=start) {
							q.offer(new Pair(r.destination, r.time+p.time));
						}
					}
				}
			}
			
			PriorityQueue<Pair> q = new PriorityQueue<>();
			for(Route r : routes[X]) {
				q.offer(new Pair(r.destination, r.time));
			}
			while(!q.isEmpty()) {
				Pair p = q.poll();
				if(go[X][p.position]==0)
				go[X][p.position] = p.time;
				for(Route r: routes[p.position]) {
					if(go[X][r.destination]==0&&r.destination!=X)
					q.offer(new Pair(r.destination, r.time+p.time));
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i =1 ; i<= N; i++) {
				int time = go[i][X]+go[X][i];
				if(time>max) {
					max = time;
				}
			}
			System.out.println(max);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static class Pair implements Comparable<Pair>{
		int position;
		int time;
		public Pair(int position, int time) {
			this.position = position;
			this.time = time;
		}
		@Override
		public int compareTo(Pair o) {
			return this.time-o.time;
		}
		@Override
		public String toString() {
			return "Pair [position=" + position + ", time=" + time + "]";
		}
		
	}
	static class Route{
		int position;
		int destination;
		int time;

		public Route(int start, String destination, String time) {
			this.position = start;
			this.destination = Integer.parseInt(destination);
			this.time = Integer.parseInt(time);
		}
	}
}
