package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// ä����� : �޸� �ʰ�

public class Stack_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<Integer>();
		
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		
		// ��� �����ϱ� ���� String
		String str = "";
		
		// test_case �Է¹���
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		int stack_num = 0;
		
		// stack�˰���
		for (int i = 0; i < n; i++) {
			// stack�� ���� ������ �̰����ϴ� ���� �� ũ�ٸ� ���ÿ� �� �����ϰ� pop�ؾ��ϴ� ���
			if (stack_num < arr[i]) {
				// �̰����ϴ� ������ �����ϴ� while��
				while(arr[i]>stack_num) {
					st.push(++stack_num);
					str += "+";
				}
				//��� �����ߴٸ� �̰����ϴ� �� pop
				st.pop();
				str += "-";
				
			// �̰��� �ϴ� ���� �̹� stack�� �ִ� ���
			} else {
				boolean found = false;
				if(!st.empty()) {
					int top = st.peek();
					st.pop();
					str += "-";
					// �� �߿����� �̰����ϴ� ���� top�� �ƴ� �� ���ʿ� ���� ���
					if(arr[i] == top) {found = true;}
				}
				if(!found) {
					str = "NO";
					break;
				}
			}
		}
		
		//��� ��� 
		if(str!="NO") {
			for(char ch : str.toCharArray()) {
				System.out.println(ch);
			}
		}
		else {System.out.println(str);}
	}

}
