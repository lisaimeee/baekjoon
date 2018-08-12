package problem7469;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class July22_KthNum {
//7469
	static int[][] arr;
	static int[] sorted;
	static int[][] order;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());// size of array
		int m = Integer.parseInt(st.nextToken());// q-call times 
		st = new StringTokenizer(br.readLine());
		arr = new int[n][2];
		order = new int[n][2];
		sorted = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i][0]= Integer.parseInt(st.nextToken());// q-call times 
			arr[i][1] = i+1;
			sorted[i] = arr[i][0];
		}
		Arrays.sort(sorted);
		for(int i=0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(arr[i][0]==sorted[j]) {
					order[j][0] = arr[i][0];
					order[j][1]=arr[i][1];
					break;
				}
			}
		}
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()); 
			int j = Integer.parseInt(st.nextToken()); 
			int k = Integer.parseInt(st.nextToken()); 
			System.out.println(Q(i,j,k));
		}
	}
	public static int Q(int i, int j, int k) {
		int result=0, cnt=0;
		for(int idx =0; idx<sorted.length; idx++) {
			if( order[idx][1]>=i &&order[idx][1]<=j) {
				cnt++;
				if(cnt==k) {
					result = order[idx][0];
					break;
				}
			}
		}
		return result;
	}
	
}
