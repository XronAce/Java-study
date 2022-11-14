package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q15761 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case=1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			
			if (B == 0) {
				ans = A;
			} else if (A == 1) {
				ans = 1;
			} else if (B == 1) {
				if (A == 2) {
					ans = 4;
				} else {
					ans = A + 1;
				}
			} else if (A > B) {
				ans = A;
			} else if (A <= B) {
				ans = 2*A;
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
}
