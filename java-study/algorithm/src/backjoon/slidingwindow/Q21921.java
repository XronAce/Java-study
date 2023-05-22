package backjoon.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int stIdx = 0;
        int endIdx = X-1;
        int ans;
        int cnt = 1;
        int sum = 0;
        for (int i=stIdx; i<=endIdx; i++) {
            sum += arr[i];
        }
        ans = sum;

        while (endIdx < N-1) {
            sum -= arr[stIdx];
            stIdx++;
            endIdx++;
            sum += arr[endIdx];
            if (ans == sum) {
                cnt++;
            } else if (ans < sum) {
                cnt = 1;
            }
            ans = Math.max(sum, ans);
        }

        if (ans == 0) {
            System.out.print("SAD");
        } else {
            System.out.println(ans);
            System.out.println(cnt);
        }
    }
}
