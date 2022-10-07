package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_Q5643 {
    public static List<Integer> smaller = new ArrayList<>();
    public static List<Integer> taller = new ArrayList<>();
    public static int N, M;
    public static int[][] comparison;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            comparison = new int[M][2];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                comparison[i][0] = Integer.parseInt(st.nextToken());
                comparison[i][1] = Integer.parseInt(st.nextToken());
            }
            // 입력 처리 완료
            int checkCnt = 0;
            int ans = 0;

            // smallerCheck(1);
            // tallerCheck(1);
            // System.out.println(smaller.toString());
            // System.out.println(taller.toString());
            
            for (int i = 1; i <= N; i++) {
                smallerCheck(i);
                tallerCheck(i);
                checkCnt += smaller.size() + taller.size();
                if (checkCnt == N - 1) {
                    ans++;
                }
                smaller.clear();
                taller.clear();
                checkCnt = 0;
            }

            System.out.println("#"+test_case+" "+ans);
        }
    }
    
    public static void smallerCheck(int thanWho) {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (comparison[i][1] == thanWho) {
                cnt++;
                if (!smaller.contains(comparison[i][0])) {
                    smaller.add(comparison[i][0]);
                }
                smallerCheck(comparison[i][0]);
            }
        }
        if (cnt == 0) {
            return;
        }
    }

    public static void tallerCheck(int thanWho) {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (comparison[i][0] == thanWho) {
                cnt++;
                if (!taller.contains(comparison[i][1])) {
                    taller.add(comparison[i][1]);
                }
                tallerCheck(comparison[i][1]);
            }
        }
        if (cnt == 0) {
            return;
        }
    }
}
