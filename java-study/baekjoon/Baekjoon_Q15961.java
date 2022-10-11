package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] isVisited = new int[d + 1];
        int ans = 0;

        int total = 0;
        for (int i = 0; i < k; i++) {
            if (isVisited[sushi[i]] == 0)
                total++;
            isVisited[sushi[i]]++;
        }
        ans = total;

        for (int i = 1; i < N; i++) {
            if (ans <= total) {
                if (isVisited[c] == 0) {
                    ans = total + 1;
                } else {
                    ans = total;
                }
            }
            //
            isVisited[sushi[i - 1]]--;
            if (isVisited[sushi[i - 1]] == 0)
                total--;

            if (isVisited[sushi[(i + k - 1) % N]] == 0)
                total++;
            isVisited[sushi[(i + k - 1) % N]]++;
        }

        System.out.println(ans);
    }
}
