package problem1280;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PlantTree3 {
	//2018.07.29
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int maxLocation = 200001;
		int[] countTree = new int [ maxLocation ];
		int[] distanceSumTree  = new int [maxLocation];
		
		int current;
		
		long totalCost = 0; 
		for(int k = 1; k<=n; k++ ) {
			current = Integer.parseInt(br.readLine());//k번째 나무의 좌표 
			current++;
			update(countTree, current, 1); // 해당 좌표에 있는 나무 갯수 업데이트 
			update(distanceSumTree, current, current-1); // 좌표 거리 업데이트
			if(k==1) continue;
			// get number of tree that positioned in lower place
			// trees that are located upper than current
			int uppersCount = query(countTree, maxLocation-1) - query(countTree, current-1); 
			// trees that are located lower than current
			int lowersCount = query(countTree, current-1); 
			
			// trees that are located upper than current
			int uppersSum = query(distanceSumTree, maxLocation-1) - query(distanceSumTree, current-1); 
			// trees that are located lower than current
			int lowersSum = query(distanceSumTree, current-1); 
			current--;
			long cost = (current*lowersCount- lowersSum ) + (uppersSum- current*uppersCount);
			
			if(totalCost == 0 ) {
				totalCost += cost;
			}else {
				totalCost = (totalCost*cost) % 1000000007;
			}
		}
		
		System.out.println(totalCost);
		
	}
	public static void update(int[] fenwick, int i, int value ) {
		while(i<fenwick.length) {
			fenwick[i] += value;
			i += (i & -i);
		}
	}
	public static int query(int[] fenwick, int i) {
		int result = 0;
		while(i>0) {
			result += fenwick[i];
			i-=(i&-i);
		}
		return result;
	}
}
