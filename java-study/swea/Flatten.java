package swea;

import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class SolutionFlatten
{
	static int[] dump(int[] wall) {
		int maxHeight = 0;
		int minHeight = 100;
		int maxIdx = 0;
		int minIdx = 0;
		
		for (int i=0; i<100; i++) {
			maxHeight = Math.max(maxHeight, wall[i]);
			minHeight = Math.min(minHeight, wall[i]);
		}
		
		for (int i=0; i<100; i++) {
			if (wall[i] == maxHeight) {
				maxIdx = i;
				break;
			}
		}
		
		for (int i=0; i<100; i++) {
			if (wall[i] == minHeight) {
				minIdx = i;
				break;
			}
		}
		
		wall[maxIdx]--;
		wall[minIdx]++;
		
		return wall;
	}
	
	static int heightDiff(int[] wall) {
		int maxHeight = 0;
		int minHeight = 100;
		
		for (int i=0; i<100; i++) {
			maxHeight = Math.max(maxHeight, wall[i]);
			minHeight = Math.min(minHeight, wall[i]);
		}
		
		return maxHeight-minHeight;
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int dumpCnt = sc.nextInt();
            int[] wall = new int[100];
            
            for (int i=0; i<100; i++) {
            	wall[i] = sc.nextInt();
            }
            
            for (int i=0; i<dumpCnt; i++) {
            	dump(wall);
            }
            
            System.out.println("#"+test_case+" "+heightDiff(wall));
		}
		

        sc.close();
	}
}