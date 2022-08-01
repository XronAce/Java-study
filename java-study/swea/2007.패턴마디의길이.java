import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution2007
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int answer = 0;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String input = sc.next();
            for (int i=1; i<input.length(); i++) {
                String word = input.substring(0, i);
                if (word.equals(input.substring(i, 2*i))) {
                    answer = word.length();
                    break;
                }
            }
            System.out.println("#"+test_case+" "+answer);
		}

        

        sc.close();
	}
}