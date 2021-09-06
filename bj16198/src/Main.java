import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> energe = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            energe.add(Integer.parseInt(st.nextToken()));

        func(energe, 0);

        System.out.println(max);
    }

    public static void func(ArrayList<Integer> energe, int sum) {

        // 크기가 2가 되면 종료
        if (energe.size() == 2) {
            max = Math.max(max, sum);
            return;
        }

        // 처음과 끝 인덱스를 제외한 원소를 돌며 에너지를 더하고, 재귀 반복
        int size = energe.size();
        for (int i = 1; i < size - 1; i++) {
            int nowValue = energe.get(i);
            int nextSum = sum + energe.get(i - 1) * energe.get(i + 1);
            energe.remove(i);
            func(energe, nextSum);
            energe.add(i, nowValue);
        }
    }
}
