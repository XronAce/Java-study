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
			
			String maxNum = "";
			String minNum = "1";
			for (int i=0; i<A; i++) {
				maxNum += "1";
			}
			
			for (int i=0; i<B; i++) {
				maxNum += "0";
				minNum += "0";
			}
			
			for (int i=0; i<A-1; i++) {
				minNum += "1";
			}
			
			int maxNumInDec = Integer.parseInt(maxNum, 2);
			int minNumInDec = Integer.parseInt(minNum, 2);
			
			int res = maxNumInDec * minNumInDec;
			
			String ans = Integer.toBinaryString(res);
			int cntOne = 0;
			
			for (int i=0; i<ans.length(); i++) {
				if (ans.charAt(i) == '1') {
					cntOne++;
				}
			}
			
			System.out.println("#"+test_case+" "+cntOne);
		}
	}
}
