package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class SWEA_Q7465 {
    public static int[][] adjMatrix;
    public static int N, M, ans;
    public static int[] whoIsTheRep;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            adjMatrix = new int[N + 1][N + 1];
            whoIsTheRep = new int[N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjMatrix[b][a] = 1;
                adjMatrix[a][b] = 1;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (adjMatrix[i][j] == 1) {
                        if (whoIsTheRep[i] == 0) {
                            whoIsTheRep[i] = i;
                        }
                        if (whoIsTheRep[j] == 0) {
                            whoIsTheRep[j] = whoIsTheRep[i];
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(whoIsTheRep));
            for (int i = 1; i <= N; i++) {
                if (whoIsTheRep[i] == 0) {
                    whoIsTheRep[i] = i;
                }
            }

            boolean[] isRep = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (!isRep[whoIsTheRep[i]]) {
                    isRep[whoIsTheRep[i]] = true;
                }
            }
            System.out.println(Arrays.toString(isRep));
            ans = 0;
            for (int i = 1; i <= N; i++) {
                if (isRep[i]) {
                    ans++;
                }
            }

            System.out.println("#" + test_case + " " + ans);
        }

    }
}