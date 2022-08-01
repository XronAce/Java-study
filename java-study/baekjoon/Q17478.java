package baekjoon;

import java.util.Scanner;

public class Q17478 {
	static int repTime = 0;
	static void foo(int N) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<repTime; i++) {
			sb.append("____");
		}
		
		if (N == 0) {
			System.out.print(sb.toString()); System.out.println("\"재귀함수가 뭔가요?\"");
			System.out.print(sb.toString()); System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			return;
		}
		
		System.out.print(sb.toString()); System.out.println("\"재귀함수가 뭔가요?\"");
		System.out.print(sb.toString()); System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		System.out.print(sb.toString()); System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		System.out.print(sb.toString()); System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		repTime++;
		foo(N-1);
	}
	
	static void bar() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<repTime; i++) {
			sb.append("____");
		}
		
		if (repTime == 0) {
			System.out.println("라고 답변하였지.");
			return;
		}
		
		System.out.print(sb.toString()); System.out.println("라고 답변하였지.");
		repTime--;
		bar();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		foo(N);
		
		bar();
		
		sc.close();
		
	}
}
