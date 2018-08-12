package problem2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class July15_Test {
//https://www.acmicpc.net/problem/2042
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//숫자 개수 
		int m = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());//숫자 개수 
		// 수 입력 받기 
		int[] arr= new int[n+1];
		long[] fenwick= new long[n+1];
		for(int i =1 ; i<=n; i++) {

			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			update(fenwick, i, arr[i]);
		}
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==1) {
				int target = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				long diff = value - arr[target];
				arr[target] = value;
				update(fenwick, target, diff);
			} else {
				int qs = Integer.parseInt(st.nextToken());
				int qe = Integer.parseInt(st.nextToken());
				System.out.println(query(fenwick, qe)-query(fenwick, qs-1));
			}
		}
	}
	public static long query(long[] fenwick, int i) {
		long ans = 0; 
		while(i>0) {
			ans += fenwick[i];
			i-=(i&-i);
		}
		return ans;
	}
	public static void update(long[] fenwick, int i, long diff) {
		while(i <  fenwick.length) {
			fenwick[i] += diff;
			i += ( i & -i );
		}
	}
}			



