package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1189 {
    public static int R, C, K, answer;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static char[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i=0; i<R; i++) {
            String s = br.readLine();
            for (int j=0; j<C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        dfs(R-1, 0, 1);

        System.out.println(answer);

    }

    public static void dfs(int r, int c, int depth) {
        visited[r][c] = true;
        if (r == 0 && c == C-1) {
            if (depth == K) {
                answer++;
            }
            return;
        }

        for (int i=0; i<4; i++) {
            int newR = r + dx[i];
            int newC = c + dy[i];
            if (newR >= 0 && newC >= 0 && newR < R && newC < C) {
                if (map[newR][newC] == '.' && !visited[newR][newC]) {
                    dfs(newR, newC, depth+1);
                    visited[newR][newC] = false;
                }
            }
        }
    }
}
