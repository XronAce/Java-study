package baekjoon;

import java.util.Scanner;

public class Baekjoon_Q10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<T+1; test_case++) {
			int H = sc.nextInt();
			@SuppressWarnings("unused")
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			if(N % H == 0) {
				System.out.println((H * 100) + (N / H));
 
			} else {
				System.out.println(((N % H) * 100) + ((N / H) + 1));
			}
		}
		
		sc.close();
	}
}
