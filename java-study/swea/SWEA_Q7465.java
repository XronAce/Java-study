package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class SWEA_Q7465 {
    public static int N, M;
    public static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            int ans = 0;
            for (int i = 1; i < N + 1; i++) {
                if (parent[i] == i) {
                    ans++;
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }

    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }
}