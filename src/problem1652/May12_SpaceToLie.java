package problem1652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class May12_SpaceToLie {
		
	public static void main(String[] args) {
		try(
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
		){
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int num = Integer.parseInt(tokenizer.nextToken());
			String[][] room = new String[num][num];
			String line = null;
			for ( int i = 0; i < num; i++ ) {
				line = new StringTokenizer(reader.readLine()).nextToken();
				for( int j = 0; j < num; j++ ) {
					room[i][j] = line.substring(j,j+1);
				}
			}
			
			int rowSpaces = getSpaceInRow(room);
			int colSpaces = getSpaceInCol(room);
			System.out.println(rowSpaces +" "+ colSpaces);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static int getSpaceInRow(String[][] room) {
		int space = 0;
		int cell =0;
		int length = room.length;
		for(int i = 0 ; i < length; i++ ) {
			for(int j = 0; j <length; j++ ) {
				switch(room[i][j]) {
				case "X":
					if(cell>=2) {
						space++;
					}
					cell=0;
					break;
				case ".":
					cell++;
					if(j+1==length && cell>=2 ) {
						space++;
					}
				}
			}
			cell=0;
		}
		return space ;
	}
	public static int getSpaceInCol(String[][] room) {
		int space = 0; 
		int cell = 0;
		int length = room.length;
		for(int j = 0 ; j < length; j++ ) {
			for( int i =0; i <length; i++ ) {
				switch(room[i][j]) {
				case "X":
					if(cell>=2) {
						space++;
					}
					cell=0;
					break;
				case ".":
					cell++;
					if(i+1==length && cell>=2 ) {
						space++;
					}
				}
			}
			cell=0;
		}
		return space ;
	}
}
