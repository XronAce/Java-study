package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_Q13023 {
    public static int N, M, ans;
    public static ArrayList<ArrayList<Integer>> listGraph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (M < 4) {
            System.out.println(0);
            return;
        }

        listGraph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            listGraph.add(new ArrayList<>());
        }
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            putEdge(listGraph, a, b);
        }

        for (int i = 0; i < N; i++) {
            dfs(0, i);
        }

        System.out.println(0);
    }

    public static void putEdge(ArrayList<ArrayList<Integer>> listGraph, int x, int y) {
        listGraph.get(x).add(y);
        listGraph.get(y).add(x);
    }

    public static void print(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            ArrayList<Integer> node = graph.get(i);
            System.out.print("node" + "[" + i + "] : ");
            for (int j = 0; j < node.size(); j++)
                System.out.print(node.get(j) + " ");
            System.out.println();
        }
    }

    public static void dfs(int cnt, int start) {
        if (cnt == 4) {
            System.out.println(1);
            System.exit(0);
        }

        visited[start] = true;
        ArrayList<Integer> node = listGraph.get(start);
        for (int i = 0; i < node.size(); i++) {
            if (!visited[node.get(i)]) {
                dfs(cnt + 1, node.get(i));
            }
        }
        visited[start] = false;
    }
}
