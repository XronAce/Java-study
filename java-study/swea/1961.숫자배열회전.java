import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution1961
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.println("#"+test_case);
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int k=0; k<N; k++) {
                String answer = "";
                String num = "";
                for (int i=N-1; i>=0; i--) {
                    num += arr[i][k] + "";
                }
                answer += num + " ";

                num = "";
                for (int j=N-1; j>=0; j--) {
                    num += arr[N-k-1][j] + "";
                }
                answer += num + " ";

                num = "";
                for (int i=0; i<N; i++) {
                    num += arr[i][N-k-1] + "";
                }
                answer += num;
                System.out.println(answer);
            }
		}
        sc.close();
	}
}