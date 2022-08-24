package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Posit {
    int r, c;

    public Posit(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Baekjoon_Q2178 {
    public static int N, M;
    public static int[][] map;
    public static int[] dx = { 1, -1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static boolean[][] isVisited;
    public static int ans = 0;

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

        Posit pos = new Posit(0, 0);
        bfs(pos);

        System.out.println(map[N - 1][M - 1]);
    }

    public static void bfs(Posit pos) {
        Queue<Posit> que = new LinkedList<>();
        que.offer(pos);
        isVisited[pos.r][pos.c] = true;

        while (!que.isEmpty()) {
            Posit cur = que.poll();
            int curR = cur.r;
            int curC = cur.c;
            for (int i = 0; i < 4; i++) {
                int newR = curR + dx[i];
                int newC = curC + dy[i];
                if (newR >= 0 && newC >= 0 && newR < N && newC < M) {
                    if (map[newR][newC] == 1 && !isVisited[newR][newC]) {
                        Posit newPos = new Posit(newR, newC);
                        isVisited[newR][newC] = true;
                        map[newR][newC] = map[curR][curC] + 1;
                        que.add(newPos);
                    }
                }
            }
        }
    }
}
