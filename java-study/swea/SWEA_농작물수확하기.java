package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_농작물수확하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<T+1; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[N][N];
			
			for (int i=0; i<N; i++) {
				String s = br.readLine();
				for (int j=0; j<N; j++) {
					farm[i][j] = s.charAt(j)-'0';
				}
			}
			int sum = 0;
			for (int i=0; i<N; i++) {
				if (i < N/2) {
					for (int j=N/2-i; j<=N/2+i; j++) {
						sum += farm[i][j];
					}
				} else if (i >= N/2) {
					for (int j=N/2-(N-i-1); j<=N/2+N-i-1; j++) {
						sum += farm[i][j];
					}
				}
			}
			
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
