package backjoon.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt;
        int ans = 0;
        Set<Integer> set;
        for (int i=0; i<N; i++) {
            cnt = 0;
            set = new HashSet<>();
            for (int j=i; j<i+k; j++) {
                if (j < N) {
                    set.add(arr[j]);
                } else {
                    set.add(arr[j-N]);
                }
            }

            boolean isCouponUsed = false;

            if (i-1 >= 0) {
                if (arr[i-1] == c) {
                    isCouponUsed = true;
                }
            } else {
                if (arr[N-1] == c) {
                    isCouponUsed = true;
                }
            }

            if (i+k < N) {
                if (arr[i+k] == c) {
                    isCouponUsed = true;
                }
            } else {
                if (arr[i+k-N] == c) {
                    isCouponUsed = true;
                }
            }

            if (set.contains(c)) {
                isCouponUsed = false;
            }

            if (isCouponUsed) {
                cnt++;
            }

            cnt += set.size();
            ans = Math.max(cnt, ans);
        }


        System.out.println(ans);
    }
}
