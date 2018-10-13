package problem4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FriendNetwork {
	//https://www.acmicpc.net/problem/4195
	static int[] parent;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		while( --testCase >= 0 ) {
			int counter=0;
			int pointer=0;
			int f = Integer.parseInt(br.readLine());
			String[] networks = new String[f];
			Map<String, Integer> map = new HashMap<>();
			while( --f >=0) {
				String network = br.readLine();
				String[] friends = network.split(" ");
				networks[pointer++]=network;
				if(!map.containsKey(friends[0]) ) {
					map.put(friends[0], counter++);
				}else if(!map.containsKey(friends[1])) {
					map.put(friends[1], counter++);
				}
				// union
			}
			
		}
		
	}
	
	public static int find(int i) {
		if(i == parent[i]) { return i;}
		
		return parent[i] = find(parent[i]);
	}
	
	public static void union(int i, int j) { 
		i = find(parent[i]); 
		j = find(parent[j]);
		
		if( i == j ) { return; }
		if( rank[i] > rank[j]) {
			int temp =i;
			i=j;
			j=temp;
		}
		parent[i] = j;
		if (rank[i] == rank[j]) ++rank[j];

	}
}
