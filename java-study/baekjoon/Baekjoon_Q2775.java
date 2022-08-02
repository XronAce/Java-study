package baekjoon;

import java.util.Scanner;

public class Baekjoon_Q2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<T+1; test_case++) {
			int K = sc.nextInt();
			int N = sc.nextInt();
			int[][] apt = new int[K+1][N];
			int sum = 0;
			
			for (int j=0; j<N; j++) {
				apt[0][j] = j+1;
			}
			
			for (int i=1; i<K+1; i++) {
				for (int j=0; j<N; j++) {
					sum = 0;
					for (int k=0; k<=j; k++) {
						sum += apt[i-1][k];
					}
					apt[i][j] = sum;
				}
			}
			System.out.println(apt[K][N-1]);
		}
		sc.close();
	}
}
