import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution1926
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=1;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();

            for (int i=1; i<N+1; i++) {
                int clap = 0;
                String num = String.valueOf(i);
                for (int j=0; j<num.length(); j++) {
                    if ((num.charAt(j) - '0')%3 == 0 && num.charAt(j) - '0' != 0) {
                        clap++;
                    }
                }
                if (clap == 0) {
                    System.out.print(i+" ");
                } else {
                    for (int k=0; k<clap; k++) {
                        System.out.print("-");
                    }
                    System.out.print(" ");
                }
            }
		}


        sc.close();
	}
}