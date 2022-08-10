package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Baekjoon_Q2003 {
    static int Cnt = 0;

    public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
            // Change code to get required output at here.
            int[] a = new int[r];
            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i])
                    a[idx++] = arr[i];
            }
            // if ()
            System.out.println();

            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num = new int[N];
        int[] idxarr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            idxarr[i] = i;
        }

        System.out.println(Cnt);
    }
}