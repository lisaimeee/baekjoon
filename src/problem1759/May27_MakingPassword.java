package problem1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class May27_MakingPassword {
	//https://www.acmicpc.net/problem/1759
	public static void main(String[] args) {
		try(
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(in);
		){
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int l = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());
			char[] letters = new char[c];
			for( int i =0; i< c; i++) {
				letters[i] = (char)reader.read();
				reader.read();
			}
			reader.close();
			// 정렬
			quicksort(letters, 0, letters.length-1);
			for(int i=0; i<=letters.length-l;i++) {
				dfs(letters,i,"",l);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void dfs(char[] a, int c, String password, int length) {
		password+=a[c];
		if(password.length()==length) {
			if(hasVowelAndConsonant(password)) {
				System.out.println(password);
			}
			return;
		}
		for(int i =c+1;i<a.length;i++) {
			if(password.indexOf(a[i])==-1) {
				dfs(a,i,password,length);
			}
		}
	}
	public static boolean hasVowelAndConsonant(String s) {
		boolean hasVowel = s.indexOf('a')>=0
				||s.indexOf('e')>=0
				||s.indexOf('i')>=0
				||s.indexOf('o')>=0
				||s.indexOf('u')>=0;
		s=s.replace("a", "");
		s=s.replace("e", "");
		s=s.replace("i", "");
		s=s.replace("o", "");
		s=s.replace("u", "");
		if(hasVowel && s.length()>=2) {
			return true;
		}
		return false;
	}
	public static void quicksort(char[] a, int left, int right) {
		int i=left;
		int j=right;
		char pivot=a[(left+right)/2];
		char temp;
		while(i<=j) {
			while(a[i]<pivot) {
				i++;
			}
			while(a[j]>pivot) {
				j--;
			}
			if(i<=j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
			
		}
		if(left<j) {
			quicksort(a, left, j);
		}
		if(i<right) {
			quicksort(a, i, right);
		}
	}
}
