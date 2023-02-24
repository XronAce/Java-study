package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Q2644 {
    public static int n, a, b, numConn, answer;
    public static int[][] adjMatrix;
    public static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        numConn = Integer.parseInt(br.readLine());
        answer = -1;

        adjMatrix = new int[n+1][n+1];
        isVisited = new boolean[n+1];
        for (int i=0; i<numConn; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            adjMatrix[temp1][temp2] = 1;
            adjMatrix[temp2][temp1] = 1;
        }
        dfs(a, 0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int a, int depth) {
        isVisited[a] = true;

        if (a == b) {
            answer = depth;
            return;
        }

        for (int i=1; i<=n; i++) {
            if (adjMatrix[a][i] == 1 && !isVisited[i]) {
                isVisited[i] = true;
                dfs(i, depth+1);
                isVisited[i] = false;
            }
        }
    }
}
