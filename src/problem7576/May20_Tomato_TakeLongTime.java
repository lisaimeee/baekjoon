package problem7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class May20_Tomato_TakeLongTime{
	final static int[] X = {-1,1,0,0};//up, down, left, right
	final static int[] Y = {0, 0, -1, 1};//up, down, left, right
	static int[][] routeNum;
	public static void main(String[] args) {
		try(
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
		){
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int N = Integer.parseInt(tokenizer.nextToken());
			int M = Integer.parseInt(tokenizer.nextToken());
			int[][] tomatos = new int[M+1][N+1];
			ArrayList<Pair> startPoint =  new ArrayList<>();
			boolean isAllRipen = true;
			for(int i=1; i<= M; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				for(int j =1; j<=N; j++) {
					int status =Integer.parseInt(tokenizer.nextToken());
					if(status==1) {
						startPoint.add(new Pair(i,j));
					}else{
						isAllRipen = false;
					}
					tomatos[i][j] = status;
				}
			}
			if(isAllRipen) {
				System.out.println(1);
				return;
			}
			boolean[][] visited = new boolean[M+1][N+1];
			routeNum = new int[M+1][N+1];
			int max=0;
			for (int k =0 ; k<startPoint.size(); k++) {
				Pair p = startPoint.get(k);
				int x = p.x;
				int y = p.y;
				visited = new boolean[M+1][N+1];
				bfs(tomatos,x, y, visited);
				if(k>0) { continue; }
				for(int i = 1; i<=M; i++) {
					for(int j =1; j<=N; j++){
						if(!visited[i][j]&&tomatos[i][j]==0) {
							System.out.println(-1);
							System.exit(0);
						}
					}
				}
			}
			for(int[] arr:routeNum) {
				for(int num:arr) {
					if(max<num) max = num;
				}
			}
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void bfs(int[][] a, int x, int y, boolean[][] visited) {
	    Queue<Pair> queue = new LinkedList<>();
	    queue.offer(new Pair(x, y));//좌표 추가 
	    visited[x][y] = true;//방문표시 
	    routeNum[x][y]=0;
	    boolean outOfArea = false;
	    while (!queue.isEmpty()) {
	       Pair p = queue.poll();
	       x=p.getX();
	       y=p.getY();
	       for (int i = 0; i < 4; i++) {//4방향 체크 
	    	 int nextX = x + X[i];
	         int nextY = y + Y[i]; //현재좌표에서 4방향 찔러봄
	         //범위를 벗어나거나 이미 체크한 경우 continue
	         if( nextX<=0||nextY<=0||nextX>=a.length||nextY>=a[0].length||visited[nextX][nextY]){continue;} 
	         outOfArea = routeNum[nextX][nextY]!=0 && routeNum[nextX][nextY]<=routeNum[x][y]+1;
	         switch(a[nextX][nextY]) {
	         case 0://안 익은 토마토
	         case 1://익은 토마토 
                 visited[nextX][nextY] = true; //방문 체크 
                 if(!outOfArea) {
                	 queue.offer(new Pair(nextX,nextY)); 
                	 routeNum[nextX][nextY] = routeNum[x][y]+1;
                 }
               	 break;
	         case -1:// 빈 토마토 
	        	 visited[nextX][nextY] = true;
	         }
	       }//for
	    }//while
	 }//bsf
	
	 static class Pair {
	      private int x, y;
	      public Pair() {}
	      public Pair(int x, int y) {
	    	 this.x = x;
	         this.y = y;
	      }
	      public int getY() {return y;}
	      public int getX() {return x;}
	   }
}
