package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_Q1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (que.size() != 1) {
            for (int i = 0; i < K; i++) {
                if (i != K - 1) {
                    que.add(que.poll());
                } else {
                    sb.append(que.poll()).append(", ");
                }
            }
        }
        sb.append(que.poll());
        sb.append(">");

        System.out.println(sb);
    }
}
