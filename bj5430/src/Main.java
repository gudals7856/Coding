import java.io.*;
import java.util.*;

public class Main {

    public static Deque<Character> r(Deque<Character> dq) {
        Deque<Character> dqNew = new ArrayDeque<>();

        while (!dq.isEmpty())
            dqNew.add(dq.pollLast());

        return dqNew;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        // t개의 테스트 케이스 수행
        for (int i = 0; i < t; i++) {

            int D_Count = 0;
            Queue<Character> q = new LinkedList<>();

            // 수행할 함수 큐에 저장
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                q.add(c);
                if (c == 'D') D_Count++;
            }

            // 배열에 들어갈 수 저장
            Deque<Character> dq = new ArrayDeque<>();
            int n = Integer.parseInt(br.readLine());

            str = br.readLine();
            str = str.substring(1, str.length() - 1);
            String[] strArr = str.split(",");

            // D의 개수가 수의 개수보다 많다면 error
            if (D_Count > n) {
                bw.write("error\n");
                continue;
            }

            for (int j = 0; j < n; j++) {
                dq.add(strArr[j].charAt(0));
            }

            boolean isReversed = false;
            while (!q.isEmpty()) {
                int c = q.poll();

                if (c == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (isReversed) dq.pollLast();
                    else dq.poll();
                }
            }

            if (isReversed) dq = r(dq);

            bw.write("[");
            while (!dq.isEmpty()) {
                bw.write(dq.poll() + "");
                if (!dq.isEmpty()) bw.write(",");
            }
            bw.write("]" + "\n");
        }
        bw.flush();
        bw.close();
    }
}