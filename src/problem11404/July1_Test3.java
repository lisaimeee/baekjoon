package problem11404;

import java.util.Arrays;
import java.util.Scanner;

public class July1_Test3 {
//https://www.acmicpc.net/problem/11404
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int v = scan.nextInt();
		int e = scan.nextInt();
		int[][] weight = new int[v][v];
		final int INF = e*100000;
		for(int [] w: weight ) {
			Arrays.fill(w, INF);
		}
		for(int i = 0; i<e; i++ ) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			if(weight[a-1][b-1]>c) {
				weight[a-1][b-1] = c;
			}
		}
		scan.close();
		for(int k = 0; k <v; k++) {
			for(int i =0; i <v; i++ ) {
				for(int j =0; j<v; j++) {
					if(weight[i][j]>weight[i][k]+weight[k][j]) {
						weight[i][j]=weight[i][k]+weight[k][j];
					}
				}
			}
		}
		for(int i = 0; i<v; i++) {
		 for( int j = 0; j< v ; j++ ) {
             if( i==j || weight[i][j] == INF ){
                  System.out.print(0+" ");
             }else{
                 System.out.print(weight[i][j]+" ");
             }
		 }
		 System.out.println();
		}
	}
}

