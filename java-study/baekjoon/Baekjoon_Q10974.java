package baekjoon;

import java.util.Scanner;

public class Baekjoon_Q10974 {
    static StringBuilder sb = new StringBuilder();

    public static void permutation(int[] arr, int[] out, boolean[] isSelected, int cnt, int r) {
        if (cnt == r) {
            for (int e : out) {
                sb.append(e + " ");
            }
            sb.append("\n");
        }
        for (int i = 0; i < arr.length; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                out[cnt] = arr[i];
                permutation(arr, out, isSelected, cnt + 1, r);
                isSelected[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 1; i < N + 1; i++) {
            arr[i - 1] = i;
        }
        permutation(arr, new int[N], new boolean[N], 0, N);

        System.out.print(sb);
        sc.close();
    }
}

/*
 * Permutation.
 * using stringbuilder decreased runtime from 2380ms to 280ms.
 * passing r rather than arr.length fixed timeout issue.
 */