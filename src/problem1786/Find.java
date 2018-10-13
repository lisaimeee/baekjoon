package problem1786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Find {
//https://www.acmicpc.net/problem/1786
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		String p = br.readLine();
		int[] pi = getPi(p);
		int n = t.length();
		int m = p.length();
		int j = 0;
		int[] found = new int[n];
		int pointer = 0; 
		for(int i =0; i<n ; i++) {
			while(j>0&&t.charAt(i)!=p.charAt(j)){ // toCharArray() 가 더 빠르다. 
				j = pi[j-1];
			}
			if(t.charAt(i)==p.charAt(j)) {
				if(j == m-1 ) {
					found[pointer++]=i-m+1;
					j=pi[j];
				}else {
					j++;
				}
			}
		}
		System.out.println(pointer);
		for(int index:found) {
			if(index==0) break;
			System.out.print(++index);
		}
		
	}
	
	public static int[] getPi(String p) {
		int length = p.length();
		int j =0;
		int[] pi = new int[length];
		for(int i = 1; i<length; i++) {
			while(j>0 && p.charAt(i)!=p.charAt(j)) {
				j = pi[j-1];
			}
			if(p.charAt(i) == p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}
