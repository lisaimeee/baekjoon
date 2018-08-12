package problem1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class June3_MakeOne_Timeout {
	//https://www.acmicpc.net/problem/1463
	public static void main(String[] args) {
		/**
		 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
			X가 3으로 나누어 떨어지면, 3으로 나눈다.
			X가 2로 나누어 떨어지면, 2로 나눈다.
			1을 뺀다.				
			정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최소값을 출력하시오.
		 * */
		try(
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
		){
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			makeOne(x, 0);
			System.out.println(x==1? 0:min);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static int min=Integer.MAX_VALUE;
	public static void makeOne(int x, int count) {
		if(x<0) {return;}
		if(x==1 && count<min) {
			min= count;
			return;
		}
		count++;
		for(int i = 1; i<=3; i++) {
			switch(i) {
			case 1:
				if(x-1>0) {
					makeOne(x-1, count);
				}
				break;
			case 2:
				if(x%2==0) {
					makeOne(x/2, count);
				}
				break;
			case 3:
				if(x%3==0) {
					makeOne(x/3, count);
				}
			}
		}
	}
}
