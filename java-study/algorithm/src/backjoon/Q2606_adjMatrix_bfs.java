package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2606_adjMatrix_bfs {
    public static int numCom, numConn, answer;
    public static boolean[][] isConnected;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numCom = Integer.parseInt(br.readLine());
        numConn = Integer.parseInt(br.readLine());
        answer = 0;
        StringTokenizer st;

        isConnected = new boolean[numCom+1][numCom+1];
        isVisited = new boolean[numCom+1];
        for (int i=0; i<numConn; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            isConnected[com1][com2] = true;
            isConnected[com2][com1] = true;
        }
        bfs(1);
        System.out.println(answer);
    }

    public static void bfs(int curCom) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(curCom);
        isVisited[curCom] = true;

        while(!que.isEmpty()) {
            int temp = que.poll();
            for (int i=1; i<=numCom; i++) {
                if (isConnected[temp][i] && !isVisited[i]) {
                    que.offer(i);
                    isVisited[i] = true;
                    answer++;
                }
            }
        }
    }
}
