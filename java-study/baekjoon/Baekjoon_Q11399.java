package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_Q11399 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        int[] add = new int[N];
        add[0] = P[0];
        for (int i = 1; i < N; i++) {
            add[i] = P[i] + add[i - 1];
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += add[i];
        }

        System.out.println(sum);
    }
}
