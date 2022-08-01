import java.util.Scanner;
// import java.util.Arrays;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution1959
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

			int[] A = new int[N];
			int[] B = new int[M];
			
			for (int i=0; i<A.length; i++) {
				A[i] = sc.nextInt();
			}
			for (int i=0; i<B.length; i++) {
				B[i] = sc.nextInt();
			}

			int Max = 0;
			if(N<M) {
				for (int i=0; i<M-N+1; i++) {
					int mult = 0;
					for (int j=0; j<N; j++) {
						mult += A[j] * B[i+j];
					}
					Max = Math.max(mult, Max);
				}
			} else if(N>M) {
				for (int i=0; i<N-M+1; i++) {
					int mult = 0;
					for (int j=0; j<M; j++) {
						mult += A[i+j] * B[j];
					}
					Max = Math.max(mult, Max);
				}
			}
			System.out.println("#"+test_case+" "+Max);
		}
		sc.close();
	}
}