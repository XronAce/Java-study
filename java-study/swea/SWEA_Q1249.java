package swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_Q1249 {
    public static int[] dx = { 1, -1, 0, 0 };
    public static int[] dy = { 0, 0, 1, -1 };
    public static int[][] map;
    public static int N;
    public static int[][] ans;
    public static boolean[][] visited;
    public static int min;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            String s;

            for (int i = 0; i < N; i++) {
                s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            ans = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            }
            ans[0][0] = 0;
            
            min = Integer.MAX_VALUE;
            visited = new boolean[N][N];
    
            bfs(0, 0);
            System.out.println("#"+test_case+" "+min);
        }

    }

    public static void bfs(int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        
        int[] start = {r, c};
        que.offer(start);
        visited[r][c] = true;
        while (!que.isEmpty()) {
            int[] temp = que.poll();

            if (temp[0] == N - 1 && temp[1] == N - 1) {
                min = min > ans[N - 1][N - 1] ? ans[N - 1][N - 1] : min;
            }

            if (min <= ans[temp[0]][temp[1]]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newR = temp[0] + dx[i];
                int newC = temp[1] + dy[i];

                if (newR >= 0 && newR < N && newC >= 0 && newC < N) {
                    if (!visited[newR][newC] || ans[newR][newC] > ans[temp[0]][temp[1]] + map[newR][newC]) {
                        visited[newR][newC] = true;
                        ans[newR][newC] = ans[temp[0]][temp[1]] + map[newR][newC];
                        int[] temp1 = new int[2];
                        temp1[0] = newR;
                        temp1[1] = newC;
                        que.offer(temp1);
                    }
                }
            }

        }
    }
}
