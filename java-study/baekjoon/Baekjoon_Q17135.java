package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q17135 {
    public static int N, M, D;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // int stage = 0;
        // while (stage != N) {
        // stage++; // stage 시작
        // attack();
        // nextRound();
        // }

    }

}

/*
 * 1. 궁수 3명의 배치가 가능한 모든 경우의 수에 대해 게임을 진행하여 제거한 총 적의 수를 매판 비교해서 최대값을 구하자.
 * 2. 궁수의 공격을 처리하는 메소드 attack()을 구현
 * 3. attack() 메소드 이후 게임판의 적이 한칸씩 아래로 진격하는 것을 처리하는 nextRound() 메소드 구현
 * 4. 1번의 모든 경우의 수에 대해 매 게임을 deepcopy한 게임판으로 진행해야 하므로 arrDeepCopy() 메소드 구현
 */