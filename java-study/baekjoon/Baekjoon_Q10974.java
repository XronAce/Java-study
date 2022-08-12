package baekjoon;

import java.util.Scanner;

public class Baekjoon_Q10974 {
    static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
        if (depth == r) {
            for (int e : out) {
                System.out.print(e + " ");
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // out[depth] =
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = i;
        }

        permutation(arr, new int[N], new boolean[N], 0, N);

        sc.close();
    }
}
