package problem2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class ClimbUpSteps {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 계단 오르는 데는 다음과 같은 규칙이 있다.
			계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
			연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
			마지막 도착 계단은 반드시 밟아야 한다.
		 * */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] points = new int[n+1];
		for(int i = 1; i <= n; i++ ) {
			points[i] = Integer.parseInt(br.readLine());
		}
		// next +1
		// jump +2
		// countNext 
		Queue<Step> q = new PriorityQueue<>();
		q.add(new Step(0,0,0));
		while(!q.isEmpty()) {
			Step current = q.poll();
			if( current.n == n ) {
				System.out.println(current.p);
				break;
			}
			if( current.c < 2 && current.n+1 <= n && current.n != n-2 ) {
				Step next = new Step(current.n + 1, current.p+points[current.n+1], current.c+1);
				q.add(next);
			}
			if( current.n+2 <= n ) {
				Step next = new Step(current.n + 2, current.p+points[current.n+2], 1);
				q.add(next);
			}
		}
	}
	static class Step{
		int n; // 계단 번호 
		int p; // 점수 
		int c; // 연속으로 오른 계단 횟수 3번 이상일 수 없음 
		public Step(int n, int p, int c) {
			super();
			this.n = n;
			this.p = p;
			this.c = c;
		}
	}
}
