package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int a, b, w;

    public Node(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }
}

public class SWEA_Q3124 {
    public static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");

            }
        }

    }
}
