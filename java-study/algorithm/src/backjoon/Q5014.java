package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014 {
    public static int F, S, G, U, D, answer;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        answer = -1;

        isVisited = new boolean[F+1];

        bfs(S);

        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }

    public static void bfs(int floor) {
        isVisited[floor] = true;
        Queue<Integer> que = new LinkedList<>();
        que.offer(floor);

        int size;
        while (!que.isEmpty()) {
            answer++;
            size = que.size();

            for (int i=0; i<size; i++) {
                int curFloor = que.poll();

                if (curFloor == G) {
                    return;
                }

                if (curFloor + U <= F && !isVisited[curFloor + U]) {
                    que.offer(curFloor + U);
                    isVisited[curFloor + U] = true;
                }

                if (curFloor - D >= 1 && !isVisited[curFloor - D]) {
                    que.offer(curFloor - D);
                    isVisited[curFloor - D] = true;
                }
            }
        }
        answer = -1;
    }
}
