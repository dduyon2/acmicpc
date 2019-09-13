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
		
		// testcase string �����ϱ� ���� String array
		String[] s = new String[T];
		
		for(int i=0; i<T; i++) {
			s[i] = bf.readLine();
			s[i] += '\n';
		}

		//main algorithm
		for(int i=0;i<T;i++) {
			for(char ch:s[i].toCharArray()) {
				//string �ȿ� ������ ���� ���, Ȥ�� ������ �������� ���� stack�� pussh�� ������ pop -> stack����.
				if(ch == ' '||ch == '\n') {
					while(!st.isEmpty()) { System.out.print(st.pop()); }
					st.clear();
					System.out.print(" ");}
				//�׷��� ���� ���� ��� stack�� ����
				else {st.push(ch);}
				}
			System.out.println();
			}

	}
}

