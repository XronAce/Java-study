package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_Q5466 {
    public static void move(int command, int row, int col) { // 주의. 배열은 상하-좌우가 바껴있음
        if (command == 0) {
            /* do nothing */} else if (command == 1) {
            col -= 1;
        } else if (command == 2) {
            row += 1;
        } else if (command == 3) {
            col += 1;
        } else if (command == 4) {
            row -= 1;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()); // 총 이동시간
        int A = Integer.parseInt(st.nextToken()); // BC의 개수

        int[] userA = new int[M]; // 사용자A의 이동 동선
        int[] userB = new int[M]; // 사용자B의 이동 동선
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            userA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            userB[i] = Integer.parseInt(st.nextToken());
        }

        int[][][] map = new int[10][10][A + 1]; // 전체 지도. [A]에 i-1번째 BC 존재 시 p입력, 없으면 0
        for (int k = 0; k < A; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken()) - 1; // 주의. row, column은 각각 y,x에 대응
            int x = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (Math.abs(x - i) + Math.abs(y - j) <= c) {
                        map[i][j][k] = p;
                        map[i][j][A] += 1;
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(map));

        int rowA = 0; // 사용자A와 사용자B의 시작점 초기화
        int colA = 0;
        int rowB = 9;
        int colB = 9;
        int[][] charges = new int[M][2]; // 충전량 저장
        boolean[] isUserInArea = new boolean[A]; // 각 BC 범위 위에 유저가 있는지
        for (int t = 0; t < M; t++) { // 시간 t에 따른 충전량 처리
            // 사용자들의 현위치 변경
            move(userA[t], rowA, colA);
            move(userB[t], rowB, colB);

        }
    }
}
