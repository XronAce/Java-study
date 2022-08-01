package SWEA;

import java.util.Scanner;
// import java.util.Arrays;

class Solution1979
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) 
        {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] puzzle = new int[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    puzzle[i][j] = sc.nextInt();
                }
            }
            // System.out.println(Arrays.deepToString(puzzle));

            int cntcol = 0;
            int cntrow = 0;

            for (int i=0; i<N; i++) {
                int space = 0;
                for (int j=0; j<N; j++) {
                    if (puzzle[i][j] == 1) {
                        space += 1;
                        if (j == N-1 && space == K) {
                            cntcol += 1;
                        }
                    } else {
                        if (space == K) {
                            cntcol += 1;
                        }
                        space = 0;
                    }
                }
            }

            for (int j=0; j<N; j++) {
                int space = 0;
                for (int i=0; i<N; i++) {
                    if (puzzle[i][j] == 1) {
                        space += 1;
                        if (i == N-1 && space == K) {
                            cntrow += 1;
                        }
                    } else {
                        if (space == K) {
                            cntrow += 1;
                        }
                        space = 0;
                    }
                }
            }
            

            

            // System.out.println("cntcol: "+cntcol+" cntrow: "+cntrow);
            int answer = cntcol + cntrow;
            System.out.println("#"+test_case+" "+answer);
	    }
        sc.close();
    }
}   