package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_Q5643 {
    public static int N, M;
    public static int tallerCnt, smallerCnt;
    public static int[][] comparison;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            comparison = new int[N+1][N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                comparison[a][b] = 1;
            }

            int ans = 0;

            for (int i = 1; i <= N; i++) {
                tallerCnt = 0;
                smallerCnt = 0;
                tallerCheck(i);
                smallerCheck(i);
                if (smallerCnt + tallerCnt == N - 1) {
                    ans++;
                }
            }

            System.out.println("#"+test_case+" "+ans);
        }
    }

    private static void tallerCheck(int thanWho) {
        boolean[] isVisited = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();
        que.offer(thanWho);
        isVisited[thanWho] = true;
        
        while (!que.isEmpty()) {
            int temp = que.poll();
            for (int j = 1; j <= N; j++) {
                if (!isVisited[j] && comparison[temp][j] == 1) {
                    isVisited[j] = true;
                    que.offer(j);
                    tallerCnt++;
                }
            }
        }
    }

    private static void smallerCheck(int thanWho) {
        boolean[] isVisited = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();
        que.offer(thanWho);
        isVisited[thanWho] = true;

        while (!que.isEmpty()) {
            int temp = que.poll();
            for (int i = 1; i <= N; i++) {
                if (!isVisited[i] && comparison[i][temp] == 1) {
                    isVisited[i] = true;
                    que.offer(i);
                    smallerCnt++;
                }
            }
        }
    }
    

}
