package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q16935 {
    static int[][] arrDeepCopy(int[][] arr, int N, int M) {
        int[][] arrcopy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrcopy[i][j] = arr[i][j];
            }
        }

        return arrcopy;
    }

    static void command1(int[][] arr, int N, int M) {
        int temp;
        for (int j = 0; j < M; j++) {
            for (int i = 0; i <= (N - 1) / 2; i++) {
                temp = arr[i][j];
                arr[i][j] = arr[N - 1 - i][j];
                arr[N - 1 - i][j] = temp;
            }
        }
    }

    static void command2(int[][] arr, int N, int M) {
        int temp;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= (M - 1) / 2; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[i][M - 1 - j];
                arr[i][M - 1 - j] = temp;
            }
        }
    }

    static int[][] command3(int[][] arr, int N, int M) {
        int[][] arrtemp = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrtemp[j][N - 1 - i] = arr[i][j];
            }
        }

        return arrtemp;
    }

    static int[][] command4(int[][] arr, int N, int M) {
        int[][] arrtemp = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrtemp[M - 1 - j][i] = arr[i][j];
            }
        }

        return arrtemp;
    }

    static void command5(int[][] arr, int[][] arrcopy, int N, int M) {
        // fill first quarter
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                arr[i][j] = arrcopy[N / 2 + i][j];
            }
        }
        // fill second quarter
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                arr[i][j] = arrcopy[i][j - M / 2];
            }
        }
        // fill third quarter
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                arr[i][j] = arrcopy[i - N / 2][j];
            }
        }
        // fill fourth quarter
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                arr[i][j] = arrcopy[i][j + M / 2];
            }
        }
    }

    static void command6(int[][] arr, int[][] arrcopy, int N, int M) {
        // fill first quarter
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                arr[i][j] = arrcopy[i][j + M / 2];
            }
        }
        // fill second quarter
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                arr[i][j] = arrcopy[i + N / 2][j];
            }
        }
        // fill third quarter
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                arr[i][j] = arrcopy[i][j - M / 2];
            }
        }
        // fill fourth quarter
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                arr[i][j] = arrcopy[i - N / 2][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] arrcopy;
        int[] command = new int[R];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < R; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        // command goes here
        for (int i = 0; i < R; i++) {
            if (command[i] == 1) {
                command1(arr, N, M);
            } else if (command[i] == 2) {
                command2(arr, N, M);
            } else if (command[i] == 3) {
                arr = command3(arr, N, M);
                N = arr.length;
                M = arr[0].length;
            } else if (command[i] == 4) {
                arr = command4(arr, N, M);
                N = arr.length;
                M = arr[0].length;
            } else if (command[i] == 5) {
                arrcopy = arrDeepCopy(arr, N, M);
                command5(arr, arrcopy, N, M);
            } else {
                arrcopy = arrDeepCopy(arr, N, M);
                command6(arr, arrcopy, N, M);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] innerArr : arr) {
            for (int i = 0; i < innerArr.length; i++) {
                sb.append(innerArr[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
