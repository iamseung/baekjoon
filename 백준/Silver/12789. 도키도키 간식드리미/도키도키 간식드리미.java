import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());// 학생 수
		
		Queue<Integer> q = new LinkedList<>();	// 대기열
		Stack<Integer> s = new Stack<>();	//추가 대기열
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<N;i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		int start = 1;	// 간식 먹는 순서
		
		while(!q.isEmpty()) {	// 대기열에서 학생수가 없어질 때 까지
			if(q.peek() == start) {	//간식먹는 순서라면
				q.poll();
				start++;
			}else if(!s.isEmpty() && s.peek() == start) {	// 스택도 대기열이므로 스택 검사도 해야 한다.
				s.pop();
				start++;
			}else {	// 큐 대기열에 있는 학생의 순서가 start와 동일하지 않으면
				s.push(q.poll());	// 큐에서 빼서 스택에 집어넣는다.
			}
		}
		while(!s.isEmpty()) {	// 스택에 학생 남아있다면 간식 순서로 나오는지 확인
			if(s.peek() == start) {	// 간식 순서 맞음
				s.pop();
				start++;
			}else {	// 간식 순서 틀림
				System.out.println("Sad");
				return;
			}
		}
		System.out.println("Nice");
		
		
	}

}