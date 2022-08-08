package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q9229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < TC + 1; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (a[i] + a[j] <= M) {
                        answer = Math.max(answer, a[i] + a[j]);
                    }
                }
            }

            if (answer == 0)
                System.out.println("#" + test_case + " " + -1);
            else
                System.out.println("#" + test_case + " " + answer);
        }
    }
}

/*
 * Simple combination using double for loops (O(n^2))
 */