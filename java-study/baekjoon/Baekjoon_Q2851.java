package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q2851 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] mushroom = new int[10];
        for (int i = 0; i < 10; i++) {
            mushroom[i] = Integer.parseInt(br.readLine());
        }

        int[] cumulScore = new int[10];
        cumulScore[0] = mushroom[0];
        for (int i = 1; i < 10; i++) {
            cumulScore[i] = cumulScore[i - 1] + mushroom[i];
        }

        int[] scoreDiff = new int[10];
        for (int i = 0; i < 10; i++) {
            scoreDiff[i] = Math.abs(cumulScore[i] - 100);
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            minDiff = Math.min(scoreDiff[i], minDiff);
        }

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            if (scoreDiff[i] == minDiff) {
                idx = i;
            }
        }

        System.out.println(cumulScore[idx]);
    }
}
