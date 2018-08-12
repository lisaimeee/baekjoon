package problem2156;

import java.util.Scanner;

public class June10_WineTasting {
//https://www.acmicpc.net/problem/2156
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int[] a = new int[t+1];
		for( int i=1; i<=t; i++) {
			a[i] = scan.nextInt();
		}
		scan.close();
		int[] drank = new int[t+1];
		int[] totalDrank = new int[t+1];
		drank[1] = a[1];
		totalDrank[1] = drank[1];
		if(t==1) {
			System.out.println(totalDrank[1]);
			return;
		}
		
		drank[2] = a[2];
		totalDrank[2] = drank[2]+drank[1];
		if(t==2) {
			System.out.println(totalDrank[2]);
			return;
		}
		if( a[3]>a[1] || a[3] > a[2]) {
			drank[3] = a[3];
			if(a[1]>a[2]) {
				drank[2] = 0;
			}else {
				drank[1] = 0;
			}
		}
		totalDrank[3] = drank[1]+drank[2]+drank[3];
		if(t==3) {
			System.out.println(totalDrank[3]);
			return;
		}
		for(int i =4; i<=t; i++) {
			if(drank[i-1]==0 ||drank[i-2]==0) {// i번째 잔을 마실까?
				drank[i] = a[i];
				totalDrank[i] = totalDrank[i-1]+drank[i];
				continue;
			}
			int case0 = totalDrank[i-1];
			int case1 = totalDrank[i-2]+a[i];
			int case2 = totalDrank[i-3]+a[i]+a[i-1];
			int max = Math.max(case0, Math.max(case1, case2));
			if(max==case0) {
				totalDrank[i] = case0;
			}else if(max==case1) {
				totalDrank[i]= case1;
				drank[i]=a[i];
				drank[i-1]=0;
			}else {
				totalDrank[i] = case2;
				drank[i]=a[i];
				drank[i-1]=a[i-1]; 
			}
		}
		System.out.println(totalDrank[t]);
	}
}

