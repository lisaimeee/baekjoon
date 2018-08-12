package problem9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class May27_NQueen_TakeLongTime {
	//9663
	static int count;
	public static void main(String[]args) {
		try(
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(in);
		){
			int n = Integer.parseInt(reader.readLine());
			int[][] board = new int[n][n];
			May27_NQueen_TakeLongTime q= new May27_NQueen_TakeLongTime();
			for(int i = 0; i< n ; i ++) {
				q.dfs(board, 0,i); 
			}
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void dfs(int[][] board, int x, int y) {
		int n = board.length;
		board[x][y] = 9;
		if(x==board.length-1) {
			count++;
			return;
		}
		int[][] copy = new int [n][n];
		copy = copy(board);
		mark(copy, x, y);
		int nextX = x+1;
		for(int nextY =0; nextY< board.length; nextY++) {
			if(copy[nextX][nextY]==0) {
				dfs(copy, nextX, nextY);
			}
		}
	}
	public int[][] copy(int[][] a) {
		int [][] copy = new int [a.length][a.length];
		for(int i =0 ; i< a.length; i++ ) {
			System.arraycopy(a[i], 0, copy[i], 0, a.length);
		}
		return copy;
	}
	public void mark(int[][] board, int x, int y) {
		for(int i=x+1; i< board.length; i++) {
			int slashY = i-x+y;
			int backSlashY = y+x-i;
			for( int j =0; j<board.length; j++ ) {
				if( i == x || j == y || j==slashY || j==backSlashY) { // 가로, 세로, 대각선/\ 퀸을 둘 수 없음
					board[i][j] = 1;
				}
			}
		}
	}
}
