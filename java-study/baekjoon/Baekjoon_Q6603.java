package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q6603 {
    static StringBuilder sb;

    public static void combination(int[] arr, boolean[] isSelected, int cnt, int start) {
        if (cnt == 6) {
            for (int i = 0; i < arr.length; i++) {
                if (isSelected[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        for (int i = start; i < arr.length; i++) {
            isSelected[i] = true;
            combination(arr, isSelected, cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }

            int[] S = new int[N];
            for (int i = 0; i < N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            combination(S, new boolean[N], 0, 0);

            System.out.println(sb);
        }

    }

}
