package problem11758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ccw {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
		int[] points = new int[6];
		String[] tokens = null ;
		for(int i =0; i< 6; i+=2) {
			tokens = br.readLine().split(" ");
			points[i] = Integer.parseInt(tokens[0]);
			points[i+1]= Integer.parseInt(tokens[1]);
		}
		int result = ccw(points[0], points[1], points[2], points[3], points[4], points[5]);
		System.out.println(result);
	}
	public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
	    int temp = x1*y2+x2*y3+x3*y1;
	    temp = temp - y1*x2-y2*x3-y3*x1;
	    if (temp > 0) {
	        return 1;
	    } else if (temp < 0) {
	        return -1;
	    } else {
	        return 0;
	    }
	}
	
}
