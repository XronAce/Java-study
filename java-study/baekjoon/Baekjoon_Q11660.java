package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] num = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] cumulative = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            cumulative[0][i] = 0;
            cumulative[i][0] = 0;
        }

        int partialSum = 0;
        for (int i = 1; i < N + 1; i++) {
            partialSum = partialSum + num[0][i - 1];
            cumulative[1][i] = partialSum;
        }

        partialSum = 0;
        for (int i = 1; i < N + 1; i++) {
            partialSum = partialSum + num[i - 1][0];
            cumulative[i][1] = partialSum;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 2; j < N + 1; j++) {
                if (cumulative[i][j] == 0)
                    cumulative[i][j] = num[i - 1][j - 1] + cumulative[i - 1][j] + cumulative[i][j - 1]
                            - cumulative[i - 1][j - 1];
            }
        }

        for (int test_case = 0; test_case < M; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = cumulative[x2][y2] - cumulative[x1 - 1][y2] - cumulative[x2][y1 - 1] + cumulative[x1 - 1][y1 - 1];
            System.out.println(ans);
        }
    }
}
