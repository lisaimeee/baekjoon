package problem1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareNN {
// 2018.08.19
//https://www.acmicpc.net/problem/1016
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().split(" ");
		
		long min = Long.parseLong(tokens[0]); // 1 <= min <= 1,000,000,000,000
		long max = Long.parseLong(tokens[1]); // min <= max <= min+1,000,000
		
		int squareNumCount = 0;
		int sqrtMax = (int) Math.sqrt(max);
		boolean[] seen = new boolean[sqrtMax+1];
		boolean[] seenSquareNum = new boolean[(int)(max-min)+2];
		
		for(int i=2; i<=sqrtMax; i++ ) {
			if(seen[i]) continue;
			long squareNum = (long)i*(long)i; // 제곱수의 배수
			
			long initNum = min;
			if(initNum%squareNum>0) {
				initNum = (min/squareNum +1)*squareNum;
			}
			
			for(long j = initNum; j <= max; j+=squareNum ) {
				if(j>=min && !seenSquareNum[(int)(max-j)+1]) {
					seenSquareNum[(int)(max-j)+1] = true;
					squareNumCount++;
				}
			}
		}
		System.out.println(max-min+1-squareNumCount);
	}
}
