package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q5215 {
    static int N, L, ans;
    static int[][] scoreCal;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < T + 1; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            scoreCal = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                scoreCal[i][0] = Integer.parseInt(st.nextToken()); // score
                scoreCal[i][1] = Integer.parseInt(st.nextToken()); // calorie
            }

            ans = 0;
            dfs(0, 0, 0);

            System.out.println("#" + test_case + " " + ans);

        }
    }

    static void dfs(int depth, int score, int cal) {
        if (cal > L) {
            return;
        }
        if (depth == N) {
            ans = Math.max(ans, score);
            return;
        }
        dfs(depth + 1, score + scoreCal[depth][0], cal + scoreCal[depth][1]);
        dfs(depth + 1, score, cal);
    }
}

/*
 * Used DFS algorithm to search all the way through.
 * dfs divides into two nodes all the time: picking ingredient & not picking
 * ingredient
 */