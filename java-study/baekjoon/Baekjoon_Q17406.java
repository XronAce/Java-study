package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q17406 {
    static int[][] permOfCommands;
    static int idx = 0;

    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
        if (depth == r) {
            int cur = 0;
            for (int num : out) {
                permOfCommands[idx][cur++] = num;
            }
            idx++;
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    static int[][] arrDeepCopy(int[][] arr) {
        int[][] arrcopy = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arrcopy[i][j] = arr[i][j];
            }
        }

        return arrcopy;
    }

    static int arrCal(int[][] arr) {
        int min = 0;
        for (int j = 0; j < arr[0].length; j++) {
            min += arr[0][j];
        }

        for (int i = 1; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }
            min = Math.min(min, sum);
        }

        return min;
    }

    static void cycle(int[][] arr, int r, int c, int s) {
        for (int k = 1; k <= s; k++) {
            int temp = 0;
            int temp1 = 0;

            temp = arr[r - k][c + k];
            for (int j = c + k; j >= c - k + 1; j--) { // 상
                arr[r - k][j] = arr[r - k][j - 1];
            }

            temp1 = arr[r + k][c + k];
            for (int i = r + k; i >= r - k + 1; i--) {
                arr[i][c + k] = arr[i - 1][c + k];
            }
            arr[r - k + 1][c + k] = temp;

            temp = arr[r + k][c - k];
            for (int j = c - k; j <= c + k - 1; j++) {
                arr[r + k][j] = arr[r + k][j + 1];
            }
            arr[r + k][c + k - 1] = temp1;

            for (int i = r - k; i < r + k - 1; i++) {
                arr[i][c - k] = arr[i + 1][c - k];
            }
            arr[r + k - 1][c - k] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] commandIdx = new int[K];
        for (int i = 0; i < K; i++) {
            commandIdx[i] = i;
        }
        permOfCommands = new int[factorial(K)][K];

        permutation(commandIdx, new int[K], new boolean[K], 0, K);

        int[][] arr = new int[N][M];
        int[][] command = new int[K][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            command[i][0] = Integer.parseInt(st.nextToken()) - 1;
            command[i][1] = Integer.parseInt(st.nextToken()) - 1;
            command[i][2] = Integer.parseInt(st.nextToken());
        }

        int min = 9 * N * M;
        int[][] arrcopy;

        for (int i = 0; i < permOfCommands.length; i++) {
            arrcopy = arrDeepCopy(arr);
            for (int j = 0; j < permOfCommands[0].length; j++) {
                cycle(arrcopy, command[permOfCommands[i][j]][0], command[permOfCommands[i][j]][1],
                        command[permOfCommands[i][j]][2]);
            }
            min = Math.min(min, arrCal(arrcopy));
        }

        System.out.println(min);

    }
}
