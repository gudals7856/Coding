import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> card = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            card.add(i);
        }

        while (card.size() > 1) {
            card.remove();
            int top = card.poll();
            card.add(top);
        }

        bw.write(card.poll() + "");
        bw.flush();
        bw.close();
    }
}
