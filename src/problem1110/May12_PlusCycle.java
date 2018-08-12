package problem1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class May12_PlusCycle {
//1110
	public static void main(String[] args) {
		try (   
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
			) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			
			int original = n;
			int cycleLength = 0;
			boolean returned = false;
			int first, second;
			while (!returned) {
				cycleLength++;
				first = n / 10;
				second = n % 10;
				n = second * 10 + (first + second) % 10;
				if (n == original) {
					returned = true;
				}
			}
			System.out.println(cycleLength);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
