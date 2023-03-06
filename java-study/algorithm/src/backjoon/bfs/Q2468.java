package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2468 {
    public static int N, cnt, ans;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] map;
    public static int[][] reformedMap;
    public static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[N][N];
        reformedMap = new int[N][N];
        isVisited = new boolean[N][N];
        ans = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int height=0; height<=100; height++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    isVisited[i][j] = false;
                    cnt = 0;
                    if (map[i][j] <= height) {
                        reformedMap[i][j] = 0;
                    } else {
                        reformedMap[i][j] = 1;
                    }
                }
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (reformedMap[i][j] == 1 && !isVisited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            ans = Math.max(cnt, ans);
        }
        System.out.println(ans);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        int[] start = {r, c};
        que.offer(start);
        isVisited[r][c] = true;

        int newR, newC;
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            for (int i=0; i<4; i++) {
                newR = temp[0] + dx[i];
                newC = temp[1] + dy[i];
                if (newR < N && newC < N && newR >= 0 && newC >= 0) {
                    if (reformedMap[newR][newC] == 1 && !isVisited[newR][newC]) {
                        isVisited[newR][newC] = true;
                        int[] temp1 = {newR, newC};
                        que.offer(temp1);
                    }
                }
            }
        }
        cnt++;
    }
}
