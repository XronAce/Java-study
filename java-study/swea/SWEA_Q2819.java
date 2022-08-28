package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_Q2819 {
    public static int[][] grid;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int[] out;
    public static StringBuilder sb;
    public static List<String> numbers;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < T + 1; test_case++) {
            grid = new int[4][4];
            StringTokenizer st;
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            numbers = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    out = new int[7];
                    out[0] = grid[i][j];
                    dfs(i, j, 1, out);
                }
            }

            Collections.sort(numbers);
            List<String> remDupl = new ArrayList<>();
            int idx = 0;

            while (idx != numbers.size() - 1) {
                String temp = numbers.get(idx);
                if (numbers.get(idx + 1).equals(temp)) {
                    idx++;
                } else {
                    remDupl.add(temp);
                    idx++;
                }
            }

            System.out.println("#" + test_case + " " + (remDupl.size() + 1));
        }

    }

    public static void dfs(int r, int c, int cnt, int[] out) {
        if (cnt == 7) {
            sb = new StringBuilder();
            for (int i = 0; i < 7; i++) {
                sb.append(out[i]);
            }
            numbers.add(sb.toString());
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newR = r + dx[i];
            int newC = c + dy[i];
            if (newR >= 0 && newC >= 0 && newR < 4 && newC < 4) {
                out[cnt] = grid[newR][newC];
                dfs(newR, newC, cnt + 1, out);
            }
        }
    }
}
