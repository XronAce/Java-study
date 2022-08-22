package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_Q1238 {
    public static int N, start, from, to;
    public static boolean[] visited;
    public static int[][] adjmatrix;
    public static Queue<Integer> que;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {
            sb = new StringBuilder();
            adjmatrix = new int[101][101];
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N / 2; i++) {
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                adjmatrix[from][to] = 1;
            }

            visited = new boolean[101];
            que = new LinkedList<>();

            sb.append("#" + test_case).append(" ");
            bfs(start);
            System.out.println(sb);

        }
    }

    public static void bfs(int num) {
        que.add(num);
        visited[num] = true;
        int maxNum = 0;
        List<Integer> res = new ArrayList<>();

        while (!que.isEmpty()) {
            int queSize = que.size();
            maxNum = 0;

            for (int i = 0; i < queSize; i++) {
                int temp = que.poll();
                for (int j = 1; j < 101; j++) {
                    if (adjmatrix[temp][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        que.add(j);
                        maxNum = Math.max(maxNum, j);
                    }
                }
            }
            res.add(maxNum);
        }

        // for(int i=0; i<res.size(); i++) {
        // System.out.println(res.get(i));
        // }
        sb.append(res.get(res.size() - 2));
    }
}
