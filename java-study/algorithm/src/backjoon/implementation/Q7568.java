package backjoon.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class Q7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int weight, height;
        int[][] bodySize = new int[N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weight = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            bodySize[i][0] = weight;
            bodySize[i][1] = height;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int rank;
        for (int i=0; i<N; i++) {
            rank = 1;
            for (int j=0; j<N; j++) {
                if (i == j) {
                    continue;
                }

                if (bodySize[i][0] < bodySize[j][0] && bodySize[i][1] < bodySize[j][1]) {
                    rank++;
                }
            }
            bw.write(rank + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
