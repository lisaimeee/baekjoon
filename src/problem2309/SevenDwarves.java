package problem2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SevenDwarves {
	//https://www.acmicpc.net/problem/2309
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] heights = new int[9];
		final int sum = 100;
		int total = 0; 
		for(int i =0 ; i< 9; i++) {
			heights[i] = Integer.parseInt(br.readLine());
			total+=heights[i];
		}
		quicksort(heights, 0, heights.length-1);
		//7, 8, 10, 13, 19, 20, 23
		//조건 9중 7이고, 합이 100이다
		int temp=total;
		int a = 0;
		int b = 0; 
		for(int i = 0; i< 9; i++) {
			for(int j =i+1; j<9; j++) {
				temp = temp - heights[i]- heights[j];
				if(temp == sum ) {
					a = i;
					b = j;					
					break;
				}
				temp = total;
			}
		}
		for(int i=0; i<9; i++) {
			if(i == a || i ==b) continue;
			System.out.println(heights[i]);
		}
	}
	public static void quicksort(int[] arr, int l, int r) {
		int i = l;
		int j = r;
		int pivot = arr[(l+r)/2];
		int temp = 0; 
		while(i<=j) {
			while(arr[i]<pivot) i++;
			while(arr[j]>pivot) j--;
			if(i<=j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if(i<r) quicksort(arr, i, r);
		if(l<j) quicksort(arr, l, j);
	}
}
