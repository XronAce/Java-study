package baekjoon;

import java.util.Scanner;

public class Baekjoon_Q2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		
		for (int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		for (int i=0; i<9; i++) {
			max = Math.max(arr[i], max);
		}
		System.out.println(max);
		
		for (int i=0; i<9; i++) {
			if (arr[i] == max) {
				System.out.println(i+1);
				break;
			}
		}
		
		sc.close();
	}
}
