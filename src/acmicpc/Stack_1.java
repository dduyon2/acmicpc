package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 채점결과 : 메모리 초과

public class Stack_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<Integer>();
		
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		
		// 결과 저장하기 위한 String
		String str = "";
		
		// test_case 입력받음
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		int stack_num = 0;
		
		// stack알고리즘
		for (int i = 0; i < n; i++) {
			// stack에 넣은 수보다 뽑고자하는 수가 더 크다면 스택에 더 삽입하고 pop해야하는 경우
			if (stack_num < arr[i]) {
				// 뽑고자하는 수까지 삽입하는 while문
				while(arr[i]>stack_num) {
					st.push(++stack_num);
					str += "+";
				}
				//모두 삽입했다면 뽑고자하는 수 pop
				st.pop();
				str += "-";
				
			// 뽑고자 하는 수가 이미 stack에 있는 경우
			} else {
				boolean found = false;
				if(!st.empty()) {
					int top = st.peek();
					st.pop();
					str += "-";
					// 그 중에서도 뽑고자하는 수가 top이 아닌 더 안쪽에 있을 경우
					if(arr[i] == top) {found = true;}
				}
				if(!found) {
					str = "NO";
					break;
				}
			}
		}
		
		//결과 출력 
		if(str!="NO") {
			for(char ch : str.toCharArray()) {
				System.out.println(ch);
			}
		}
		else {System.out.println(str);}
	}

}
