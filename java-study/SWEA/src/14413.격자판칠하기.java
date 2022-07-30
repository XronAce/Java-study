import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution14413
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int row = sc.nextInt();
            int column = sc.nextInt();
            char[][] arr = new char[row][column];
            Boolean isValidInput = true;

            for (int i=0; i<row; i++) {
                String temp = sc.next();
                for (int j=0; j<column; j++) {
                    arr[i][j] = temp.charAt(j);
                }
            }

            // 제공된 격자판이 이미 연속된 색을 가지고 있는 경우 처리
            for (int i=0; i<row-1; i++) {
                for (int j=0; j<column-1; j++) {
                    if (arr[i][j] != '?' && arr[i][j] == arr[i][j+1]) {
                        isValidInput = false;
                        break;
                    } else if (arr[i][j] != '?' && arr[i][j] == arr[i+1][j]) {
                        isValidInput = false;
                        break;
                    }
                }
                if (!isValidInput)
                    break;
            }
            if(!isValidInput) {
                System.out.println("#"+test_case+" impossible");
                continue;
            }

            // 첫 검은색 or 흰색 격자 찾기
            int remI = 0;
            int remJ = 0;
            Boolean isFound = false;
            for (int i=0; i<row; i++) {
                for (int j=0; j<column; j++) {
                    if (arr[i][j] != '?') {
                        remI = i;
                        remJ = j;
                        isFound = true;
                        break;
                    }
                }
                if (isFound)
                    break;
            }

            // arr[remI][remJ] 기준 좌우 색칠하기
            for (int j=remJ; j<column-1; j++) {
                if (arr[remI][j+1] != '?') {
                    continue;
                } else {
                    if (arr[remI][j] == '#')
                        arr[remI][j+1] = '.';
                    else
                        arr[remI][j+1] = '#';
                }
            }

            for (int j=remJ; j>0; j--) {
                if (arr[remI][j-1] != '?') {
                    continue;
                } else {
                    if (arr[remI][j] == '#')
                            arr[remI][j-1] = '.';
                        else
                            arr[remI][j-1] = '#';
                }
            }

            // arr[remI][remJ] 기준 상하 색칠하기
            for (int i=remI; i<row-1; i++) {
                if (arr[i+1][remJ] != '?') {
                    continue;
                } else {
                    if (arr[i][remJ] == '#')
                        arr[i+1][remJ] = '.';
                    else
                        arr[i+1][remJ] = '#';
                }
            }

            for (int i=remI; i>0; i--) {
                if (arr[i-1][remJ] != '?') {
                    continue;
                } else {
                    if (arr[i][remJ] == '#')
                            arr[i-1][remJ] = '.';
                        else
                            arr[i-1][remJ] = '#';
                }
            }

            // 격자판 다 교차 색칠을 좌우로 진행
            for (int r=0; r<row; r++) {
                for (int c=0; c<column; c++) {
                    if (arr[r][c] != '?') {
                        remJ = c;
                        for (int j=remJ; j<column-1; j++) {
                            if (arr[r][j+1] != '?') {
                                continue;
                            } else {
                                if (arr[r][j] == '#')
                                    arr[r][j+1] = '.';
                                else
                                    arr[r][j+1] = '#';
                            }
                        }
            
                        for (int j=remJ; j>0; j--) {
                            if (arr[r][j-1] != '?') {
                                continue;
                            } else {
                                if (arr[r][j] == '#')
                                        arr[r][j-1] = '.';
                                    else
                                        arr[r][j-1] = '#';
                            }
                        }
                        break;
                    }
                }
            }

            // 격자판 무결성 확인
            Boolean isPossible = true;
            for (int i=0; i<row; i++) {
                for (int j=0; j<column; j++) {
                    if (i-1>=0 && arr[i][j] == arr[i-1][j]) {
                        isPossible = false;
                        break;
                    } else if (j+1<column && arr[i][j] == arr[i][j+1]) {
                        isPossible = false;
                        break;
                    } else if (i+1<row && arr[i][j] == arr[i+1][j]) {
                        isPossible = false;
                        break;
                    } else if (j-1>=0 && arr[i][j] == arr[i][j-1]) {
                        isPossible = false;
                        break;
                    }
                }
                if (!isPossible)
                    break;
            }

            if (isPossible)
                System.out.println("#"+test_case+" possible");
            else
            System.out.println("#"+test_case+" impossible");



            
		}


        sc.close();
	}
}

/* 
 * 1. 주어진 격자판에 #과 .이 연속되서 나오는지 먼저 체크
 * 2. 탐색 순서(row++, column++)에서 처음으로 만나는 '?'이 아닌 격자를 기준으로 상하좌우 교차색 칠하기. 칠하는 과정에서 연속된 색이 발견될 경우 종료.
 * 3. 2번이 성공적이면 3번부터는 각 row 마다 처음 만나는 '?'이 아닌 격자를 기준으로 좌우 교차색 칠하기. 칠하는 과정에서 연속된 색이 발견될 경우 종료.
 * 4. 3번이 성공적이면 전체탐색을 진행하면서 연속되는 색이 발견되는지 확인
 */