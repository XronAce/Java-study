package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q10971 {
    public static int[][] W;
    public static int N;
    public static boolean[] isSelected;
    public static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        isSelected = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        permutation(0, new int[N]);
        System.out.println(minCost);
    }

    public static void permutation(int cnt, int[] out) {
        if (cnt == N) {
            int cost = 0;
            boolean isUnreachable = false;
            for (int i = 0; i < N - 1; i++) {
                if (W[out[i]][out[i + 1]] == 0) {
                    isUnreachable = true;
                    break;
                }
                cost += W[out[i]][out[i + 1]];
            }

            if (isUnreachable) {
                return;
            }

            if (W[out[N - 1]][out[0]] != 0) {
                cost += W[out[N - 1]][out[0]];
            } else {
                isUnreachable = true;
            }

            if (isUnreachable) {
                return;
            } else {
                minCost = Math.min(minCost, cost);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                out[cnt] = i;
                permutation(cnt + 1, out);
                isSelected[i] = false;
            }
        }
    }
}
