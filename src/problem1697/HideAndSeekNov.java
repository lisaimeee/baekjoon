package problem1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeekNov {
//https://www.acmicpc.net/problem/1697
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line =br.readLine();
		String[] tokens = line.split(" ");
		int n = Integer.parseInt(tokens[0]);// 수빈이 
		int k = Integer.parseInt(tokens[1]);// 동생
		final int MAX = 100000;
		boolean[] seen = new boolean[MAX+1];
		
		// 수빈이는 걷거나, 순간이동을 할 수 있음 
		// 걷는 다면 X-1, X+1 순간이동을 하면 2*X 위치로 이동  
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(n, 0));
		
		int times = 0;
		while(!q.isEmpty()) {
			Point current = q.poll();
			seen[current.p] = true;
			
			if (current.p == k) {
				times = current.time;
				break;
			}
			
			if(current.p+1>=0 && current.p+1<=MAX && !seen[current.p+1]) 
				q.add(new Point(current.p+1, current.time+1));
			
			if(current.p-1>=0 && current.p-1<=MAX && !seen[current.p-1]) 
				q.add(new Point(current.p-1, current.time+1));
			
			if(current.p*2>=0 && current.p*2<=MAX && !seen[current.p*2]) 
				q.add(new Point(current.p*2, current.time+1));
		}
		
		System.out.println(times);
	}
	static class Point {
		int p;
		int time;
		public Point(int p, int time) {
			super();
			this.p = p;
			this.time = time;
		}
	}
}

