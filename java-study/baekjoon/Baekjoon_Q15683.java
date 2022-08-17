package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_Q15683 {
    public static int[][] arrDeepCopy(int[][] arr) {
        int[][] arrcopy = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arrcopy[i][j] = arr[i][j];
            }
        }
        return arrcopy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] temp = new int[N][M];
        int r, c;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 5 처리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 5) {
                    r = i;
                    c = j;
                    while (r - 1 >= 0) {
                        r--;
                        if (map[r][c] == 6) {
                            break;
                        } else if (map[r][c] == 0) {
                            map[r][c] = 7;
                        }
                    }
                    r = i;
                    c = j;
                    while (r + 1 < N) {
                        r++;
                        if (map[r][c] == 6) {
                            break;
                        } else if (map[r][c] == 0) {
                            map[r][c] = 7;
                        }
                    }
                    r = i;
                    c = j;
                    while (c - 1 >= 0) {
                        c--;
                        if (map[r][c] == 6) {
                            break;
                        } else if (map[r][c] == 0) {
                            map[r][c] = 7;
                        }
                    }
                    r = i;
                    c = j;
                    while (c + 1 < N) {
                        c++;
                        if (map[r][c] == 6) {
                            break;
                        } else if (map[r][c] == 0) {
                            map[r][c] = 7;
                        }
                    }
                }
            }
        }

        temp = arrDeepCopy(map);

        for (int[] innerArr : temp) {
            System.out.println(Arrays.toString(innerArr));
        }

    }
}
