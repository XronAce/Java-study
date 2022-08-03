package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cables = new int[K];
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
        }

        long mid = 0;
        long max = cables[0];
        long min = 0;
        for (int i = 0; i < K; i++) {
            max = Math.max(max, cables[i]);
        }
        max++;

        while (min < max) {
            mid = (min + max) / 2;
            long count = 0;
            for (int i = 0; i < K; i++) {
                count += cables[i] / mid;
            }
            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}

/*
 * 짚고 넘어갈 내용
 * 1. 주어진 변수의 범위에 맞게 오버플로우가 되지 않도록 변수 지정을 long으로 해야만 한다. int로 할때 fail뜸!
 * 2. 탐색 범위를 이분탐색으로 변경해서 시간초과를 해결 했음. 이분탐색 알고리즘<<
 */