package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q3040 {
    static int sum;
    static int[] num;
    static StringBuilder sb;
    static boolean[] isSelected = new boolean[9];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        num = new int[9];
        for (int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int cnt, int start) {
        if (cnt == 7) {
            sum = 0;
            for (int i = 0; i < 9; i++) {
                if (isSelected[i]) {
                    sum += num[i];
                }
            }
            if (sum == 100) {
                for (int i = 0; i < 9; i++) {
                    if (isSelected[i]) {
                        sb.append(num[i]).append("\n");
                    }
                }
            }
        }
        for (int i = start; i < 9; i++) {
            isSelected[i] = true;
            dfs(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }
}
