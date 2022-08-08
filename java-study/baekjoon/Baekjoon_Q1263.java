package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_Q1263 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }

        });

        int start = time[0][1] - time[0][0];

        for (int i = 1; i < N; i++) {
            if (start > time[i][1]) {
                start = time[i][1];
            }
            start -= time[i][0];
        }

        if (start > 0) {
            System.out.println(start);
        } else {
            System.out.println(-1);
        }
    }
}
