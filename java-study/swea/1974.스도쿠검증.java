import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Solution1974
{
	public static boolean isItContaining(int[] array, int key) {
        return Arrays.stream(array).anyMatch(i -> i == key);
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		int[] number = new int[9];

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int flag = 1;
			int[][] sudoku = new int[9][9];
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					number[j] = sudoku[i][j];
				}
				for (int j=0; j<9; j++) {
					if (isItContaining(number, j+1)) {
						continue;
					} else {
						flag = 0;
						break;
					}
				}
			}

			if (flag == 0) {
				System.out.println("#"+test_case+" "+flag);
				continue;
			}

			flag = 1;
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					number[j] = sudoku[j][i];
				}
				for (int j=0; j<9; j++) {
					if (isItContaining(number, j+1)) {
						continue;
					} else {
						flag = 0;
						break;
					}
				}
			}

			if (flag == 0) {
				System.out.println("#"+test_case+" "+0);
				continue;
			}
			flag = 1;
			for (int i=0; i<9; i+=3) {
				for (int j=0; j<9; j+=3) {
					ArrayList<Integer> tempList = new ArrayList<>();
					for (int k=0; k<3; k++) {
						for (int a=0; a<3; a++) {
							tempList.add(sudoku[i+k][j+a]);
						}
					}
					for (int m=0; m<9; m++) {
						number[m] = tempList.get(m);
					}
					for (int m=0; m<9; m++) {
						if (isItContaining(number, m+1)) {
							continue;
						} else {
							flag = 0;
							break;
						}
					}
				}
			}

			if (flag == 0) {
				System.out.println("#"+test_case+" "+0);
				continue;
			} else {
				System.out.println("#"+test_case+" "+1);
			}
		}
		sc.close();
	}
}