package problem9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class June3_Plus123 {
	//https://www.acmicpc.net/problem/9095
	public static void main(String[] args) {
		try(
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
		){
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int t = Integer.parseInt(tokenizer.nextToken());
			int test;
			for(int i =0 ; i< t; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				test = Integer.parseInt(tokenizer.nextToken());
				System.out.println(count(test,0));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int count(int t, int count) {
		int n;
		for(int i=1;i<=3;i++) {
			n = t-i;
			if(n==0) count++;
			else if(n<0) n=t;
			else count = count(n,count);
		}
		return count;
	}
}
