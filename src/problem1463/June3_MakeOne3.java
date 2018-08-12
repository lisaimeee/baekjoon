package problem1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class June3_MakeOne3 {
	//https://www.acmicpc.net/problem/1463
	public static void main(String[] args) {
		try(
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
		){
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int countArr[] = new int [x+1];
			countArr[1] = 0;
			for(int i = 2; i<=x; i++) {
				if(i%3==0 && countArr[i]> countArr[i/3]+1) {
					countArr[i] = countArr[i/3]+1;
				}
				if(i%2==0 && countArr[i]> countArr[i/2]+1) {
					countArr[i] = countArr[i/2]+1;
				}
				countArr[i] = countArr[i-1]+1;
			}
			System.out.println(countArr[x]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}