package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Swap_word {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Character> st = new Stack<Character>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//number of test case
		int T = Integer.parseInt(bf.readLine());
		
		// testcase string 저장하기 위한 String array
		String[] s = new String[T];
		
		for(int i=0; i<T; i++) {
			s[i] = bf.readLine();
			s[i] += '\n';
		}

		//main algorithm
		for(int i=0;i<T;i++) {
			for(char ch:s[i].toCharArray()) {
				//string 안에 공백이 있을 경우, 혹은 문장의 마지막일 경우는 stack에 pussh한 내용을 pop -> stack비우기.
				if(ch == ' '||ch == '\n') {
					while(!st.isEmpty()) { System.out.print(st.pop()); }
					st.clear();
					System.out.print(" ");}
				//그렇지 않은 경우는 모두 stack에 저장
				else {st.push(ch);}
				}
			System.out.println();
			}

	}
}

