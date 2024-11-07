import java.io.*;
import java.util.*;

public class Main {

    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        int N = sc.nextInt();

        while (N-- > 0) {
            switch (sc.nextInt()) {
                case 1:
                    stack.push(sc.nextInt());
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;

                case 3:
                    sb.append(stack.size()).append("\n");
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case 5:
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;

                default:
                    break;
            }
        }
    }

    public static void process() {
        System.out.println(sb.toString());
    }
}