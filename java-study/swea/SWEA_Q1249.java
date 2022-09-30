package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_Q1249 {
    public static int[] dx = { 1, -1, 0, 0 };
    public static int[] dy = { 0, 0, 1, -1 };
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            String s;

            for (int i = 0; i < N; i++) {
                s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        
    }
}
