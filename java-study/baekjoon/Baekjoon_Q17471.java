package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_Q17471 {
    public static int N;
    public static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
    public static int[] population;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 구역의 개수
        N = Integer.parseInt(br.readLine());

        // 각 구역 인구수 저장
        population = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        // 인접리스트 초기화
        for (int i = 0; i <= N; i++) {
            adjlist.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                putEdge(adjlist, i, Integer.parseInt(st.nextToken()));
            }
        }

        // print(adjlist);

        ArrayList<Integer> groupA = new ArrayList<>();
        for (int i = 1; i <= N / 2; i++) {
            comb(1, 0, i, groupA);
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }

    // 인접리스트에 노드 추가
    public static void putEdge(ArrayList<ArrayList<Integer>> adjlist, int x, int y) {
        adjlist.get(x).add(y);
    }

    // public static void print(ArrayList<ArrayList<Integer>> graph) {
    //     for (int i = 1; i < graph.size(); i++) {
    //         ArrayList<Integer> node = graph.get(i);
    //         System.out.print("node" + "[" + i + "] : ");
    //         for (int j = 0; j < node.size(); j++)
    //             System.out.print(node.get(j) + "->");
    //         System.out.println();
    //     }
    // }

    // 조합을 통해 선거구를 2개로 분리
    public static void comb(int start, int depth, int r, ArrayList<Integer> groupA) {
        if (depth == r) {
            popuDiff(groupA);
            return;
        }

        for (int i = start; i <= N; i++) {
            groupA.add(i);
            comb(i + 1, depth + 1, r, groupA);
            groupA.remove(groupA.size() - 1);
        }
    }

    // 두 선거구의 인구수 차이 계산
    public static void popuDiff(ArrayList<Integer> groupA) {
        if (!isConnected(groupA)) {
            return;
        }

        ArrayList<Integer> groupB = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (groupA.contains(i)) {
                continue;
            } else {
                groupB.add(i);
            }
        }

        if (!isConnected(groupB)) {
            return;
        }

        int resultA = 0;
        int resultB = 0;

        for (int i = 0; i < groupA.size(); i++) {
            resultA += population[groupA.get(i)];
        }

        for (int i = 0; i < groupB.size(); i++) {
            resultB += population[groupB.get(i)];
        }

        ans = Math.min(Math.abs(resultA - resultB), ans);
    }

    // 선거구 끼리 연결이 되어있는지 체크
    public static boolean isConnected(ArrayList<Integer> group) {
        boolean[] isVisited = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();
        int count = 1;
        isVisited[group.get(0)] = true;
        que.offer(group.get(0));

        while (!que.isEmpty()) {
            int start = que.poll();

            for (int i : adjlist.get(start)) {
                if (!isVisited[i] && group.contains(i)) {
                    isVisited[i] = true;
                    count++;
                    que.offer(i);
                }
            }
        }

        if (count == group.size()) {
            return true;
        }
        return false;
    }
}

/*
Used DFS at combination
Used BFS at Connection check
Used Adjacent list for graph search
 */