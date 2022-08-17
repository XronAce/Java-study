package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q1992 {
    public static int[][] arr;
    public static StringBuilder sb = new StringBuilder();

    public static boolean isOkayToCompress(int r, int c, int size) {
        int k = arr[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void QuadTree(int r, int c, int size) {
        if (isOkayToCompress(r, c, size)) {
            sb.append(arr[r][c]);
            return;
        }

        int newSize = size / 2;
        sb.append('(');

        QuadTree(r, c, newSize); // leftup
        QuadTree(r, c + newSize, newSize); // rightup
        QuadTree(r + newSize, c, newSize); // leftdown
        QuadTree(r + newSize, c + newSize, newSize); // rightdown

        sb.append(')');
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s;

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        QuadTree(0, 0, N);

        System.out.println(sb);
    }
}
