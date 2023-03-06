import java.io.*;
import java.util.StringTokenizer;

public class Q1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int ans;
        StringTokenizer st;

        for (int test_case=0; test_case<T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            ans = 1;
            int[] ppl = new int[N+1];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                ppl[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int standard = ppl[1];

            for (int i=2; i<=N; i++) {
                if (ppl[i] < standard) {
                    standard = ppl[i];
                    ans++;
                }
            }

            bw.write((ans)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
