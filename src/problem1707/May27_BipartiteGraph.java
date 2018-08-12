package problem1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1707
public class May27_BipartiteGraph {
	
	public static void main(String[] args) {
		try(
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(in);
		){
			int numOfTest = Integer.parseInt(reader.readLine());
			for(int i = 0 ; i<numOfTest; i++) {
				System.out.println(checkBipartiteGraph(reader));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static boolean isBipartiteGraph = true;
	final static int RED=1;
	final static int BLUE=2;
	
	public static String checkBipartiteGraph(BufferedReader reader) throws IOException {
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int v = Integer.parseInt(tokenizer.nextToken());
		int e = Integer.parseInt(tokenizer.nextToken());
		ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[v+1];
		for( int i =1 ; i<=v; i++) {
			graph[i]= new ArrayList<>();
		}
		for( int j =0; j<e; j++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(tokenizer.nextToken());
			int v2= Integer.parseInt(tokenizer.nextToken());
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		int[] colors = new int[v+1];
	    isBipartiteGraph = true;
	    for( int i = 1; i<colors.length; i++ ) {
	    	if(colors[i]==0) check(graph, i, colors, RED);
	    	if(!isBipartiteGraph) break;
	    }
		return isBipartiteGraph? "YES":"NO";
	}
	
	public static void check(ArrayList<Integer>[] graph, int v,  int[] colors, int color ) {
		if(!isBipartiteGraph) {return;}
		colors[v] = color;
		for(int next: graph[v]) {
			if( colors[next] ==0 ) {
				check(graph, next, colors, color==RED?BLUE:RED);
			}else if(colors[next] == color){
				isBipartiteGraph = false;
				break;
			}
		}
	}
	
}
