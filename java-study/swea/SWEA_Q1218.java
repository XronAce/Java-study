package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_Q1218 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case < 11; test_case++) {
            int length = Integer.parseInt(br.readLine());
            String[] brackets = br.readLine().split("");
            Boolean isCorrect = true;

            int numBracOpenS = 0; // 열려있는 ()괄호의 개수
            int numBracOpenM = 0; // 열려있는 {}괄호의 개수
            int numBracOpenB = 0; // 열려있는 []괄호의 개수
            int numBracOpenP = 0; // 열려있는 <>괄호의 개수

            for (int i = 0; i < length; i++) {
                if (brackets[i].equals("("))
                    numBracOpenS++;
                else if (brackets[i].equals("{"))
                    numBracOpenM++;
                else if (brackets[i].equals("["))
                    numBracOpenB++;
                else if (brackets[i].equals("<"))
                    numBracOpenP++;
                else if (brackets[i].equals(")"))
                    numBracOpenS--;
                else if (brackets[i].equals("}"))
                    numBracOpenM--;
                else if (brackets[i].equals("]"))
                    numBracOpenB--;
                else if (brackets[i].equals(">"))
                    numBracOpenP--;

                // 만약 ), }, ], > 이 괄호가 열리기도 전에 나오면 잘못된 것이므로
                if (numBracOpenS < 0 || numBracOpenM < 0 || numBracOpenB < 0 || numBracOpenP < 0) {
                    isCorrect = false;
                    break;
                }
            }

            if (!isCorrect) {
                System.out.println("#" + test_case + " " + "0");
                continue;
            }

            if (numBracOpenS != 0 || numBracOpenM != 0 || numBracOpenB != 0 || numBracOpenP != 0) {
                isCorrect = false;
            } else {
                isCorrect = true;
            }

            if (isCorrect) {
                System.out.println("#" + test_case + " " + "1");
            } else {
                System.out.println("#" + test_case + " " + "0");
            }

        }
    }
}
