package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Ladder1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			String s = br.readLine();
			int[][] ladder = new int[100][100];
			
			for(int i=0; i<100; i++) {
				s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				for (int j=0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int r = 99;
			int c = 0;
			
			for (int j=0; j<100; j++) {
				if (ladder[r][j] == 2) c = j;
			}
			
			while (r != 0) {
				if (c-1 >= 0 && ladder[r][c-1] == 1) {
					ladder[r][c] = 0;
					c = c-1;
				} else if (c+1 <= 99 && ladder[r][c+1] == 1) {
					ladder[r][c] = 0;
					c = c+1;
				} else if (r-1 >= 0 && ladder[r-1][c] == 1) {
					ladder[r][c] = 0;
					r = r-1;
				}
			}
			
			System.out.println("#"+test_case+" "+c);
			
		}
	}
}
