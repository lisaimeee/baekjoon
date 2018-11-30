package problem6086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class MaxFlow {
//https://www.acmicpc.net/problem/6086
	static Map<String, List<Pipe>> edges;
	static Map<String, Boolean> seen;
	static int maxCapacity = 1000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		edges = new HashMap<>();
		seen =  new HashMap<>();
		
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String source = st.nextToken();
			String dest = st.nextToken();
			int capacity = Integer.parseInt(st.nextToken());
			
			if(!edges.containsKey(source)) {
				edges.put(source, new ArrayList<>());
			}
			Pipe edge = new Pipe(source, dest, capacity);
			edges.get(source).add(edge);			
		}
		
		//1. find route and maxCapacity 
		List<String> routes = null;
		int maxFlow = 0;
		while((routes = findRoute())!= null) {
			maxFlow += maxCapacity;
			updateCapacity(routes);
		}
		System.out.println(maxFlow);
		
	}
	
	static void updateCapacity(List<String> routes) {
		for(String route : routes ) {
			for(Pipe child : edges.get(route)) {
				child.capacity -= maxCapacity;
			}
		}

	}
	
	static List<String> findRoute() {
		
		Queue<Pipe> q = new LinkedList<>();
		for(Pipe edge: edges.get("A")) {
			if(seen.get(edge.dest) == null || edge.capacity > 0) {
				q.add(edge);
				break;
			}
		}
			
		List<String> routes = new ArrayList<>();
		boolean isResidualNetworkRemained = false;
		maxCapacity = 1000;
		
 		while(!q.isEmpty()) {
 			Pipe current = q.poll();
 			seen.put(current.dest, true);
 			
 			
 			if(current.capacity < maxCapacity) {
 				maxCapacity = current.capacity;
 			}
 			
 			if(current.dest.equals("Z")) {
 				isResidualNetworkRemained = true;
 				break;
 			}
 			
 			routes.add(current.source);
 			
 			for(Pipe pipe : edges.get(current.dest)) {
 				if(seen.get(pipe.dest) == null || pipe.capacity > 0) {
 					q.add(pipe);
 					break;
 				}
 			}
 			
		}
 		
 		return isResidualNetworkRemained ? routes : null;
	}
	
	static class Pipe {
		String source;
		String dest;
		int capacity;
		public Pipe(String source, String dest, int capacity) {
			super();
			this.source = source;
			this.dest = dest;
			this.capacity = capacity;
		}
	}
} 
