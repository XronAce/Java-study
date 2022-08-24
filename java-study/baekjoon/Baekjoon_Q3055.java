package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int r, c;

    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Baekjoon_Q3055 {
    public static int R, C, ans;
    public static char[][] map;
    public static int startR, startC, destR, destC;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static boolean[][] isVisited;
    public static int[][] intMap;
    public static Queue<Position> move;
    public static boolean isDone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        intMap = new int[R][C];
        isVisited = new boolean[R][C];
        move = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                } else if (map[i][j] == 'D') {
                    destR = i;
                    destC = j;
                }
            }
        }
        Position start = new Position(startR, startC);

        floodFill();
        bfs(start);

        while (!move.isEmpty()) {
            floodFill();
            bfs(move.poll());
        }

        if (intMap[destR][destC] != 0) {
            System.out.println(intMap[destR][destC]);
        } else {
            System.out.println("KAKTUS");
        }

    }

    public static void bfs(Position start) {
        isVisited[start.r][start.c] = true;
        for (int i = 0; i < 4; i++) {
            int newR = start.r + dx[i];
            int newC = start.c + dy[i];

            if (newR >= 0 && newC >= 0 && newR < R && newC < C) {
                if (map[newR][newC] != '*' && map[newR][newC] != 'X' && !isVisited[newR][newC]) {
                    Position temp = new Position(newR, newC);
                    move.offer(temp);
                    isVisited[newR][newC] = true;
                    intMap[newR][newC] = intMap[start.r][start.c] + 1;
                    map[newR][newC] = '@';
                }
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
