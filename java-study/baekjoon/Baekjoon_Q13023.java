package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_Q13023 {
    public static int N, M, ans;
    public static int[][] adjMatrix;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (M < 4) {
            System.out.println(0);
            return;
        }

        adjMatrix = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjMatrix[a][b] = 1;
            adjMatrix[b][a] = 1;

        }

        for (int i = 0; i < N; i++) {
            dfs(0, i);
        }

        System.out.println(ans);
    }

    public static void dfs(int cnt, int start) {
        if (cnt == 4) {
            ans = 1;
            return;
        }

        visited[start] = true;
        for (int i = 0; i < N; i++) {
            if (adjMatrix[start][i] == 1 && !visited[i]) {
                dfs(cnt + 1, i);
            }
        }
        visited[start] = false;
    }
}
