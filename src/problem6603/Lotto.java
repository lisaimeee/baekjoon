package problem6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lotto {
	//https://www.acmicpc.net/problem/6603
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		while(k>0) {
			// 1~49
			int [] s = new int[50];
			for(int i =1; i<= k; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				s[i] = tmp;
			}
			for(int a =1; a<=k-5; a++) { // 1
				for(int b =a+1; b<=k-4; b++) { // 2
					for(int c =b+1; c<=k-3; c++) { // 3
						for(int d =c+1; d<=k-2; d++) { // 4
							for(int e =d+1; e<=k-1; e++) { // 5
								for(int f =e+1; f<=k; f++) { // 6
									System.out.println(s[a]+" " +s[b]+" "+s[c]+" "+s[d]+" "+s[e]+" "+s[f]);
								}
							}
						}
					}
				}
			}
			System.out.println();
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
		}
	}
	
}
