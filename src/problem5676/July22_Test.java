package problem5676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class July22_Test {
//https://www.acmicpc.net/problem/5676
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line=br.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(line);
			// 양수 음수 0
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] zeroFenwick = new int[n+1];
			int[] negativeFenwick = new int[n+1];
			int[] arr = new int [n+1];
			for(int i = 1; i<=n ; i++) {
				int v = Integer.parseInt(st.nextToken());
				arr[i] = 1;
				if(v==0) {
					arr[i] = 0;
					update(zeroFenwick, i, 1);
				}else if(v<0) {
					arr[i] = -1;
					update(negativeFenwick, i, 1);
				}
			}
			while(k-->0) {
				st = new StringTokenizer(br.readLine());
				String input = st.nextToken();
				if("C".equals(input)) {
					//update
					int i = Integer.parseInt(st.nextToken());
					int v = Integer.parseInt(st.nextToken());
					if(v==0) {
						if(arr[i]!=0) {
							update(zeroFenwick, i, 1);
						}
						if(arr[i]==-1) {
							update(negativeFenwick, i, -1);
						}
						arr[i]=0;
					}else if( v <0 ) {
						if(arr[i]>=0) {
							update(negativeFenwick, i, 1);
						}
						if(arr[i]==0) {
							update(zeroFenwick, i, -1);
						}
						arr[i]=-1;
					}else {
						if(arr[i]==0) {
							update(zeroFenwick, i, -1);
						} else if(arr[i]==-1){
							update(negativeFenwick, i, -1);
						}
						arr[i] = 1;
					}
				}else {
					//print
					int i = Integer.parseInt(st.nextToken());
					int j = Integer.parseInt(st.nextToken());
					int numOfZero = query(zeroFenwick, j)-query(zeroFenwick, i-1);
					if(numOfZero>0) {
						System.out.print(0);
					}else {
						int numOfNegative = query(negativeFenwick, j)-query(negativeFenwick, i-1);
						if(numOfNegative%2==0) {
							System.out.print("+");
						}else {
							System.out.print("-");
						}
					}
				}//else
			}//while
			System.out.println();
		}
	}
	public static void update(int[] fenwick, int i, int v) {
		while(i<fenwick.length) {
			fenwick[i]+=v;
			i +=(i&-i);
		}
	}
	public static int query(int[] fenwick, int i) {
		int ans = 0;
		while(i>0) {
			ans+=fenwick[i];
			i-=(i&-i);
		}
		return ans;
	}
}
