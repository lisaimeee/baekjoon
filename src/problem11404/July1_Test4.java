package problem11404;
import java.util.Arrays;
import java.util.Scanner;

public class July1_Test4 {
//https://www.acmicpc.net/problem/11404
   public static void main(String[] args) throws Exception {
	   Scanner scan = new Scanner(System.in);
	   int v = scan.nextInt();
	   int m = scan.nextInt();

      int[][] d = new int[v][v];
      final int INF = Integer.MAX_VALUE/2;
      for(int[] row:d) {
    	  Arrays.fill(row, INF);
      }
      for (int i = 0; i < m; i++) {
         int a = scan.nextInt();
         int b = scan.nextInt();
         int c = scan.nextInt();
         if(d[a-1][b-1] >c)
         d[a-1][b-1] = c;
      }
      scan.close();
      for (int k = 0; k < v; ++k) {
         for (int i = 0; i < v; ++i) {
            for (int j = 0; j < v; ++j) {
               if (d[i][j] > d[i][k] + d[k][j]) {
                  d[i][j] = d[i][k] + d[k][j];
               }

            }
         }
      }
      
      for(int i=0; i<v; i++) {
         for(int j=0; j<v; j++){
            if(d[i][j]==INF|| i==j){
               System.out.print(0+" ");
            }
            else {
            System.out.print(d[i][j]+" ");
            }
         }
         System.out.println();
      }
      

   }

}