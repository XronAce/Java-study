package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // Number of ranks that have already been on chart
        int S = Integer.parseInt(st.nextToken()); // Taesu's new score
        int P = Integer.parseInt(st.nextToken()); // Number of ranks that can be listed
        int ans = 0;

        if (N != 0) {
            st = new StringTokenizer(br.readLine(), " ");
        }
        Integer[] rank = new Integer[P];

        for (int i=0; i<N; i++) {
            rank[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<P; i++) {
            if (rank[i] == null) {
                rank[i] = -1;
            }
        }

        if (rank[P-1] >= S) {
            ans = -1;
        } else {
            rank[P-1] = S;

            Arrays.sort(rank, Collections.reverseOrder());

            for (int i=0; i<P; i++) {
                if (rank[i] == S) {
                    ans = i+1;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
