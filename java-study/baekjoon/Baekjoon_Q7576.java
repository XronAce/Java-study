package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int r, c;

    public Tomato(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Baekjoon_Q7576 {
    public static int N, M, ans;
    public static int[][] grid;
    public static boolean[][] isVisited;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); // column
        N = Integer.parseInt(st.nextToken()); // row

        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        isVisited = new boolean[N][M];
        bfs();

        boolean cannotBeFullyGrown = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) {
                    cannotBeFullyGrown = true;
                    break;
                }
            }
            if (cannotBeFullyGrown) {
                break;
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        if (cannotBeFullyGrown) {
            System.out.println(-1);
        } else {
            System.out.println(max - 1);
        }

    }

    public static void bfs() {
        Queue<Tomato> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    Tomato temp = new Tomato(i, j);
                    que.offer(temp);
                    isVisited[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            Tomato cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int newR = cur.r + dx[i];
                int newC = cur.c + dy[i];

                if (newR >= 0 && newC >= 0 && newR < N && newC < M) {
                    if (!isVisited[newR][newC] && grid[newR][newC] == 0) {
                        isVisited[newR][newC] = true;
                        Tomato temp1 = new Tomato(newR, newC);
                        que.offer(temp1);
                        grid[newR][newC] = grid[cur.r][cur.c] + 1;
                    }
                }
            }
        }

    }
}
