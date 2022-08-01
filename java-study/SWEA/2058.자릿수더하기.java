package SWEA;

import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution2058
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=1;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();

            String S = String.valueOf(N);
            int sum = 0;
            for (int i=0; i<S.length(); i++) {
                sum += S.charAt(i) - '0';
            }
            System.out.println(sum);
		}


        sc.close();
	}
}

/*
 * str.charAt(i) - '0' returns int value of char type of str.charAt(i).
 * String.valueOf(int N) transforms int variable N into equivalent value string variable.
 */