package swea.src;

import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution1936
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T = 1;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int A = sc.nextInt();
            int B = sc.nextInt();

            if (A == 1) {
                if (B == 2) {
                    System.out.println("B");
                } else if (B == 3) {
                    System.out.println("A");
                }
            } else if (A == 2) {
                if (B == 1) {
                    System.out.println("A");
                } else if (B == 3) {
                    System.out.println("B");
                }
            } else if (A == 3) {
                if (B == 1) {
                    System.out.println("B");
                } else if (B == 2) {
                    System.out.println("A");
                }
            }
		}
        sc.close();
	}
}