package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        int mid = 0;
        int min = 0;
        long result = 0;

        while (min < max) {
            result = 0;
            mid = (max + min) / 2;
            for (int i = 0; i < N; i++) {
                if (tree[i] > mid)
                    result += tree[i] - mid;
            }

            if (result < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);

    }
}
