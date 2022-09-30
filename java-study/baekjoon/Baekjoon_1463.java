package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1463 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N + 1];
        dp[1] = 0;
        int three, two, one;

        for (int i = 2; i <= N; i++) {
            three = Integer.MAX_VALUE;
            two = Integer.MAX_VALUE;
            one = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                three = dp[i / 3] + 1;
            }

            if (i % 2 == 0) {
                two = dp[i / 2] + 1;
            }

            one = dp[i - 1] + 1;

            dp[i] = Math.min(three, Math.min(two, one));
        }

        System.out.println(dp[N]);
    }
}

/*
매 단계를 저장 (memoization?)
i =   0  1  2  3  4  5  6  7  8  9  10
dp = {0, 0, 1, 1, 2, 3, 2, 3, 3, 2, 3}
*/