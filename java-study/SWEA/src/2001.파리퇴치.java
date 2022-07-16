import java.util.Scanner;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution2001
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] fly = new int[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    fly[i][j] = sc.nextInt();
                }
            }

            int cntfly = 0;
            int max = 0;

            for (int i=0; i<N-M+1; i++) {
                for (int j=0; j<N-M+1; j++) {
                    for (int k=0; k<M; k++) {
                        for (int l=0; l<M; l++) {
                            cntfly += fly[i+k][j+l];
                        }

                    }
                    max = Math.max(max, cntfly);
                    cntfly = 0;
                }
                
            }

            System.out.println("#"+test_case+" "+max);
		}
        sc.close();
	}
}