package problem6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LargestSquareInHistogram {
//https://www.acmicpc.net/problem/6549
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		while(!"0".equals(line)) {
			String[] tokens = line.split(" ");
			int n = Integer.parseInt(tokens[0]);
			int leafNodeSize=1;
			while((leafNodeSize*=2)<n) {;;}
			int[] tree = new int[leafNodeSize*2];
			Arrays.fill(tree, Integer.MAX_VALUE);
			int max = Integer.MIN_VALUE;
			for(int i = 1; i<= n; i++) {
				int height = Integer.parseInt(tokens[i]);
				tree[leafNodeSize+i-1] = height;
				if(height > max) {
					max = height;
				}
			}
			build(tree);
			int left = 1;
			int right = n;
			int ql = left;
			int qr = right;
			int idx = 1; 
			int width = right-left +1;
			while(width > 1) {
				int height =query(left,right,ql,qr,idx,tree);
				System.out.println(height);
				int area = height*width;
				
				if(area>max) {
					max = area;
				}	
				ql++; qr++;
				if(qr>right) {
					width--;
					ql=1;
					qr=width;
				}
			}
//			Queue<Node> q = new LinkedList<>();
//			q.add(new Node(1, 1, leafNodeSize));
//			while(!q.isEmpty()) {
//				Node current = q.poll();
//				int height = tree[current.index];
//				if (height==Integer.MAX_VALUE) continue;
//				int width = current.right-current.left+1;
//				if(current.right>n) {
//					width-=current.right-n;
//				}
//				int area = height*width;
//				if(area>max) {
//					max = area;
//				}	
//				System.out.println(width+", "+height+", "+ current.left+", "+current.right);
//				
//				if(current.index*2>leafNodeSize || current.left>n) continue;
//				Node left = new Node(current.index*2, current.left, (current.left+current.right)/2);
//				if((current.left+current.right)/2+1>n) continue;
//				Node right = new Node(current.index*2+1, (current.left+current.right)/2+1, current.right);
//				q.add(left);
//				q.add(right);
//			}
			System.out.println(max);
			line = br.readLine();
		}
		
	}
	public static int query(int left , int right, int ql, int qr, int index, int[] tree) {
		if(left<ql || right>qr ) {
			return Integer.MAX_VALUE;
		}
		if(ql <= left && right <=qr ) {
			return tree[index];
		}
		return Math.min(query(left, (left+right)/2, ql, qr, index*2, tree), 
				query((left+right)/2+1, right, ql, qr, index*2+1,tree));
	}
	public static void build(int[] tree) {
		for(int i = tree.length/2-1; i>0; i--) {
			tree[i] = Math.min(tree[i*2], tree[i*2+1]);
		}
	}
	static class Node{
		int index;
		int left;
		int right;
		public Node(int index, int left, int right) {
			super();
			this.index = index;
			this.left = left;
			this.right = right;
		}
	}
}
