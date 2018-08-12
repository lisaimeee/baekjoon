package problem11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class June10_Atm {
//https://www.acmicpc.net/problem/11399
	public static void main(String[] args) {
		try (
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
		){
			int n = Integer.parseInt(reader.readLine());
			int[] a= new int[n];
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			for(int i =0; i<n;i++) {
				a[i]=Integer.parseInt(tokenizer.nextToken());
			}
			quicksort(a, 0, a.length-1);
			int time = 0;
			for(int i=0; i<n; i++) {
				time+=a[i]*(n-i);
			}
			System.out.println(time);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void quicksort(int[] a, int left, int right) {
		int i = left;
		int j = right;
		int pivot = a[(right+left)/2];
		int temp;
		while(i<=j) {
			while(a[i]<pivot) {
				i++;
			}
			while(a[j]>pivot) {
				j--;
			}
			if(i<=j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		if(i<right) {
			quicksort(a, i, right );
		}
		if(j>left) {
			quicksort(a, left, j);
		}
	}
}
