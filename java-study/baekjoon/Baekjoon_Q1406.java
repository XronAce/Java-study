package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_Q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        List<Character> editor = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            editor.add(s.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        int cursorPositionIdx = editor.size(); // 커서의 위치는 editor.get(cursorPositionIdx-1)의 뒤에 있다. 0일 경우 맨 앞에 위치하고 있다.

        for (int command_case = 1; command_case <= M; command_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("L") && cursorPositionIdx != 0) {
                cursorPositionIdx--;
            } else if (command.equals("D") && cursorPositionIdx != editor.size()) {
                cursorPositionIdx++;
            } else if (command.equals("B") && cursorPositionIdx != 0) {
                cursorPositionIdx--;
                editor.remove(cursorPositionIdx);
            } else if (command.equals("P")) {
                editor.add(cursorPositionIdx, st.nextToken().charAt(0));
                cursorPositionIdx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < editor.size(); i++) {
            sb.append(editor.get(i));
        }

        s = sb.toString();

        System.out.println(s);

    }
}
