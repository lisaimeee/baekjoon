package problem2621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class May12_CardGame {
//2621
	public static void main(String[] args) {
		try (
				InputStreamReader in = new InputStreamReader(System.in); 
				BufferedReader reader = new BufferedReader(in);
			) {
			
			// 숫자를 담을 변수
			int[] numbers = new int[10]; //
			// 색깔 담을 변수
			String color = null;
			// 모두 같은 색인지 조사할 변수
			boolean isOneColor = true;
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			color = tokenizer.nextToken();
			++numbers[Integer.parseInt(tokenizer.nextToken())];
			
			for(int i = 0; i <4; i++ ) {
			   String line = reader.readLine();
				tokenizer = new StringTokenizer(line);
				if (!color.equals(tokenizer.nextToken())&&isOneColor) {
					isOneColor = false;
				}
				++numbers[Integer.parseInt(tokenizer.nextToken())];
			}
			
			// 연속된 숫자 여부를 담을 변수 
			boolean isSequential = true;
			// 조사한 카드 수를 저장할 변수 
			// count == 5이면 5개 카드를 모두 조사 한 
			int count = 0;
			int max = 0;
			int score = 0;
			int twoAreSame = 0;
			int biggerTwoAreSame = 0 ;
			int threeAreSame = 0;
			int fourAreSame = 0; 
			
			for (int i = 1; i < 10; i++) {
				switch(numbers[i]) {
				case 4:
					fourAreSame = i; 
					break;
				case 3:
					threeAreSame = i;
					break;
				case 2:
					if( twoAreSame != 0 ) {
						biggerTwoAreSame = i ;
					} else {
						twoAreSame = i;
					}
				}
				count += numbers[i];
				if (count == 5) {
					max = i;
					break;
				}
				
				if (isSequential && i < 9 &&  numbers[i]!=0 && (numbers[i]!=1 || numbers[i+1]!=1 )) {
					isSequential = false;
				}
			}
			if( isOneColor && isSequential ) {
				//카드 5장이 모두 같은 색이면서 숫자가 연속적일 때, 점수는 가장 높은 숫자에 900을 더한다. 
				//예를 들어, 카드가 Y4, Y3, Y2, Y5, Y6 일 때 점수는 906(=6+900)점이다.
				score = max + 900;
			} else if ( fourAreSame > 0 ) {
				//카드 5장 중 4장의 숫자가 같을 때 점수는 같은 숫자에 800을 더한다. 
				//예를 들어, 카드가 B3, R3, B7, Y3, G3 일 때 점수는 803(=3+800)점이다.
				score = fourAreSame + 800;
			} else if (threeAreSame > 0 && twoAreSame > 0 ) {
				//카드 5장 중 3장의 숫자가 같고 나머지 2장도 숫자가 같을 때 점수는 3장이 같은 숫자에 10을 곱하고 2장이 같은 숫자를 더한 다음 700을 더한다. 
				// 예를 들어, 카드가 R5, Y5, G7, B5, Y7 일 때 점수는 757(=5x10+7+700)점이다.
				score = threeAreSame*10+twoAreSame+700;
			} else if( isOneColor) {
				//5장의 카드 색깔이 모두 같을 때 점수는 가장 높은 숫자에 600을 더한다.
				//예를 들어, 카드가 Y3, Y4, Y8, Y6, Y7 일 때 점수는 608(=8+600)점이다.
				score = max + 600;
			}else if(isSequential) {
				//카드 5장의 숫자가 연속적일 때 점수는 가장 높은 숫자에 500을 더한다. 
				//예를 들어 R7, R8, G9, Y6, B5 일 때 점수는 509(=9+500)점이다.
				score = max + 500;
			} else if( threeAreSame > 0 ) {
				//카드 5장 중 3장의 숫자가 같을 때 점수는 같은 숫자에 400을 더한다. 예를 들어 R7, Y7, R2, G7, R5 일 때 점수는 407(=7+400)점이다.
				score = threeAreSame+ 400;
			} else if (  biggerTwoAreSame > 0 ) {
				//카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때 점수는 같은 숫자 중 큰 숫자에 10을 곱하고 같은 숫자 중 작은 숫자를 더한 다음 300을 더한다. 
				//예를 들어, R5, Y5, Y4, G9, B4 일 때 점수는 354(=5X10+4+300)점이다.
				score = biggerTwoAreSame*10 + twoAreSame + 300;
			} else if (twoAreSame > 0) {
				//카드 5장 중 2장의 숫자가 같을 때 점수는 같은 숫자에 200을 더한다. 
				// 예를 들어, R5, Y2, B5, B3, G4 일 때 점수는 205(=5+200)점이다.
				score = twoAreSame+ 200;
			} else { 
				//위의 어떤 경우에도 해당하지 않을 때 점수는 가장 큰 숫자에 100을 더한다. 
				//예를 들어, R1, R2, B4, B8, Y5 일 때 점수는 108(=8+100)점이다.
				score = max + 100;
			}
			
			System.out.println(score);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
