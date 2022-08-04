package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_Q1966 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int targetIdx = Integer.parseInt(st.nextToken());
            int printDoneCnt = 0;

            st = new StringTokenizer(br.readLine(), " ");
            Queue<Integer> printList = new LinkedList<>();
            int[] importance = new int[N];
            int maxImp = 0;
            for (int i = 0; i < N; i++) {
                importance[i] = Integer.parseInt(st.nextToken());
                printList.add(i);
                maxImp = Math.max(maxImp, importance[i]);
            }

            int testCnt = 0;
            while (printDoneCnt != N) {
                Boolean isHighestPriority = true;
                int currentIdx = printList.poll();
                for (int i = 0; i < N; i++) {
                    if (importance[currentIdx] < importance[i]) {
                        isHighestPriority = false;
                        break;
                    }
                }
                if (isHighestPriority) {
                    printDoneCnt++;
                    importance[currentIdx] = 0;
                    if (currentIdx == targetIdx) {
                        break;
                    }
                } else {
                    printList.add(currentIdx);
                }
            }
            System.out.println(printDoneCnt);
        }
    }
}
