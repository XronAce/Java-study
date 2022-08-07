package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_Q11651 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] coordinate = new int[T][2];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            coordinate[i][0] = Integer.parseInt(st.nextToken());
            coordinate[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinate, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int[] innerArr : coordinate) {
            sb.append(innerArr[0]).append(" ").append(innerArr[1]).append("\n");
        }

        System.out.println(sb);
    }
}

/*
 * 출력 때 StringBuilder를 사용할 경우 시간 단축이 1720ms -> 596ms 정도로 줄어든다!
 */