package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_Q9205 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();
            
			for(int i=0; i<n+2; i++) {
                st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int[] temp = { x, y };
				list.add(temp);
			}
			
            boolean[][] check = new boolean[n + 2][n + 2];
            
			for(int i=0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					int[] pos = list.get(i), next = list.get(j);
					int dis = Math.abs(pos[0] - next[0]) + Math.abs(pos[1]-next[1]);
					
					if(dis <= 1000) check[i][j] =true;
				}
			}
			
            for (int k = 0; k < n + 2; k++) {
                for (int i = 0; i < n + 2; i++) {
                    for (int j = 0; j < n + 2; j++) {
                        if (check[i][k] && check[k][j]) {
                            check[i][j] = true;
                        }
                    }
                }
            }
            
            if (check[0][n + 1]) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
		}
	}
}