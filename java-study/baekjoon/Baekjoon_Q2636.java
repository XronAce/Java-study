package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_Q2636 {
    public static int N, M, cheeseCnt;
    public static int[][] cheese;
    public static boolean[][] isVisited;
    public static int[] dx = { 1, -1, 0, 0 };
    public static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = new int[N][M];
        isVisited = new boolean[N][M];
        cheeseCnt = 0;
        int cheeseBefore = 0;
        int hours = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }

        while (cheeseCnt != 0) {
            cheeseBefore = cheeseCnt;
            meltCheck();
            hours++;
            melt();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    isVisited[i][j] = false;
                }
            }
        }
        
        System.out.println(hours);
        System.out.println(cheeseBefore);

    }
    
    public static void meltCheck() {
        Queue<int[]> que = new LinkedList<>();
        int[] start = { 0, 0 };
        que.offer(start);
        isVisited[0][0] = true;

        while (!que.isEmpty()) {
            int[] temp = que.poll();

            for (int i = 0; i < 4; i++) {
                int newR = temp[0] + dx[i];
                int newC = temp[1] + dy[i];
                if (newR >= 0 && newC >= 0 && newR < N && newC < M) {
                    if (cheese[newR][newC] == 1) {
                        cheese[newR][newC] = 3;
                    }

                    if (!isVisited[newR][newC] && cheese[newR][newC] == 0) {
                        int[] temp1 = { newR, newC };
                        que.offer(temp1);
                        isVisited[newR][newC] = true;
                    }
                }
            }
        }
        
    }

    public static void melt() {
        cheeseCnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheese[i][j] == 3) {
                    cheese[i][j] = 0;
                } else if (cheese[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }
    }
}
