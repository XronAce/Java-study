package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Baekjoon_Q1149 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N+1][3];
        StringTokenizer st;
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            cost[i][0] = Math.min(cost[i - 1][1], cost[i - 1][2]) + red;
            cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][2]) + green;
            cost[i][2] = Math.min(cost[i - 1][0], cost[i - 1][1]) + blue;
        }

        System.out.println(Math.min(cost[N][0], Math.min(cost[N][1], cost[N][2])));


    }
}