package swea1;

import java.util.Arrays;
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution원재
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String bitStr = sc.next();
            int[] bit = new int[bitStr.length()];
            int[] baseBit = new int[bitStr.length()];
            int count = 0;
            int checkIdxPointer = 0;
            int whatNumber = 0;

            for (int i=0; i<bitStr.length(); i++) {
                bit[i] = (bitStr.charAt(i)-'0');
                baseBit[i] = 0;
            }

            for (int i=0; i<bitStr.length(); i++) {
                if (bit[i] == 1) {
                    checkIdxPointer = i;
                    break;
                }
            }
            
            while (!Arrays.toString(baseBit).equals(Arrays.toString(bit))) {
                count++;
                System.out.println(count);
                System.out.println("변경 전: "+Arrays.toString(baseBit));
                if (baseBit[checkIdxPointer] == 0)
                    whatNumber = 1;
                else
                    whatNumber = 0;
                
                for (int i=checkIdxPointer; i<bitStr.length(); i++) {
                    baseBit[i] = whatNumber;
                }

                for (int i=0; i<bitStr.length(); i++) {
                    if (baseBit[i] != bit[i]) {
                        checkIdxPointer = i;
                        break;
                    }
                }
                System.out.println("변경 후: "+Arrays.toString(baseBit));
            }

            System.out.println("#"+test_case+" "+count);
            


		}


        sc.close();
	}
}