package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_Q10845 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        int last = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String command = st.nextToken();

            if (command.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                que.add(last);
            } else if (command.equals("pop")) {
                if (que.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(que.poll());
                }
            } else if (command.equals("size")) {
                System.out.println(que.size());
            } else if (command.equals("empty")) {
                if (que.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.equals("front")) {
                if (que.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(que.peek());
                }
            } else if (command.equals("back")) {
                if (que.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(last);
                }
            }
        }
    }
}
