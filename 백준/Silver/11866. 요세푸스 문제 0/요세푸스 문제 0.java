import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main {
 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		
		int N = in.nextInt();
		int K = in.nextInt();
		
		
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
		/*
		 *  마지막 부분의 출력은 > 괄호 전에 공백이 없기 때문에
		 *  일괄적으로 출력하기 위해 마지막 원소만 남겨질 때까지만
		 *  반복하고 마지막 원소는 그대로 출력한다.
		 */
		while(q.size() > 1) {
			
			for(int i = 0; i < K - 1; i++) {
				int val = q.poll();
				q.offer(val);
			}
			
			sb.append(q.poll()).append(", ");
		}
 
		// 마지막 원소 출력한 뒤 > 도 붙여준다.
		sb.append(q.poll()).append('>');
		System.out.println(sb);
	}
 
}