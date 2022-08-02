package baekjoon;

import java.util.Scanner;

public class Baekjoon_Q1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numSwitch = sc.nextInt();
		int[] switchStatus = new int[numSwitch];
		for (int i=0; i<numSwitch; i++) {
			switchStatus[i] = sc.nextInt();
		}
		
		int numStudent = sc.nextInt();
		
		for(int studentNo=1; studentNo<=numStudent; studentNo++) {
			int gender = sc.nextInt();
			int switchNo = sc.nextInt();
			
			if (gender == 1) { // 남자일 경우
				for (int i=switchNo-1; i<numSwitch; i+=switchNo) {
					if (switchStatus[i] == 1) switchStatus[i] = 0;
					else switchStatus[i] = 1;
				}
			} else {
				int inc = 0;
				boolean flag = true;
				while(switchNo-1-inc>=0 && switchNo-1+inc<numSwitch && flag) {
					if (switchStatus[switchNo-1-inc] == switchStatus[switchNo-1+inc]) {
						if (switchStatus[switchNo-1-inc] == 1) {
							switchStatus[switchNo-1-inc] = 0;
							switchStatus[switchNo-1+inc] = 0;
						} else {
							switchStatus[switchNo-1-inc] = 1;
							switchStatus[switchNo-1+inc] = 1;
						}
					} else {
						flag = false;
					}
					inc++;
				}
			}
		}
		for (int i=0; i<switchStatus.length; i++) {
			System.out.print(switchStatus[i]+" ");
			if((i+1)%20 == 0)
				System.out.println();
		}
		
		
		sc.close();
	}
}
