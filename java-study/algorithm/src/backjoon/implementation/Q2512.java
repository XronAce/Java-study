package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        int sum = 0;
        int ans = 0;
        for (int i=0; i<N; i++) {
            sum += arr[i];
            ans = Math.max(ans, arr[i]);
        }

        if (M >= sum) {
            System.out.println(ans);
        } else {
            sum = 0;
            ans = M / N;
            while (sum <= M) {
                sum = 0;
                for (int i=0; i<N; i++) {
                    sum += Math.min(arr[i], ans);
                }
                ans++;
            }
            ans -= 2;
            System.out.println(ans);
        }

    }
}
