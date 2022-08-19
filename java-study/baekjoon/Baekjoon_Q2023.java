package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q2023 {
    public static int N;
    public static StringBuilder sb = new StringBuilder();

    public static Boolean isPrime(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dfs("", 0);

        System.out.println(sb);
    }

    public static void dfs(String s, int cnt) {
        if (cnt == N) {
            sb.append(s).append("\n");
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (isPrime(Integer.parseInt(s + i))) {
                dfs(s + i, cnt + 1);
            }
        }
    }
}
