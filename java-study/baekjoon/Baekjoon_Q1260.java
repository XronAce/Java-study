package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_Q1260 {
    public static int[][] adjmatrix;
    public static boolean[] visited;
    public static int[] dfsRoute;
    public static int[] bfsRoute;
    public static int idx = 0;
    public static int N, M, V;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjmatrix = new int[N + 1][N + 1];
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjmatrix[a][b] = 1;
            adjmatrix[b][a] = 1;
        }

        visited = new boolean[N + 1];

        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        idx = 0;

        bfs(V);
        System.out.print(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");
        for (int i = 1; i < N + 1; i++) {
            if (adjmatrix[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int before = que.poll();
            sb.append(before).append(" ");

            for (int i = 1; i < N + 1; i++) {
                if (adjmatrix[before][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
