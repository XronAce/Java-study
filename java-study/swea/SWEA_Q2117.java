package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q2117 {
    public static int N, M, ans, house;
    public static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int K = 1;
            ans = 0;
            while (true) {
                house = scan(K);
                if (house == -1) {
                    break;
                }
                ans = Math.max(ans, house);
                K++;
            }
            System.out.println(scan(4));

            System.out.println("#" + test_case + " " + ans);

        }
    }

    /*
     * 입력받은 K에 해당하는 영역으로 커버할 수 있는 최대한의 집의 수의 경우에서
     * 손해가 없을 때 최대 집의 수를 리턴. 손해 발생 시 -1 리턴
     */
    public static int scan(int K) {
        int houseCnt = 0;
        int maxHouseCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                houseCnt = 0;
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (Math.abs(i - r) + Math.abs(j - c) <= K - 1) {
                            if (map[r][c] == 1) {
                                houseCnt++;
                            }
                        }
                    }
                }
                maxHouseCnt = Math.max(maxHouseCnt, houseCnt);
            }
        }

        int profit = -(K * K + (K - 1) * (K - 1)) + maxHouseCnt * M;

        if (profit < 0) {
            return -1;
        } else {
            return maxHouseCnt;
        }

    }
}

/*
 * K = 5 일떄
 * 집 커버 개수 : 7
 * 
 * 손익 계산: -(5*5+4*4) + 7*3 = -25-16+21 = -20
 * 
 * bruteforce 진행 시
 * K를 1부터 증가하는 방식으로 탐색을 해야 효율적
 * 
 * 1. K를 1부터 증가하는 방식으로
 * 각 K일때 최대한 많은 집을 커버할 때의 비용 계산 후 이익이면 ans에 갱신
 * 손해면 K-1일때가 최대치
 * test_case 2 고쳐야함
 */