package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q16926 {
    static void cycle(int[][] arr, int startr, int startc, int N, int M) {
        int endr = N - startr - 1;
        int endc = M - startc - 1;
        int temp = arr[startr][startc];
        for (int j = startc; j <= endc - 1; j++) {
            arr[startr][j] = arr[startr][j + 1];
        }
        for (int i = startr; i <= endr - 1; i++) {
            arr[i][endc] = arr[i + 1][endc];
        }
        for (int j = endc; j > startc; j--) {
            arr[endr][j] = arr[endr][j - 1];
        }
        for (int i = endr; i > startr; i--) {
            arr[i][startc] = arr[i - 1][startc];
        }
        arr[startr + 1][startc] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int r = 0, c = 0; // starting point's position
        int cycleCnt = 0;
        int cnt = 0;

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (cycleCnt != R * (Math.min(N, M) / 2)) {
            cycle(arr, r, c, N, M);
            cnt++;
            cycleCnt++;
            if (cnt == R) {
                cnt = 0;
                r++;
                c++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int[] innerArr : arr) {
            for (int i = 0; i < M; i++) {
                sb.append(innerArr[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
