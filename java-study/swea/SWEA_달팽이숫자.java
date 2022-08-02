package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_달팽이숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case=1; test_case<T+1; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println("#"+test_case);
			
			int[][] snail = new int[N][N];
			
			
			int cnt = 1;
			int r = 0; int c = 0;
			while (cnt != N*N) {
				// right
				while (c+1 < N && snail[r][c+1] == 0) {
					snail[r][c] = cnt;
					c++; cnt++;
					if (c == N-1) {
						snail[r][c] = cnt;
						r++; cnt++;
						break;
					}
				}
				
				// down
				while (r+1 < N && snail[r+1][c] == 0) {
					snail[r][c] = cnt;
					r++; cnt++;
					if (r == N-1) {
						snail[r][c] = cnt;
						c--; cnt++;
						break;
					}
				}
				
				// left
				while (c-1 >= 0 && snail[r][c-1] == 0) {
					snail[r][c] = cnt;
					c--; cnt++;
					if (c == 0) {
						snail[r][c] = cnt;
						r--; cnt++;
						break;
					}
				}
				// up
				while (r-1 >= 0 && snail[r-1][c] == 0) {
					snail[r][c] = cnt;
					r--; cnt++;
					if (r == 0) {
						snail[r][c] = cnt;
						c++; cnt++;
						break;
					}
				}
				if (cnt > N*N)
					break;
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (snail[i][c] == 0) {
						snail[i][c] = cnt;
					}
				}
			}
			
			for (int[] innerArr: snail) {
				for (int i=0; i<innerArr.length; i++) {
					System.out.printf("%d ", innerArr[i]);
				}
				System.out.println();
			}
			
		}
	}
}
