package problem1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uclide {
//https://www.acmicpc.net/problem/1934
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		int t = Integer.parseInt(br.readLine());
		while( t-- >= 0 ) {
			String[] tokens = br.readLine().split(" ");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			if(a<b) {
				int tmp = a;
				a= b;
				b= tmp;
			}
			int gcd = gcd(a,b);
			System.out.println((a*b)/gcd);
		}
	}
	static int gcd(int a, int b) {
		
		while(b>0) {
			int tmp =a;
			 a= b;
			 b= tmp%b;
		}
		
		return a;
	}
}
