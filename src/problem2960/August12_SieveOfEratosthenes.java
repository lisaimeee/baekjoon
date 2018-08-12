package problem2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class August12_SieveOfEratosthenes {
//https://www.acmicpc.net/problem/2960
/*
 * 에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.

이 알고리즘은 다음과 같다.

2부터 N까지 모든 정수를 적는다.
아직 지우지 않은 숫자 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
아직 모든 숫자를 지우지 않았다면, 다시 2번 단계로 간다.
N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.
 * */
	//첫째 줄에 N과 K가 주어진다. (1 ≤ K < N, max(2, K) < N ≤ 1000)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		
		boolean[] removed = new boolean[n+1];
		int count = 0;
		int found = 0;
		for(int i =2; i<=n; i++ ) {
			if(removed[i]) { continue; }
			count++;
			if( count == k ) { found = i; break; }
			removed[i] = true;
			for(int j = i*i; j<=n;j+=i) {
				if( removed[j]) { continue; }
				count++;
				if( count == k ) { found = j; break; }
				removed[j] = true;
			}
			if( found != 0 ) { break; }
		}
		System.out.println(found);
	}
}
