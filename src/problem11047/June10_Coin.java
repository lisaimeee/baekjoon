package problem11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class June10_Coin {
	//https://www.acmicpc.net/problem/11047
	public static void main(String[] args) {
		try (
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(in);
		){
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int k = Integer.parseInt(tokenizer.nextToken());
			int[] a = new int[n];
			for(int i = 0 ; i < n; i++) {
				a[i] = Integer.parseInt(reader.readLine());
			}
			int number = 0;
			for( int i = n-1; i >=0; i--) {
				if(k%a[i]==0) {
					number+=k/a[i];
					break;
				}
				number+=k/a[i];
				k=k%a[i];
			}
			System.out.println(number);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
