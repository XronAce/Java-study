package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Baekjoon_Q2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = num[i];
            if (sum == M) {
                cnt++;
                continue;
            }
            for (int j = i + 1; j < N; j++) {
                sum += num[j];
                if (sum == M) {
                    cnt++;
                    break;
                } else if (sum > M) {
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}