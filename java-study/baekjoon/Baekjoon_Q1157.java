package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon_Q1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.toUpperCase();
		
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i=0; i<s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		int max = 0;
		int count = 0;
		char answer = 0;
		
		for (Map.Entry<Character, Integer> e: map.entrySet()) {
			max = Math.max(e.getValue(), max);
		}
		
		for (Map.Entry<Character, Integer> e: map.entrySet()) {
			if (e.getValue() == max) {
				answer = e.getKey();
				break;
			}
		}
		
		for (Map.Entry<Character, Integer> e: map.entrySet()) {
			if (max == e.getValue())
				count++;
		}
		
		if (count > 1)
			System.out.println("?");
		else
			System.out.println(answer);
		
	}
}
