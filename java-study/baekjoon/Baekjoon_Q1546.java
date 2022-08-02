package baekjoon;

import java.util.Scanner;

public class Baekjoon_Q1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		double[] score = new double[N];
		
		double maxScore = 0;
		for (int i=0; i<N; i++) {
			score[i] = sc.nextInt();
		}
		
		for (int i=0; i<N; i++) {
			maxScore = Math.max(score[i],  maxScore);
		}
		
		for (int i=0; i<N; i++) {
			score[i] = (score[i]/maxScore)* 100;
		}
		
		double newAvg = 0;
		double sum = 0;
		for (int i=0; i<N; i++) {
			sum += score[i];
		}
		
		newAvg = sum/N;
		System.out.println(newAvg);
		
		sc.close();
	}
}
