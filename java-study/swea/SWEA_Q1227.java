package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_Q1227 {
    public static int startR, startC, endR, endC, ans;
    public static int[][] map;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        map = new int[100][100];
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < 100; i++) {
                s = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = s.charAt(j) - '0';
                    if (map[i][j] == 2) {
                        startR = i;
                        startC = j;
                    } else if (map[i][j] == 3) {
                        endR = i;
                        endC = j;
                    }
                }
            }

            dfs(startR, startC);
            System.out.println("#" + N + " " + ans);
            ans = 0;

        }
    }

    public static void dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];
            if (map[nextR][nextC] == 3) {
                ans = 1;
            }
            if (map[nextR][nextC] == 0) {
                map[r][c] = 1;
                dfs(nextR, nextC);
            }
        }
    }
}
