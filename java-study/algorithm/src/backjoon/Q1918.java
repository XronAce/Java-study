package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Q1918 {
    public static StringBuilder parenthesis;
    public static Stack<Character> subOperator;
    public static StringBuilder answer;
    public static Stack<Character> operator;

    public static String postfixMaker(String normal) {
        for (int i=0; i<normal.length(); i++) {
            boolean isOperator = normal.charAt(i) == '*' || normal.charAt(i) == '/' || normal.charAt(i) == '+' || normal.charAt(i) == '-';
            if (isOperator) {
                subOperator.push(normal.charAt(i));
            } else {
                if (normal.charAt(i) == '(' || normal.charAt(i) == ')') {
                    continue;
                }
                parenthesis.append(normal.charAt(i));
                if (!subOperator.empty()) {
                    if (subOperator.peek() == '*' || subOperator.peek() == '/') {
                        parenthesis.append(subOperator.pop());
                    }
                }
            }
        }
        while (!subOperator.empty()) {
            parenthesis.append(subOperator.pop());
        }

        String ans = parenthesis.toString();
        parenthesis.delete(0, parenthesis.length());
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(s).append(')');
        s = sb.toString();
        sb.delete(0, sb.length());

        answer = new StringBuilder();
        operator = new Stack<>();
        parenthesis = new StringBuilder();
        subOperator = new Stack<>();

        int lastOpeningPIdx = 0;
        int firstClosingPIdx = 0;
        int pPairCnt = 0;

        String[] subs = new String[50];
        int index = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                pPairCnt++;
            }
        }

        while (pPairCnt != 0) {
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '(') {
                    lastOpeningPIdx = i;
                }
            }

            for (int i=s.length()-1; i>=0; i--) {
                if (s.charAt(i) == ')') {
                    firstClosingPIdx = i;
                }
            }

            System.out.println(lastOpeningPIdx + " " + firstClosingPIdx);
            for (int i=lastOpeningPIdx+1; i<firstClosingPIdx; i++) {
                sb.append(s.charAt(i));
            }
            subs[index] = postfixMaker(sb.toString());
            sb.delete(0, sb.length());
            pPairCnt--;

            for (int i=0; i<lastOpeningPIdx; i++) {
                sb.append(s.charAt(i));
            }
            sb.append((char) (97+index++));
            for (int i=firstClosingPIdx+1; i<s.length(); i++) {
                sb.append(s.charAt(i));
            }
            s = sb.toString();
            sb.delete(0, sb.length());
            System.out.println(s);
            System.out.println(index);
        }

        if (index == 1) {
            answer.append(subs[0]);
        } else {
            for (int i=1; i<index; i++) {

            }
        }

        System.out.println(Arrays.toString(subs));
        System.out.println(answer);

//        System.out.println(postfixMaker(s));

//        System.out.println(answer);
    }
}
