package problem10828;

import java.util.*;

public class May6_Stack {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		Stack stack = new Stack(size);
		while(scan.hasNext()) {
			switch(scan.next()) {
			
			case "push":
				stack.push(scan.nextInt());
				break;
			case "pop":
				System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				System.out.println(stack.empty());
				break;
			case "top":
				System.out.println(stack.top());
				break;
			}
		}
		scan.close();
		
	}
	
	static class Stack {
		int[] stack;
		int pointer;
		boolean isEmpty = true;
		
		public Stack() {
			// TODO Auto-generated constructor stub
		}
		public Stack(int size) {
			stack = new int[size];
		}
		
		void push(int x) {
			isEmpty = false;
			stack[++pointer]=x;
		}
		int pop() {
			if(isEmpty) {
				return -1;
			}
			--pointer;
			if(pointer==0) {
				isEmpty = true;
			}
			return stack[pointer+1];  
		}
		int size() {
			return isEmpty? 0:pointer;
		}
		int empty(){
			return isEmpty? 1:0;
		}
		int top() {
			return isEmpty? -1:stack[pointer];
		}
	}
}