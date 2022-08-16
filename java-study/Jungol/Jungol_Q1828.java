package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Jungol_Q1828 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] temperature = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            temperature[i][0] = Integer.parseInt(st.nextToken());
            temperature[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(temperature, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }

        });

        int ans = 1;
        int curTemp = temperature[0][1];

        for (int i = 0; i < N - 1; i++) {
            if (curTemp < temperature[i + 1][0]) {
                ans++;
                curTemp = temperature[i + 1][1];
            }
        }

        System.out.println(ans);
    }
}
