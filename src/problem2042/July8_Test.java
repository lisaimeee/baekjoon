package problem2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class July8_Test {
	// https://www.acmicpc.net/problem/2042
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//숫자 개수 
		int m = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());//숫자 개수 
		int leafNodeSize = 1;
		while(leafNodeSize<n) {
			leafNodeSize *= 2;
		}
		// 수 입력 받기 
		int treeSize = leafNodeSize*2;
		long[] segmentTree = new long[treeSize];
		int pointer = leafNodeSize;
		for(long i =0 ; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			segmentTree[pointer++] = Integer.parseInt(st.nextToken());
		}
		// 부모 노드에 합 저장하기 
		pointer = treeSize-1;
		int idx = leafNodeSize;
		while(idx>1) {
			for(int i = pointer; i>pointer/2;i-=2) {
				segmentTree[--idx]=segmentTree[i]+segmentTree[i-1];
			}
			pointer/=2;
		}
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==1) {
				int target = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				update(segmentTree,target, value);
			} else {
				int qs = Integer.parseInt(st.nextToken())-1;
				int qe = Integer.parseInt(st.nextToken())-1;
				System.out.println(query(segmentTree,qs, qe, 1, 0, leafNodeSize-1));
			}
		}
	}
	public static long query(long[] segmentTree, int qs, int qe, int node, int s, int e) {
		if(qs>e || qe<s) {// 겹치는 부분이 없으면 
			return 0;
		}
		if(qs<=s&&e<=qe) { // 완전히 겹치면
			return segmentTree[node];
		}
		return query(segmentTree,qs, qe, node*2, s, (s+e)/2) + query(segmentTree,qs, qe, node*2+1, (s+e)/2+1, e);
	}
	public static void update(long[] segmentTree,int target, int value) {
		target = segmentTree.length/2+target-1;
		segmentTree[target]=value;
		int l,r;
		while(target>0) {
			target/=2;
			l = target*2;
			r = l+1;
			segmentTree[target] = segmentTree[l]+segmentTree[r];
		}
	}
		
}


