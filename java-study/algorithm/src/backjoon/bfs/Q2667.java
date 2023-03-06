package backjoon.bfs;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Q2667 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static int N;
    public static int[][] map;
    public static boolean[][] isVisited;
    public static LinkedList<Integer> houseCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        houseCnt = new LinkedList<>();
        String s;

        for (int i=0; i<N; i++) {
            s = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(houseCnt);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(houseCnt.size()+"\n");
        for (int i=0; i<houseCnt.size(); i++) {
            bw.write(houseCnt.get(i)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int r, int c) {
        isVisited[r][c] = true;
        int[] temp = new int[2];
        temp[0] = r;
        temp[1] = c;
        Queue<int[]> que = new LinkedList<>();
        que.offer(temp);
        int cnt = 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i=0; i<4; i++) {
                int newR = cur[0] + dx[i];
                int newC = cur[1] + dy[i];
                if (newR < N && newC < N && newR >= 0 && newC >= 0) {
                    if(map[newR][newC] == 1 && !isVisited[newR][newC]) {
                        int[] newPair = new int[2];
                        newPair[0] = newR;
                        newPair[1] = newC;
                        que.offer(newPair);
                        isVisited[newR][newC] = true;
                        cnt++;
                    }
                }
            }
        }
        houseCnt.add(cnt);
    }
}
