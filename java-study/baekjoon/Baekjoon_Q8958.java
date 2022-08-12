package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q8958 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < T + 1; test_case++) {
            String[] s = br.readLine().split("");

            int streak = 0;
            int[] score = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("O")) {
                    streak++;
                    score[i] = streak;
                } else {
                    streak = 0;
                    score[i] = streak;
                }
            }

            int sum = 0;
            for (int i = 0; i < score.length; i++) {
                sum += score[i];
            }
            System.out.println(sum);
        }
    }
}
