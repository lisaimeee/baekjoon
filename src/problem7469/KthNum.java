package problem7469;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KthNum {
//2018.08.12
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/**

배열 a[1...n]에는 서로 다른 숫자가 n개 저장되어 있다. 
Q(i,j,k)
Q(i,j,k): 배열 a[i...j]를 정렬했을 때, k번째 숫자를 리턴하는 함수
예를 들어, a = (1,5,2,6,3,7,4)인 경우 Q(2,5,3)의 답을 구하는 과정을 살펴보자. a[2...5]는 (5,2,6,3)이고, 이 배열을 정렬하면 (2,3,5,6)이 된다. 정렬한 배열에서 3번째 숫자는 5이다. 따라서 Q(2,5,3)의 리턴값은 5이다.
배열 a가 주어지고, Q함수를 호출한 횟수가 주어졌을 때, 각 함수의 리턴값을 출력하는 프로그램을 작성하시오.
입력
첫째 줄에 배열의 크기 n과 함수 Q를 호출한 횟수 m이 주어진다. (1 ≤ n ≤ 100,000, 1 ≤ m ≤ 5,000)
둘째 줄에는 배열에 포함된 정수가 순서대로 주어진다. 각 정수는 절대값이 109를 넘지 않는 정수이다.
다음 m개 줄에는 Q(i,j,k)를 호출할 때 사용한 인자 i,j,k가 주어진다. (1 ≤ i ≤ j ≤ n, 1 ≤ k ≤ j-i+1)
		 * */
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int [n];
		int[] sorted = new int [n]; 
		st = new StringTokenizer(br.readLine());
		int idx = 0; 
		while(st.hasMoreTokens()) {
			a[idx]=Integer.parseInt(st.nextToken());
			sorted[idx] = a[idx];
		}
		quicksort(a, 0, n-1);
		
		while(m-- >0 ) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()); 
			int j = Integer.parseInt(st.nextToken()); 
			int k = Integer.parseInt(st.nextToken()); 
			
			
		}
		
	}
	
	public static void quicksort(int [] a, int left, int right ) {
		int temp;
		int l = left;
		int r = right;
		int pivot = (l+r)/2;
		while(l<=r) {
			while(a[l]<a[pivot]) { l++; }
			while(a[r]>a[pivot]) { r--; }
			if(l<=r) {
				temp = a[l];
				a[l] = a[r];
				a[r] = temp;
				l++;
				r--;
			}
		}
		if(l<right) { quicksort(a, l, right);}
		if(r>left) { quicksort(a, left, r);}
	}
}
