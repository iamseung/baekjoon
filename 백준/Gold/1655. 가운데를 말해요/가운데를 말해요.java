import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < N; i++) {
            int Number = Integer.parseInt(br.readLine());

            if (minHeap.size() == maxHeap.size())
                maxHeap.offer(Number);
            else
                minHeap.offer(Number);

            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                // maxHeap 의 가장 큰 값이 minHeap 의 가장 작은 값보다 크다면 swap
                if (minHeap.peek() < maxHeap.peek()) {
                    int temp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(temp);
                }
            }

            sb.append(maxHeap.peek() + "\n");
        }

        System.out.println(sb.toString());
    }
}