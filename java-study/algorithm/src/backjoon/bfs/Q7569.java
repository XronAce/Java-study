package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7569 {
    public static int M, N, H, ans;
    public static int[] dx = {0, 0, 1, -1, 0, 0};
    public static int[] dy = {0, 0, 0, 0, 1, -1};
    public static int[] dz = {1, -1, 0, 0, 0, 0};
    public static int[][][] tomatoes;
    public static boolean[][][] isVisited;
    public static Queue<int[]> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        que = new LinkedList<>();
        int h = 0;

        tomatoes = new int[N][M][H];
        isVisited = new boolean[N][M][H];
        while (h != H) {
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j=0; j<M; j++) {
                    tomatoes[i][j][h] = Integer.parseInt(st.nextToken());
                }
            }
            h++;
        }

        boolean hasUnriped = false;
        for (int k=0; k<H; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (tomatoes[i][j][k] == 0) {
                        hasUnriped = true;
                        break;
                    }
                }
            }
        }

        if (!hasUnriped) {
            System.out.println(0);
        } else {
            bfs();

            int max = 0;
            for (int k=0; k<H; k++) {
                for (int i=0; i<N; i++) {
                    for (int j=0; j<M; j++) {
                        max = Math.max(max, tomatoes[i][j][k]);
                    }
                }
            }
            ans = max - 1;

            // 익지 않은 토마토가 있을 경우
            for (int k=0; k<H; k++) {
                for (int i=0; i<N; i++) {
                    for (int j=0; j<M; j++) {
                        if (tomatoes[i][j][k] == 0) {
                            ans = -1;
                            break;
                        }
                    }
                }
            }
            System.out.println(ans);
        }



    }

    public static void bfs() {
        for (int k=0; k<H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomatoes[i][j][k] == 1) {
                        int[] temp = {i, j, k};
                        que.offer(temp);
                        isVisited[i][j][k] = true;
                    }
                }
            }
        }

        while (!que.isEmpty()) {
            int[] temp1 = que.poll();
            int newR, newC, newH;
            for (int i=0; i<6; i++) {
                newR = temp1[0] + dx[i];
                newC = temp1[1] + dy[i];
                newH = temp1[2] + dz[i];
                if (newR >= 0 && newC >=0 && newH >=0 && newR < N && newC < M && newH < H) {
                    if (tomatoes[newR][newC][newH] == 0 && !isVisited[newR][newC][newH]) {
                        isVisited[newR][newC][newH] = true;
                        int[] temp2 = {newR, newC, newH};
                        tomatoes[newR][newC][newH] = tomatoes[temp1[0]][temp1[1]][temp1[2]] + 1;
                        que.offer(temp2);
                    }
                }
            }
        }
    }
}
