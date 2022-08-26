package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_Q17144 {
    public static int R, C, T;
    public static int[] top, bottom;
    public static int[][] map;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        boolean isChecked = false;
        map = new int[R][C];
        top = new int[2];
        bottom = new int[2];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    top[0] = i;
                    top[1] = j;
                    bottom[0] = i + 1;
                    bottom[1] = j;
                    isChecked = true;
                    break;
                }
            }
            if (isChecked) {
                break;
            }
        }

        for (int i = 0; i < T; i++) {
            spread();
            executeAirCleaner();
            // filter();
        }

        // for (int[] arr : map) {
        // System.out.println(Arrays.toString(arr));
        // }
        // System.out.println();

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans += map[i][j];
            }
        }
        ans += 2;

        System.out.println(ans);
    }

    public static void spread() {
        Queue<int[]> dust = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0) {
                    int[] temp = { i, j, map[i][j] / 5 };
                    dust.offer(temp);
                }
            }
        }

        while (!dust.isEmpty()) {
            int[] curDust = dust.poll();
            int divDustSize = curDust[2];

            for (int i = 0; i < 4; i++) {
                int r = curDust[0] + dx[i];
                int c = curDust[1] + dy[i];

                if (r >= 0 && c >= 0 && r < R && c < C && map[r][c] != -1) {
                    map[r][c] += divDustSize;
                    map[curDust[0]][curDust[1]] -= divDustSize;
                }
            }
        }
    }

    static void executeAirCleaner() {
        // 위쪽 공기청정기는 반시계방향
        int t = top[0];

        for (int x = t - 1; x > 0; x--) {
            map[x][0] = map[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[0][y] = map[0][y + 1];
        }

        for (int x = 0; x < t; x++) {
            map[x][C - 1] = map[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[t][y] = map[t][y - 1];
        }

        map[t][1] = 0;

        // 아래쪽 공기청정기는 시계 방향
        int b = bottom[0];

        for (int x = b + 1; x < R - 1; x++) {
            map[x][0] = map[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[R - 1][y] = map[R - 1][y + 1];
        }

        for (int x = R - 1; x > b; x--) {
            map[x][C - 1] = map[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[b][y] = map[b][y - 1];
        }

        map[b][1] = 0;
    }

    // public static void filter() {
    // // top spin
    // int temp = map[top[0]][C - 1];
    // for (int j = C - 1; j > 0; j--) {
    // map[top[0]][j] = map[top[0]][j - 1];
    // }
    // map[top[0]][1] = 0;
    // int temp1 = map[0][C - 1];
    // for (int i = 0; i < top[0]; i++) {
    // map[i][C - 1] = map[i + 1][C - 1];
    // }
    // map[top[0] - 1][C - 1] = temp;
    // temp = map[0][0];
    // for (int j = 0; j < C - 1; j++) {
    // map[0][j] = map[0][j + 1];
    // }
    // map[0][C - 2] = temp1;
    // for (int i = 0; i < top[0] - 1; i++) {
    // map[i + 1][0] = map[i][0];
    // }
    // map[1][0] = temp;

    // // bottom spin
    // temp = map[bottom[0]][C - 1];
    // for (int j = C - 1; j > 0; j--) {
    // map[bottom[0]][j] = map[bottom[0]][j - 1];
    // }
    // map[bottom[0]][1] = 0;
    // temp1 = map[R - 1][C - 1];
    // for (int i = R - 1; i > bottom[0]; i--) {
    // map[i][C - 1] = map[i - 1][C - 1];
    // }
    // map[bottom[0] + 1][C - 1] = temp;
    // temp = map[R - 1][0];
    // for (int j = 0; j < C - 2; j++) {
    // map[R - 1][j] = map[R - 1][j + 1];
    // }
    // map[R - 1][C - 2] = temp1;
    // for (int i = bottom[0] + 1; i < R - 2; i++) {
    // map[i][0] = map[i + 1][0];
    // }
    // map[R - 2][0] = temp;
    // }
}
