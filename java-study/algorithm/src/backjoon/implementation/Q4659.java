package backjoon.implementation;

import java.io.*;

public class Q4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;

        while (true) {
            s = br.readLine();
            if (s.equals("end")) {
                break;
            }

            if (!hasVowel(s)) {
                bw.write("<" + s + ">" + " is not acceptable.\n");
                continue;
            }

            if (isConsecutive3VowelOrNonVowel(s)) {
                bw.write("<" + s + ">" + " is not acceptable.\n");
                continue;
            }

            if (isConsecutive2Times(s)) {
                bw.write("<" + s + ">" + " is not acceptable.\n");
                continue;
            }

            bw.write("<" + s + ">" + " is acceptable.\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean hasVowel(String s) {
        for (int i=0; i<s.length(); i++) {
            switch(s.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return true;
                default:
                    break;
            }
        }
        return false;
    }

    public static boolean isConsecutive3VowelOrNonVowel(String s) {
        for (int i=0; i<s.length()-2; i++) {
            if (hasVowel(String.valueOf(s.charAt(i)))) {
                if (hasVowel(String.valueOf(s.charAt(i+1)))) {
                    if (hasVowel(String.valueOf(s.charAt(i+2)))) {
                        return true;
                    }
                }
            } else {
                if (!hasVowel(String.valueOf(s.charAt(i+1)))) {
                    if (!hasVowel(String.valueOf(s.charAt(i+2)))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isConsecutive2Times(String s) {
        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                if (s.charAt(i) == 'e') {
                    continue;
                } else if (s.charAt(i) == 'o') {
                    continue;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
