package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] num = new int[N + 1];
        int n = 0;
        num[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            n = Integer.parseInt(st.nextToken());
            num[i] = num[i - 1] + n;
        }

        for (int test_case = 0; test_case < M; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int sum = num[end] - num[start - 1];

            System.out.println(sum);
        }
    }
}
