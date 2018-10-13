package problem1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class HideAndSeek {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		int k = Integer.parseInt(tokens[1]);
		
		// X-1, X+1, 2*x
		int duration = Integer.MAX_VALUE; 
		final int MAX = 100001;
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[MAX];
		q.offer(new Node(n, 0));
		while(!q.isEmpty()) {
			Node current = q.poll();
			visited[current.position] = true;
			if(current.position == k ) {
				duration = current.duration;
				break ;
			}
			int nextDuration = current.duration+1;
			if(current.position+1 < MAX && !visited[current.position+1]) {
				Node go = new Node(current.position+1, nextDuration);
				q.offer(go);				
			}
			
			if(current.position-1 >=0 && !visited[current.position-1]) {
				Node back = new Node(current.position-1,nextDuration);
				q.offer(back);
			}
			if( current.position*2<MAX &&!visited[current.position*2] ) {
				Node teleport = new Node(current.position*2, nextDuration);
				q.offer(teleport);				
			}
		}
		System.out.println(duration);
	}
	static class Node implements Comparable<Node>{
		int position;
		int duration;
		
		public Node(int position, int duration) {
			super();
			this.position = position;
			this.duration = duration;
		}

		@Override
		public int compareTo(Node o) {
			return this.duration-o.duration;
		}
		
	}
}
