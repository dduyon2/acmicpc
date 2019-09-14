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
		
//		test case �Է¹ޱ����� for��; ������ ���� ǥ���ϱ� ���� \n �߰�;
		for(int i=0; i<T; i++) {
			ps_arr[i] = bf.readLine();
			ps_arr[i]+='\n';
		}

//		�� �˰���
		for(int i=0; i<T; i++) {
			int count = 0; //������ ��������� ch �� ')' �� ��� empty stack ����ó���� ���ؼ�
			for(char ch: ps_arr[i].toCharArray()) {
				if(ch == '(') { sk.push(ch); } //'(' �� ��쿡 stack�� ����
				else if(ch == ')') {
					//')'�� ��쿡 stack���� ¦ ã�� '('�� pop�� ������ ��� ¦�� ã�� ��츦 ó��
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
