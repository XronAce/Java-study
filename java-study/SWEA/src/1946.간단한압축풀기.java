import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution1946
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            String[] letter = new String[N];
            int[] num = new int[N];
            int totalLength = 0;

            for (int i=0; i<N; i++) {
                letter[i] = sc.next();
                num[i] = sc.nextInt();
            }

            for (int i=0; i<N; i++) {
                totalLength += num[i];
            }

            int idx = 0;
            String[] zipped = new String[totalLength];
            for (int j=0; j<N; j++) {
                for (int k=0; k<num[j]; k++) {
                    zipped[idx] = letter[j];
                    idx++;
                }
            }

            System.out.println("#"+test_case);
            int count = 0;
            for (int i=0; i<totalLength; i++) {
                System.out.print(zipped[i]);
                count++;
                if (count%10 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
		}
        sc.close();
	}
}