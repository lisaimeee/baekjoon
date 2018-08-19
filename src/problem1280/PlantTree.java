package problem1280;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlantTree {
//2018.08.12
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
		final int MAX = 200001;
		final int DIVISOR = 1000000007;
		
		int n = Integer.parseInt(br.readLine());
		long[] countFenwick = new long[MAX+1];
		long[] sumFenwick = new long[MAX+1];
		
		int i = Integer.parseInt(br.readLine());
		i++;
		update(countFenwick, i, 1);
		update(sumFenwick, i, i-1);
		long totalCost = 1;
		for(int k=2; k<=n; k++) {
			i = Integer.parseInt(br.readLine());
			i++;
			update(countFenwick, i, 1);
			update(sumFenwick, i, i-1);
			
			// count lower
			long countUpper = query(countFenwick, MAX) - query(countFenwick, i);
			long countLower = query(countFenwick, i-1);
			
			long sumUpper = query(sumFenwick, MAX) - query(sumFenwick, i);
			long sumLower = query(sumFenwick, i-1);
			
			long cost = (sumUpper-countUpper*(i-1) + countLower*(i-1) - sumLower)%DIVISOR;
			totalCost = (totalCost*cost)%DIVISOR;
		}
		System.out.println(totalCost);
		
	}
	
	public static void update(long[] fenwick, int i, int val) {
		while(i<fenwick.length) {
			fenwick[i] +=val;
			i += (i&-i);
		}
	}
	public static long query(long[] fenwick, int i) {
		long ans =0;
		while(i>0) {
			ans+=fenwick[i];
			i -= (i&-i);
		}
		return ans;
	}
}
