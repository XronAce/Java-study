package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q4485 {
    public static int N, linkR, linkC, rupee;
    public static int[][] map;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static boolean[][] isVisited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int problemNo = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            map = new int[N][N];
            isVisited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            linkR = 0;
            linkC = 0;
            rupee = map[linkR][linkC];
            isVisited[linkR][linkC] = true;

            while (true) {
                if (linkR == N - 1 && linkC == N - 1) {
                    break;
                }
                move(linkR, linkC);
            }

            sb.append("Problem " + problemNo + ": " + rupee).append("\n");
            problemNo++;
        }
        System.out.println(sb);
    }

    public static void move(int r, int c) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int newR = r + dx[i];
            int newC = c + dy[i];

            if (newR >= 0 && newC >= 0 && newR < N && newC < N) {
                if (newR == N - 1 && newC == N - 1) {
                    linkR = newR;
                    linkC = newC;
                    break;
                } else {
                    if (!isVisited[newR][newC]) {
                        isVisited[newR][newC] = true;
                        min = Math.min(min, map[newR][newC]);
                        if (min == map[newR][newC]) {
                            linkR = newR;
                            linkC = newC;
                        }
                    }
                }
            }
        }
        rupee += map[linkR][linkC];
    }
}
