package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Baekjoon_Q3055 {
    public static int timeAns, R, C, hedgeR, hedgeC, destR, destC;
    public static char[][] map;
    public static int[][] timeMap;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        timeMap = new int[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    hedgeR = i;
                    hedgeC = j;
                } else if (map[i][j] == 'D') {
                    destR = i;
                    destC = j;
                }
            }
        }

        timeAns = 0;
        bfs(hedgeR, hedgeC);

        System.out.println("KAKTUS");
    }

    public static void bfs(int hedgeR, int hedgeC) {
        Queue<int[]> que = new LinkedList<>();
        int[] temp = { hedgeR, hedgeC };
        que.offer(temp);
        int queSize = 0;

        while (!que.isEmpty()) {
            queSize = que.size();
            timeAns++;
            floodFill();
            for (int time = 0; time < queSize; time++) {
                int[] cur = que.poll();

                for (int i = 0; i < 4; i++) {
                    int newR = cur[0] + dx[i];
                    int newC = cur[1] + dy[i];

                    if (newR >= 0 && newC >= 0 && newR < R && newC < C) {
                        if (!isVisited[newR][newC] && map[newR][newC] != '*' && map[newR][newC] != 'X') {
                            isVisited[newR][newC] = true;
                            int[] temp1 = { newR, newC };
                            que.offer(temp1);
                            timeMap[newR][newC] = timeMap[cur[0]][cur[1]] + 1;
                        }
                    }
                }
            }
            if (timeMap[destR][destC] != 0) {
                System.out.println(timeAns);
                System.exit(0);
            }
        }
    }

    public static void floodFill() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    for (int k = 0; k < 4; k++) {
                        int nR = i + dx[k];
                        int nC = j + dy[k];

                        if (nR >= 0 && nC >= 0 && nR < R && nC < C) {
                            if (map[nR][nC] == '.') {
                                map[nR][nC] = '&';
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '&') {
                    map[i][j] = '*';
                }
            }
        }
    }
}