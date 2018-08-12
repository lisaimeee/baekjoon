package problem4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class August5_Test {
//https://www.acmicpc.net/problem/4948
	static final int MAX = 123456*2; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader( new InputStreamReader(System.in));
		boolean[] isPrime = new boolean[MAX+1];
		int[] tree = new int[MAX+1];
		int squareRoot = (int) Math.sqrt(MAX);

		
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for( int i = 2; i < squareRoot ; i++ ) {
			if(isPrime[i]) {
				update(tree, i, 1);
				for( int j= i*i; j< MAX+1; j+=i ) {
					isPrime[j] = false;
				}
			}
		}
		for(int i = squareRoot-1; i<MAX+1; i++) {
			if(isPrime[i]) {
				update(tree, i, 1);
			}
		}
		int input = Integer.parseInt(br.readLine());
		while(input != 0 ) {
			System.out.println(query(tree, input*2)-query(tree, input));
			input = Integer.parseInt(br.readLine());
		}
	}
	
	public static void update(int[] tree, int i, int value) {
		while(i<tree.length) {
			tree[i] +=value;
			i += (i&-i);
		}
	}
	
	public static int query(int[] tree, int i) {
		int ans =0;
		while(i>0) {
			ans += tree[i];
			i -= (i&-i);
		}
		return ans;
	}
}
