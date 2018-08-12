package problem2042;
import java.util.Scanner;

public class July8_Test2 {
	// https://www.acmicpc.net/problem/2042
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();//숫자 개수 
		int m = scan.nextInt();//변경 횟수 
		int k = scan.nextInt();//쿼리 횟수
		int h = 0;
		int size = n;
		while((size/=2)>0) {
			h++;
		}
		size = (int) Math.pow(2, h+1); // full binary tree 일 때, leaf node 사이즈
		long[] st = initialize(n, size, scan);
		
		while(scan.hasNext()) {
			int flag = scan.nextInt();
			switch(flag) {
			case 1:// update 
				int target = scan.nextInt();
				int value = scan.nextInt();
				update(st, target, value);
				break;
			case 2:// query 
				int qs = scan.nextInt()-1;
				int qe = scan.nextInt()-1;
				
				System.out.println(query(st, qs, qe, 0, size-1, 1));
				
			}
		}
		
	}
	public static long query(long[] st, int qs, int qe, int s, int e, int node) {
		if(qs>e||qe<s) {// 겹치는 부분이 없으면 
			return 0;
		}
		if(qs<=s&&e<=qe) { // 완전히 겹치면
			return st[node];
		}
		return query(st, qs, qe, s, (s+e)/2, node*2) + query(st, qs, qe, (s+e)/2+1, e, node*2+1);
	}
	public static void update(long[] st, int target, int value) {
		target = st.length/2+target-1;
		//update target node value
		st[target]=value;
		
		//update parent node value
		int parent = target/2;
		int l,r;
		if(target%2==0) {
			l =target;
			r = target+1;
		}else {
			l = target-1;
			r = target;
		}
		while(parent>0) {
			st[parent] = st[l]+st[r];
			if(parent%2==0) {
				l = parent;
				r = parent+1;
			}else {
				l = parent-1;
				r = parent;
			}
			parent/=2;
		}
	}
	public static long[] initialize(int n, int size, Scanner scan) {
		// segment array size 구하기 
		
		// 수 입력 받기 
		long[] tree = new long[size*2];
		int pointer = tree.length/2;
		for(long i =0 ; i<n; i++) {
			tree[pointer++] = scan.nextInt();
		}
		
		//sum구하기
		pointer = tree.length-1;
		while(size>1) {
			for(int i = pointer; i>pointer/2;i-=2) {
				tree[--size]=tree[i]+tree[i-1];
			}
			pointer/=2;
		}
		return tree;
	}
}

