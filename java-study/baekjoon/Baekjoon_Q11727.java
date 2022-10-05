package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q11727 {
    public static int[] dp = new int[1001];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(sol(N));
    }
    
    public static int sol(int n) {
        if (n <= 1) {
            return 1;
        } else if (n == 2) {
            return 3;
        }

        if (dp[n] != 0) {
            return dp[n];
        } else {
            if (n%2 == 0) {
                dp[n] = 2 * sol(n - 1) % 10007 + 1;
            } else {
                dp[n] = 2 * sol(n - 1) % 10007 - 1;
            }
            return dp[n];
        }
    }
}
