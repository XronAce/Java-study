package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_Q2108 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }

        Arrays.sort(num);

        double avg = 0;
        int median = 0;
        int mode = 9999;
        int diff = 0;

        avg = Math.round((double) sum / N);
        median = num[N / 2];

        int maxCnt = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (N != 1 && i == N - 1 && num[i - 1] == num[i]) {
                maxCnt = Math.max(maxCnt, cnt);
            }
            if (i < N - 1 && num[i] == num[i + 1]) {
                cnt++;
            } else {
                maxCnt = Math.max(maxCnt, cnt);
                cnt = 1;
            }
        }

        cnt = 1;
        int check = 0;
        for (int i = 0; i < N; i++) {
            if (i < N - 1 && num[i] == num[i + 1]) {
                cnt++;
            } else {
                maxCnt = Math.max(maxCnt, cnt);
                cnt = 1;
            }
            if (cnt == maxCnt) {
                check++;
                mode = num[i];
                if (check == 2) {
                    break;
                }
            }
        }

        diff = num[N - 1] - num[0];

        System.out.println((int) avg);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(diff);

    }
}

/*
 * 시간초과 해결한 방법: 이중for문->일중for문으로 바꿈 (시간복잡도 O(n^2) -> O(n))
 */