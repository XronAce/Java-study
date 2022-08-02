package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q1152 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int answer = 0;
		StringTokenizer st = new StringTokenizer(s);
		while(st.hasMoreTokens()) {
			st.nextToken();
			answer++;
		}
		
		System.out.println(answer);
	}
}
