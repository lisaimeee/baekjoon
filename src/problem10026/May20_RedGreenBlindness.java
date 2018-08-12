package problem10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class May20_RedGreenBlindness {

	public static void main(String[] args) {
		try(
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(in);
		){
			int N = Integer.parseInt(reader.readLine());
			String[] colors = new String[N*N+1];
			for( int i = 0; i <N; i++) {
				String line = reader.readLine();
				for(int j = 1 ; j <=N; j++ ) {
					colors[i*N+j] = line.substring(j-1, j);
				}
			}
			
			boolean[] seen = new boolean[N*N+1];
			int v = 1;
			ArrayList<Integer>[] a = getMapForNormal(N, colors);
			int normal = getCount(a, seen, v);
			seen= new boolean[N*N+1];
			v=1;
			a = getMapForRedGreenBlind(N, colors);
			int redGreenBlind = getCount(a,seen,v);
			System.out.println( normal +" "+ redGreenBlind);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Integer>[] getMapForRedGreenBlind(int N, String[] colors){
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] a = (ArrayList<Integer>[])new ArrayList[N*N+1];
		for (int i = 1; i <= N*N; i++) { 
			a[i] = new ArrayList<>(); 
		}
		for (int i = 1; i <=N*N; i++) { 
			int v1=i;
			int v2=i+1;
			int v3=i+N;
			
			final int RED_OR_GREEN = 1;
			final int BLUE = 2;
			int color = 0;
			if( "R".equals(colors[v1]) || "G".equals(colors[v1]) ) {
				color = RED_OR_GREEN;
			}else {
				color = BLUE;
			}
			switch(color) {
			case RED_OR_GREEN:
				if(v2<=N*N && v1%N!=0 && ("R".equals(colors[v2])|| "G".equals(colors[v2]))) {
					a[v1].add(v2);
					a[v2].add(v1);
				}
				if(v3<=N*N && ("R".equals(colors[v3]) || "G".equals(colors[v3]))) {
					a[v1].add(v3);
					a[v3].add(v1);
				}
				break;
			case BLUE:
				if(v2<=N*N && v1%N!=0 && "B".equals(colors[v2])) {
					a[v1].add(v2);
					a[v2].add(v1);
				}
				if(v3<=N*N && "B".equals(colors[v3])) {
					a[v1].add(v3);
					a[v3].add(v1);
				}
				break;
			}//switch
		}//for
		return a;
	}
	public static ArrayList<Integer>[] getMapForNormal(int N, String[] colors){
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] a = (ArrayList<Integer>[])new ArrayList[N*N+1];
		for (int i = 1; i <= N*N; i++) { 
			a[i] = new ArrayList<>(); 
		}
		for (int i = 1; i <=N*N; i++) { 
			int v1=i;
			int v2=i+1;
			int v3=i+N;
			switch(colors[v1]) {
			case "R":
				if(v2<=N*N && v1%N!=0 && "R".equals(colors[v2])) {
					a[v1].add(v2);
					a[v2].add(v1);
				}
				if(v3<=N*N && "R".equals(colors[v3])) {
					a[v1].add(v3);
					a[v3].add(v1);
				}
				break;
			case "G":
				if(v2<=N*N && v1%N!=0 && "G".equals(colors[v2])) {
					a[v1].add(v2);
					a[v2].add(v1);
				}
				if(v3<=N*N && "G".equals(colors[v3])) {
					a[v1].add(v3);
					a[v3].add(v1);
				}
				break;
			case "B":
				if(v2<=N*N && v1%N!=0 && "B".equals(colors[v2])) {
					a[v1].add(v2);
					a[v2].add(v1);
				}
				if(v3<=N*N && "B".equals(colors[v3])) {
					a[v1].add(v3);
					a[v3].add(v1);
				}
				break;
			}
		}//for
		return a;
	}
	public static int getCount(ArrayList<Integer>[] a, boolean[] seen, int v) {
		Queue<Integer> q = new LinkedList<>();
		int N = seen.length;
		boolean noUnSeen = false;
		int count =0 ;
		while(!noUnSeen) {
			noUnSeen = true;
			for( int i=1; i<N; i++) {
				if(!seen[i]) {
					noUnSeen = false;
					v=i;
				}
			}
			if(noUnSeen) {
				break;
			}else {
				count++;
			}
			q.offer(v);
			seen[v] = true;
			while(!q.isEmpty()) {
				v = q.poll();
				for(int i : a[v]) {
					if(!seen[i]) {
						q.offer(i);
						seen[i] = true;
					}
				}
			}
		}
		return count;
	}
}
