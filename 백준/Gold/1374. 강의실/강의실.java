import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] lectureSchedule;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());

        int startTime, endTime;
        StringTokenizer st;
        lectureSchedule = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            startTime = Integer.parseInt(st.nextToken());
            endTime = Integer.parseInt(st.nextToken());

            lectureSchedule[i][0] = startTime;
            lectureSchedule[i][1] = endTime;
        }
    }

    static void process() {
        // 시작 시간이 같다면 종료 시간이 빠른 순, 시작 시간이 빠른 순으로 정렬
        Arrays.sort(lectureSchedule, (a, b) -> ((a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]));

        // Queue 에는 종료 시간을 적재
        PriorityQueue<Integer> que = new PriorityQueue<>();

        int max = 1;
        for (int i = 0; i < N; i++) {
            // 강의의 시작시간이 큐의 적재된 종료 시간보다 크거나 같을 경우
            if (!que.isEmpty() && que.peek() <= lectureSchedule[i][0]) {
                que.poll();
            }

            que.add(lectureSchedule[i][1]);

            // 현재 진행 중인 강의실 수의 최대 값, 필요한 강의실 개수를 저장
            max = Math.max(max, que.size());
        }

        System.out.println(max);
    }
}