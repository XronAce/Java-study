package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Position {
    int r, c;

    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Baekjoon_Q10026 {
    public static int N, areaNum;
    public static int[][] area;
    public static char[][] image;
    public static boolean[][] isVisited;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        N = Integer.parseInt(br.readLine());
        areaNum = 1;

        int normalAns = 0;
        int abnormalAns = 0;

        image = new char[N][N];
        area = new int[N][N];
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                image[i][j] = s.charAt(j);
            }
        }

        // normal check
        boolean isThereNoZero = false;

        Position start = new Position(0, 0);
        bfs(start);

        while (!isThereNoZero) {
            int r = 0;
            int c = 0;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] == 0) {
                        r = i;
                        c = j;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                isThereNoZero = true;
            }
            if (isThereNoZero) {
                break;
            }
            Position next = new Position(r, c);
            areaNum++;
            bfs(next);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, area[i][j]);
            }
        }

        normalAns = max;

        // abnormal check
        isThereNoZero = false;
        area = new int[N][N];
        isVisited = new boolean[N][N];
        areaNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (image[i][j] == 'G') {
                    image[i][j] = 'R';
                }
            }
        }

        bfs(start);
        while (!isThereNoZero) {
            int r = 0;
            int c = 0;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] == 0) {
                        r = i;
                        c = j;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                isThereNoZero = true;
            }
            if (isThereNoZero) {
                break;
            }
            Position next = new Position(r, c);
            areaNum++;
            bfs(next);
        }

        max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, area[i][j]);
            }
        }

        abnormalAns = max;

        System.out.println(normalAns + " " + abnormalAns);

    }

    public static void bfs(Position start) {
        Queue<Position> que = new LinkedList<>();
        que.offer(start);
        isVisited[start.r][start.c] = true;

        while (!que.isEmpty()) {
            Position cur = que.poll();
            area[cur.r][cur.c] = areaNum;
            for (int i = 0; i < 4; i++) {
                int newR = cur.r + dx[i];
                int newC = cur.c + dy[i];

                if (newR >= 0 && newC >= 0 && newR < N && newC < N) {
                    if (!isVisited[newR][newC] && image[cur.r][cur.c] == image[newR][newC]) {
                        isVisited[newR][newC] = true;
                        area[newR][newC] = areaNum;
                        Position temp = new Position(newR, newC);
                        que.offer(temp);
                    }
                }
            }
        }
    }
}
