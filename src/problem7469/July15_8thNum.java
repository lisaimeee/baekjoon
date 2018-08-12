package problem7469;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class July15_8thNum {
//https://www.acmicpc.net/problem/7469
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int leafNodes = 1;
		
		while((leafNodes*=2)<n) {;;}
		List<Integer>[]tree = new ArrayList[leafNodes*2];
		for(int i=0; i<tree.length;i++) {
			tree[i] = new ArrayList<Integer>();
		}
		st = new StringTokenizer(br.readLine());
		for(int i = leafNodes; i < tree.length ; i++ ) {
			int input;
			if(i-leafNodes<n) {
				input = Integer.parseInt(st.nextToken());
			}else {
				input = Integer.MAX_VALUE;
			}
			tree[i].add(input);
		}
		int pointer = leafNodes-1;
		while(pointer>0) {
			List<Integer> left = tree[pointer*2];
			List<Integer> right = tree[pointer*2+1];
			List<Integer> temp = merge(left, right);
			tree[pointer] =temp;
			pointer--;
		}
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int qs = Integer.parseInt(st.nextToken())-1;
			int qe = Integer.parseInt(st.nextToken())-1;
			int k = Integer.parseInt(st.nextToken())-1;
			List<Integer> temp = query(qs, qe, tree, 1, 0, leafNodes-1);
			System.out.println(temp.get(k));
		}
	}
	public static List<Integer> merge(List<Integer> arr, List<Integer> brr) {
		if(arr == null ) return brr;
		if(brr == null ) return arr;
		List<Integer> crr = new ArrayList<>();
		int a=0, b=0;
		while(a<arr.size()||b<brr.size()) {
			if(a<arr.size() && b<brr.size()) {
				crr.add(arr.get(a)<brr.get(b)? arr.get(a++):brr.get(b++));
			}else if( a<arr.size() && b>=brr.size()) {
				crr.add(arr.get(a++));
			}else {
				crr.add(brr.get(b++));
			}
		}
		return crr;
	}
	public static List<Integer>  query(int qs, int qe, List<Integer>[] tree, int i, int l, int r) {
		if( qe < l || r < qs) {
			return null;
		}
		if( qs <= l && r <= qe) {
			return tree[i];
		}
		return merge(query(qs, qe, tree, i*2, l, (l+r)/2), query(qs, qe, tree, i*2+1, (l+r)/2+1, r));
	}
}
