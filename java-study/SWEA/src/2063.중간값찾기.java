import java.util.Scanner;
import java.util.Arrays;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution2063
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=1;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[] number = new int[N];
            for (int i=0; i<N; i++) {
                number[i] = sc.nextInt();
            }

            Arrays.sort(number);
            int middle = N/2;
            System.out.println(number[middle]);
		}
        sc.close();
	}
}