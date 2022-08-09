package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_Q1861 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N;
        StringTokenizer st;
        int startingRoomNum;
        int movementCnt;
        boolean isDone = false;
        int r, c;
        int maxMoveCnt = 0;

        for (int test_case = 1; test_case < T + 1; test_case++) {
            N = Integer.parseInt(br.readLine());
            int[][] rooms = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    r = i;
                    c = j;
                    movementCnt = 0;
                    while (!isDone) {
                        if (r - 1 >= 0 && rooms[r - 1][c] == rooms[r][c] + 1) {
                            movementCnt++;
                            r--;
                        } else if (c - 1 >= 0 && rooms[r][c - 1] == rooms[r][c] + 1) {
                            movementCnt++;
                            c--;
                        } else if (r + 1 < N && rooms[r + 1][c] == rooms[r][c] + 1) {
                            movementCnt++;
                            r++;
                        } else if (c + 1 < N && rooms[r][c + 1] == rooms[r][c] + 1) {
                            movementCnt++;
                            c++;
                        } else {
                            isDone = true;
                        }
                    }
                    maxMoveCnt = Math.max(maxMoveCnt, movementCnt);
                    isDone = false;
                }
            }

            startingRoomNum = N * N;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    r = i;
                    c = j;
                    movementCnt = 0;
                    while (!isDone) {
                        if (r - 1 >= 0 && rooms[r - 1][c] == rooms[r][c] + 1) {
                            movementCnt++;
                            r--;
                        } else if (c - 1 >= 0 && rooms[r][c - 1] == rooms[r][c] + 1) {
                            movementCnt++;
                            c--;
                        } else if (r + 1 < N && rooms[r + 1][c] == rooms[r][c] + 1) {
                            movementCnt++;
                            r++;
                        } else if (c + 1 < N && rooms[r][c + 1] == rooms[r][c] + 1) {
                            movementCnt++;
                            c++;
                        } else {
                            isDone = true;
                        }
                    }
                    if (movementCnt == maxMoveCnt) {
                        startingRoomNum = Math.min(startingRoomNum, rooms[i][j]);
                    }
                    isDone = false;
                }
            }

            maxMoveCnt++;
            System.out.println("#" + test_case + " " + startingRoomNum + " " + maxMoveCnt);
            startingRoomNum = N * N;
            maxMoveCnt = 0;
        }
    }
}