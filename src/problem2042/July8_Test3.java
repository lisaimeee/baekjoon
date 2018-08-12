package problem2042;
import java.util.Scanner;

public class July8_Test3 {
	// https://www.acmicpc.net/problem/2042
	static int pointer = 0;  
	static int[] array;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();//숫자 개수 
		int m = scan.nextInt();//변경 횟수 
		int k = scan.nextInt();//쿼리 횟수
		array = new int[n];
		for(int i = 0; i< n ; i ++) {
			array[i] = scan.nextInt();
		}
		Node root = new Node(0,n-1);
		build(root);
		int line = m+k;
		while(line-->0) {
			int flag = scan.nextInt();
			switch(flag) {
			case 1:// update 
				int target = scan.nextInt()-1;
				int value = scan.nextInt();
				int diff = value-array[target];
				update(root, target, diff);
				break;
			case 2:// query 
				int qs = scan.nextInt()-1;
				int qe = scan.nextInt()-1;
				System.out.println(sum(root, qs, qe));
			}//switch
		}//while
		scan.close();
	}
	public static long sum(Node n, int qs, int qe) {
		if(qs>n.e||qe<n.s) {// 겹치는 부분이 없으면 
			return 0;
		}
		if(qs<=n.s&&n.e<=qe) { // 완전히 겹치면
			return n.value;
		}
		return sum(n.l,qs,qe) + sum(n.r,qs,qe);
	}
	public static void update(Node n,long target, long diff ) {
		n.value += diff;
		if(n.s == n.e) { return ; }
		if( target<=(n.s+n.e)/2) {
			update(n.l, target, diff);
		} else {
			update(n.r, target, diff );
		}
	}
	public static void build( Node n) {
		int s = n.s;
		int e = n.e;
		
		if( s==e ) {
			n.value = array[pointer++];
		}else {
			n.l = new Node(s,(s+e)/2);
			n.r = new Node((s+e)/2+1, e);
			build(n.l);
			build(n.r);
			n.value = n.l.value + n.r.value;
		}
		
	}
	
	static class Node{
		Node l;
		Node r;
		long value;
		int s;
		int e;
		public Node(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		@Override
		public String toString() {
			String s = "["+this.value+ ", "+this.s+", "+this.e+"] ";
			if(this.l!=null) {
				s += "\n";
				s += toString(this.l);
				s += "\n";
				s += toString(this.r);
			}
			return s;
		}
		public String toString(Node n) {
			String s = "[ "+n.value+ ", "+n.s+", "+n.e+"] ";
			if(n.l!=null) {
				s += "\n";
				s += toString(n.l);
				s += "\n";
				s += toString(n.r);
			}
			return s;
		}
		
		
	}
	
	
}

