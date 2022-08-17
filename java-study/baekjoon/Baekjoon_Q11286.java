package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon_Q11286 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }

        });
        int command;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            command = Integer.parseInt(br.readLine());
            if (command != 0) {
                que.add(command);
            } else {
                if (que.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(que.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
