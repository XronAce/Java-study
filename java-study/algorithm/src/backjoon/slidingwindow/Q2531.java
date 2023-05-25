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

        int ans;

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int stIdx = 0;
        int endIdx = stIdx + k - 1;
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i=stIdx; i<=endIdx; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        int cnt = hm.size();

        if (!hm.containsKey(c)) {
            cnt++;
        }

        ans = cnt;

        int temp = 1;
        while (temp != N) {
            temp++;
            hm.put(arr[stIdx], hm.get(arr[stIdx])-1);
            if (hm.get(arr[stIdx]) == 0) {
                hm.remove(arr[stIdx]);
            }
            stIdx++;
            endIdx++;
            if (endIdx >= N) {
                endIdx -= N;
            }

            if (hm.containsKey(arr[endIdx])) {
                hm.put(arr[endIdx], hm.get(arr[endIdx])+1);
            } else {
                hm.put(arr[endIdx], 1);
            }

            cnt = hm.size();

            if (!hm.containsKey(c)) {
                cnt++;
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
