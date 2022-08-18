package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q1987 {
    public static int R, C, ans;
    public static int[][] board;
    public static boolean[] visited = new boolean[26];
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j) - 'A';
            }
        }

        ans = 0;
        move(0, 0, 0);

        System.out.println(ans);

    }

    public static void move(int r, int c, int depth) {
        if (visited[board[r][c]]) {
            ans = Math.max(ans, depth);
            return;
        } else {
            visited[board[r][c]] = true;
            for (int i = 0; i < 4; i++) {
                int newR = r + dx[i];
                int newC = c + dy[i];

                if (newR >= 0 && newC >= 0 && newR < R && newC < C) {
                    move(newR, newC, depth + 1);
                }
            }
            visited[board[r][c]] = false;
        }
    }
}