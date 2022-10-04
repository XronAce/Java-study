package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q2239 {
    public static int[][] sudoku;
    public static int[] chkRow, chkCol, chkBox; // 행, 열, 미니정사각형 범위로 입력 가능한 숫자들을 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];

        String s;
        int zeroCnt = 0;

        for (int i = 0; i < 9; i++) {
            s = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = s.charAt(j) - '0';
                if (sudoku[i][j] == 0) {
                    zeroCnt++;
                }
            }
        }

        while (zeroCnt != 0) {
            boolean isZeroCntDown = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int chkAll = 0;
                    boolean flag = false;
                    if (sudoku[i][j] == 0) {
                        chkRow = possibleRow(i, j);
                        chkCol = possibleCol(i, j);
                        chkBox = possibleBox(i, j);
                    } else {
                        continue;
                    }

                    for (int k = 0; k < chkRow.length; k++) {
                        if (isElementInArray(chkRow[k], chkCol)) {
                            if (isElementInArray(chkRow[k], chkBox)) {
                                if (chkAll != 0) {
                                    flag = true;
                                    break;
                                }
                                chkAll = chkRow[k];
                            }
                        }
                    }
                    if (flag) {
                        continue;
                    } else {
                        sudoku[i][j] = chkAll;
                        zeroCnt--;
                        isZeroCntDown = true;
                        break;
                    }
                }
                if (isZeroCntDown) {
                    break;
                }
            }
        }

        for (int[] innerArr : sudoku) {
            for (int i = 0; i < 9; i++) {
                System.out.print(innerArr[i]);
            }
            System.out.println();
        }

    }

    public static boolean isElementInArray(int e, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {
                return true;
            }
        }
        return false;
    }
    
    public static int[] possibleRow(int r, int c) {
        int cnt = 0;
        for (int j = 0; j < 9; j++) {
            if (sudoku[r][j] != 0) {
                cnt++;
            }
        }

        int[] temp = new int[cnt];
        int idx = 0;

        for (int j = 0; j < 9; j++) {
            if (sudoku[r][j] != 0) {
                temp[idx++] = sudoku[r][j];
            }
        }

        int[] temp1 = new int[9 - cnt];
        idx = 0;
        for (int i = 1; i <= 9; i++) {
            if (isElementInArray(i, temp)) {
                continue;
            }
            temp1[idx++] = i;
        }

        return temp1;
    }

    public static int[] possibleCol(int r, int c) {
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][c] != 0) {
                cnt++;
            }
        }

        int[] temp = new int[cnt];
        int idx = 0;

        for (int i = 0; i < 9; i++) {
            if (sudoku[i][c] != 0) {
                temp[idx++] = sudoku[i][c];
            }
        }

        int[] temp1 = new int[9 - cnt];
        idx = 0;
        for (int i = 1; i <= 9; i++) {
            if (isElementInArray(i, temp)) {
                continue;
            }
            temp1[idx++] = i;
        }

        return temp1;
    }
    
    public static int[] possibleBox(int r, int c) {
        int cnt = 0;
        int chkRangeR = 0; // if chkRange=1: range btw 0 to 2. chkRange=2: range btw 3 to 5. chkRange=3: range btw 6 to 8.
        int chkRangeC = 0; // if chkRange=1: range btw 0 to 2. chkRange=2: range btw 3 to 5. chkRange=3: range btw 6 to 8.
        
        if (r >= 0 && r <= 2) {
            chkRangeR = 1;
        } else if (r >= 3 && r <= 5) {
            chkRangeR = 2;
        } else {
            chkRangeR = 3;
        }

        if (c >= 0 && c <= 2) {
            chkRangeC = 1;
        } else if (c >= 3 && c <= 5) {
            chkRangeC = 2;
        } else {
            chkRangeC = 3;
        }

        for (int i = (chkRangeR - 1) * 3; i < chkRangeR * 3; i++) {
            for (int j = (chkRangeC - 1) * 3; j < chkRangeC * 3; j++) {
                if (sudoku[i][j] != 0) {
                    cnt++;
                }
            }
        }

        int[] temp = new int[cnt];
        int idx = 0;

        for (int i = (chkRangeR - 1) * 3; i < chkRangeR * 3; i++) {
            for (int j = (chkRangeC - 1) * 3; j < chkRangeC * 3; j++) {
                if (sudoku[i][j] != 0) {
                    temp[idx++] = sudoku[i][j];
                }
            }
        }

        int[] temp1 = new int[9 - cnt];
        idx = 0;
        for (int i = 1; i <= 9; i++) {
            if (isElementInArray(i, temp)) {
                continue;
            }
            temp1[idx++] = i;
        }

        return temp1;
    }
}
