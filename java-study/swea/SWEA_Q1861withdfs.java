package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q1861withdfs {
    public static int N, ans, num;
    public static int[][] room;
    public static boolean[][] visited;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int[] store;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case < T + 1; test_case++) {
            N = Integer.parseInt(br.readLine());
            room = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (N == 1) {
                System.out.println("#" + test_case + " " + room[0][0] + " " + 1);
                continue;
            }

            store = new int[N * N + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    traverse(i, j, room[i][j], room[i][j], 0);
                }
            }

            for (int i = 1; i < store.length; i++) {
                if (store[i] == ans) {
                    num = i;
                    break;
                }
            }

            System.out.println("#" + test_case + " " + num + " " + ans);
            num = 0;
            ans = 0;

        }
    }

    public static void traverse(int r, int c, int startingNum, int numBefore, int count) {
        if (count != 0 && room[r][c] - 1 != numBefore) {
            ans = Math.max(ans, count);
            if (ans == count) {
                store[startingNum] = count;
            }
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int newR = r + dx[i];
                int newC = c + dy[i];

                if (newR >= 0 && newC >= 0 && newR < N && newC < N) {
                    traverse(newR, newC, startingNum, room[r][c], count + 1);
                }
            }
        }
    }
}
