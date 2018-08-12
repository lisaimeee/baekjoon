package problem1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class June3_MakeOne2 {
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
			countArr[1] = 0;
			countArr[2] = 1;
			countArr[3] = 1;
			int x = Integer.parseInt(tokenizer.nextToken());
			System.out.println(x==1? 0: count(x));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static int countArr[] = new int [1000000];
	public static int count(int x) {
		int temp;
		if(countArr[x]!=0) {return countArr[x];}
		if(x%2==0) {
			countArr[x] = count(x/2)+1;
		}
		if(x%3==0) {
			temp = count(x/3)+1;
			if(countArr[x]==0 || temp<countArr[x]) {
				countArr[x]=temp;
			}
		}
		if(x-1>0) {
			temp=count(x-1)+1;
			if(countArr[x]==0 || temp<countArr[x]) {
				countArr[x]= temp;
			}
		}
		return countArr[x];
	}
}
