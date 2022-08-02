package swea;

import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class SWEA_Q14555
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int ballCnt = 0;
            char[] grassland = new char[50];
            
            String readLine = sc.next();
            for(int i=0; i<readLine.length(); i++) {
            	grassland[i] = readLine.charAt(i);
            }
            
            for(int i=0; i<readLine.length()-1; i++) {
            	if (grassland[i] == '(' && grassland[i+1] != '(') {
            		ballCnt++;
            	}
            }
            
            for (int i=readLine.length()-1; i>0; i--) {
            	if (grassland[i] == ')' && grassland[i-1] != '(' && grassland[i-1] != ')') {
            		ballCnt++;
            	}
            }
            
            System.out.println("#"+test_case+" "+ballCnt);
		}


        sc.close();
	}
}