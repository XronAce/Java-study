package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_Q2178 {
    public static int N, M;
    public static int[][] map;
    public static int[] dx = { 1, -1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static boolean[][] isVisited;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        isVisited[0][0] = true;
        dfs(0, 0, 1);

        System.out.println(ans);

    }

    public static void dfs(int r, int c, int depth) {
        if (r == N - 1 && c == M - 1) {
            ans = Math.min(ans, depth);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newR = r + dx[i];
            int newC = c + dy[i];

            if (newR >= 0 && newC >= 0 && newR < N && newC < M && map[newR][newC] == 1 && !isVisited[newR][newC]) {
                isVisited[newR][newC] = true;
                dfs(newR, newC, depth + 1);
                isVisited[newR][newC] = false;
            }
        }

    }
}
