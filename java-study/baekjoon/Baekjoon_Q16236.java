package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_Q16236 {
    public static int N, bsR, bsC, ateFishCnt, time, unreachableCnt;
    public static int bsSize = 2;
    public static int[][] map;
    public static int[][] timeMap;
    public static List<int[]> eatableFish;
    public static Queue<int[]> eatingQue;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static boolean[][] isVisited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        timeMap = new int[N][N];
        isVisited = new boolean[N][N];
        time = 0;
        unreachableCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    bsR = i;
                    bsC = j;
                    map[i][j] = 0;
                }
            }
        }

        System.out.println("Start!");
        for (int[] arr : map) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();

        while (true) {
            eatableFish = new ArrayList<>();
            eatingQue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] < bsSize && map[i][j] != 0) {
                        int[] temp = { i, j };
                        eatableFish.add(temp);
                    }
                }
            }

            Collections.sort(eatableFish, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int o1Distance = Math.abs(o1[0] - bsR) + Math.abs(o1[1] - bsC);
                    int o2Distance = Math.abs(o2[0] - bsR) + Math.abs(o2[1] - bsC);
                    if (o1Distance == o2Distance) {
                        if (o1[0] == o2[0]) {
                            return o1[1] - o2[1];
                        }
                        return o1[0] - o2[0];
                    }
                    return o1Distance - o2Distance;
                }
            });
            System.out.println("eating sequence: ");
            for (int[] e : eatableFish) {
                System.out.print(Arrays.toString(e) + " ");
            }
            System.out.println();

            for (int i = 0; i < eatableFish.size(); i++) {
                eatingQue.offer(eatableFish.get(i));
            }

            for (int i = 0; i < unreachableCnt; i++) {
                eatingQue.poll();
            }

            if (eatingQue.isEmpty()) {
                break;
            }

            while (!eatingQue.isEmpty()) {
                System.out.println(bsR + " " + bsC + "-->  baby shark original location!");
                bfs(eatingQue.poll());
                System.out.println(bsSize + " " + ateFishCnt + " " + bsR + " " + bsC + " " + time);
                for (int[] arr : map) {
                    System.out.println(Arrays.toString(arr));
                }
                System.out.println();
                if (ateFishCnt == bsSize) {
                    bsSize++;
                    ateFishCnt = 0;
                    break;
                }
            }

        }

        System.out.println(time);
    }

    public static int[][] arrReset(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = 0;
            }
        }
        return arr;
    }

    public static boolean[][] boolReset(boolean[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = false;
            }
        }
        return arr;
    }

    public static void bfs(int[] dest) {
        Queue<int[]> que = new LinkedList<>();
        int[] start = { bsR, bsC };
        que.offer(start);
        isVisited = boolReset(isVisited);
        timeMap = arrReset(timeMap);
        isVisited[bsR][bsC] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int newR = cur[0] + dx[i];
                int newC = cur[1] + dy[i];

                if (newR >= 0 && newC >= 0 && newR < N && newC < N) {
                    if (!isVisited[newR][newC] && map[newR][newC] <= bsSize) {
                        isVisited[newR][newC] = true;
                        int[] temp = { newR, newC };
                        que.offer(temp);
                        timeMap[newR][newC] = timeMap[cur[0]][cur[1]] + 1;
                    }
                }
            }
            if (timeMap[dest[0]][dest[1]] != 0) {
                break;
            }
        }
        if (timeMap[dest[0]][dest[1]] != 0) {
            unreachableCnt = 0;
            ateFishCnt++;
            map[dest[0]][dest[1]] = 0;
            bsR = dest[0];
            bsC = dest[1];
            time += timeMap[dest[0]][dest[1]];
        } else {
            unreachableCnt++;
        }
    }
}

/*
 * 4
 * 4 3 2 1
 * 0 0 0 0
 * 0 0 9 0
 * 1 2 3 4
 * 
 * 아기상어의 크기 변화
 * 2
 * 4초에 3
 * 9초에 4
 * 
 * --
 * bfs로 최단거리 매번 접근하면서 초 더하기
 * 먹을수 있는 물고기 리스트를 아기상어 크기의 변화가 일어날떄마다 거리순 갱신 *************** << 현재 이동할 수 있는 곳으로
 * 이동하면서 만날 수 있는 먹을수있는 물고기를 먼저 먹는다로 바꿔야함
 * 
 * 
 * 상어 크기: 2
 * 상어 위치: (2,2)
 * 지나갈 수 있는 물고기와 먹을수 있는 물고기를 제외한 물고기는 벽 취급
 * 먹을 수 있는 물고기만 물고기 취급
 * 먹다가 크기 증가하면 조건 리셋 후 다시 시작......
 * 
 * < 크기 2 일때 >
 * X X 0 1
 * 0 0 0 0
 * 0 0 9 0
 * 1 0 X X
 * 먹을 수 있는 물고기
 * 
 * X X X 0 X X
 * X X 0 X X X
 * X 0 9 X X X
 * 0 1 0 X X X
 * X 0 1 X X X
 * X X X X X X
 */