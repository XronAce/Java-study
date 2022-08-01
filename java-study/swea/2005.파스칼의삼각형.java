package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution2005
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            System.out.println("#"+test_case);
            List<Integer> beforeLine = new ArrayList<>();
            
            for (int i=1; i<N+1; i++) {
                List<Integer> temp = new ArrayList<>();
                if (i == 1) {
                    System.out.println("1");
                    beforeLine.add(1);
                } else if (i == 2) {
                    System.out.println("1 1");
                    temp.add(1); temp.add(1);
                    beforeLine = temp;
                } else {
                    System.out.printf("1 ");
                    temp.add(1);
                    for (int j=1; j<i-1; j++) {
                        System.out.printf("%d ", beforeLine.get(j-1)+beforeLine.get(j));
                        temp.add(beforeLine.get(j-1)+beforeLine.get(j));
                    }
                    System.out.println("1");
                    temp.add(1);
                    beforeLine = temp;
                }


            }
		}


        sc.close();
	}
}