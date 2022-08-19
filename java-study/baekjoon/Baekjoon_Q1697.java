package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_Q1697 {
    public static int N, K;
    public static int cnt = 0;
    public static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    public static void bfs(int n) {
        Queue<Integer> que = new LinkedList<>();
        que.add(n);
        check[n] = 1;

        while (!que.isEmpty()) {
            int temp = que.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(check[temp]);
                    return;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    que.add(next);
                    check[next] = check[temp] + 1; // next 까지 도착하기 위해 소모한 최소 시간 기록
                }
            }

        }
    }
}
