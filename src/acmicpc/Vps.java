package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

public class Vps {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Character> sk = new Stack<Character>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		String ps_arr[] = new String[T];
		
//		test case 입력받기위한 for문; 마지막 임을 표시하기 위해 \n 추가;
		for(int i=0; i<T; i++) {
			ps_arr[i] = bf.readLine();
			ps_arr[i]+='\n';
		}

//		본 알고리즘
		for(int i=0; i<T; i++) {
			int count = 0; //스택이 비어있지만 ch 가 ')' 일 경우 empty stack 예외처리를 위해서
			for(char ch: ps_arr[i].toCharArray()) {
				if(ch == '(') { sk.push(ch); } //'(' 일 경우에 stack에 삽입
				else if(ch == ')') {
					//')'일 경우에 stack에서 짝 찾아 '('을 pop할 거지만 모두 짝을 찾은 경우를 처리
					if(sk.isEmpty()) {	
						count += 1;
						continue;}
					sk.pop();
				}
			}
			if(sk.isEmpty() && count==0) { System.out.println("YES");}
			else { System.out.println("NO");}
			sk.clear();
		}
	}
}
