package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q11726 {
    public static int[] dp = new int[1001];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;

        System.out.println(sol(N));

    }
    
    public static int sol(int n) {
        if (n<=1) {
            return 1;
        } else if (n==2) {
            return 2;
        }

        if (dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = (sol(n-1) + sol(n-2))%10007;
            return dp[n];
        }
    }
}
