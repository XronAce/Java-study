package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_Q2116 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dices = new int[N][6];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for (int j=0; j<6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int undermostNum = 0;
		int undermostIdx = 0;
		int answer = 0;
		
		for (int i=0; i<6; i++) {
			undermostNum = dices[0][i];
			List<List<Integer>> sides = new ArrayList<>();
			for (int j=0; j<N; j++) {
				for (int k=0; k<6; k++) {
					if (dices[j][k] == undermostNum) {
						undermostIdx = k;
						break;
					}
				}
				List<Integer> side = new ArrayList<>();
				if (undermostIdx == 0 || undermostIdx == 5) {
					side.add(dices[j][1]); side.add(dices[j][2]); side.add(dices[j][3]); side.add(dices[j][4]);
					if (undermostIdx == 0)
						undermostNum = dices[j][5];
					else
						undermostNum = dices[j][0];
				} else if (undermostIdx == 1 || undermostIdx == 3) {
					side.add(dices[j][0]); side.add(dices[j][2]); side.add(dices[j][4]); side.add(dices[j][5]);
					if (undermostIdx == 1)
						undermostNum = dices[j][3];
					else
						undermostNum = dices[j][1];
				} else if (undermostIdx == 2 || undermostIdx == 4) {
					side.add(dices[j][0]); side.add(dices[j][1]); side.add(dices[j][3]); side.add(dices[j][5]);
					if (undermostIdx == 2)
						undermostNum = dices[j][4];
					else
						undermostNum = dices[j][2];
				}
				sides.add(side);
			}
			int sum = 0;
			for(int j=0; j<sides.size(); j++) {
				int max = 0;
				for (int k=0; k<4; k++) {
					max = Math.max(sides.get(j).get(k), max);
				}
				sum += max;
			}
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
		
		
	}
}
