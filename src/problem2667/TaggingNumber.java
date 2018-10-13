package problem2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class TaggingNumber {
	//https://www.acmicpc.net/problem/2667
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Node.MAX = n;
		int[][] map = new int [n][n];
		for(int i =0; i<n;i++) {
			String line = br.readLine();
			for(int j = 0; j<n; j++) {
				map[i][j] = line.charAt(j)-48;
			}
		}
		int complex = 1;
		Queue<Node> q = new LinkedList<>();
		int seenCount = n*n;
		boolean[][] seen = new boolean[n][n];
		while(seenCount>0) {
			for(int i = 0 ; i< n; i++) {
				for(int j = 0; j<n; j++) {
					if( !seen[i][j] ) {
						q.offer(new Node(i, j));
						break;
					}
				}
				if(!q.isEmpty()) break;
			}
			complex++;
			while(!q.isEmpty()){
				Node current = q.poll();
				seen[current.x][current.y] = true;
				seenCount--;
				if(map[current.x][current.y]==1) {
					map[current.x][current.y] = complex;
				}else if(map[current.x][current.y]==0){
					continue;
				}
				// left
				if(Node.valid(current.x-1, current.y) && !seen[current.x-1][current.y]) {
					q.offer(new Node(current.x-1,current.y));
				}
				// right
				if(Node.valid(current.x+1, current.y) && !seen[current.x+1][current.y]) {
					q.offer(new Node(current.x+1,current.y));
				}
				// up
				if(Node.valid(current.x, current.y-1) && !seen[current.x][current.y-1]) {
					q.offer(new Node(current.x,current.y-1));
				}
				// down
				if(Node.valid(current.x, current.y+1) && !seen[current.x][current.y+1]) {
					q.offer(new Node(current.x,current.y+1));
				}
				
			}
		}//
		Map<Integer, Integer> complexes = new HashMap<>();
		for(int i = 0; i< n; i++) {
			for(int j = 0; j<n; j++) {
				if(map[i][j]==0) {continue;}
				int count = 1;
				if(complexes.containsKey(map[i][j])) count += complexes.get(map[i][j]);
				complexes.put(map[i][j], count);
			}
		}
		System.out.println(complexes.keySet().size());
		List<Integer> values = complexes.values().stream().collect(Collectors.toList());
		values.sort(Integer::compareTo);
		for(Integer value: values) {
			System.out.println(value);
		}
	}
	static class Node {
		int x;
		int y;
		static int MAX; 
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		static boolean valid(int x, int y) {
			return x>=0 && x <MAX && y>=0 && y<MAX;
		}
	}
}
