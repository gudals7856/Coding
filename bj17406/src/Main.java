import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, k;
    static int[][] arr;
    static int[][] arrCpy;
    static int[][] rotateInfo;
    static int[] order;   // 회전 시키는 순서
    static boolean[] isChecked;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        order = new int[k];
        isChecked = new boolean[k];
        arr = new int[n + 1][m + 1];
        arrCpy = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arrCpy[i][j] = arr[i][j];
            }
        }

        rotateInfo = new int[k][3];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                rotateInfo[i][j] = Integer.parseInt(st.nextToken());
        }

        permutation(0);

        bw.write(min + "");
        bw.flush();
        bw.close();
    }

    private static void permutation(int c) {
        if (c == k) {
            for (int i = 0; i < k; i++)
                rotate(order[i]);

            min = Math.min(getMinSum(), min);

            for (int i = 0; i < n + 1; i++)
                arr[i] = arrCpy[i].clone();
        }

        for (int i = 0; i < k; i++) {
            if (!isChecked[i]) {
                order[c] = i;
                isChecked[i] = true;
                permutation(c + 1);
                isChecked[i] = false;
            }
        }
    }

    private static int getMinSum() {
        int sum = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            sum = Math.min(IntStream.of(arr[i]).sum(), sum);
        }
        return sum;
    }

    // idx : rotateInfo의 순서
    private static void rotate(int idx) {
        int r = rotateInfo[idx][0];
        int c = rotateInfo[idx][1];
        int s = rotateInfo[idx][2];
        int[][] tmpArr = new int[n + 1][m + 1];

        // 회전 안하는 가운데 값 저장
        tmpArr[r][c] = arr[r][c];

        // 안쪽부터 차례대로 회전을 진행
        for (int i = 1; i <= s; i++) {
            int[] now = {r - i, c - i};
            int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
            int[][] corner = {{r-i, c+i}, {r+i,c+i}, {r+i,c-i}, {r-i, c-i}};
            int dir = 0;

            while (dir < 4) {
                tmpArr[now[0] + direction[dir][0]][now[1] + direction[dir][1]] = arr[now[0]][now[1]];
                now[0] += direction[dir][0];
                now[1] += direction[dir][1];

                if (now[0] == corner[dir][0] && now[1] == corner[dir][1])
                    dir++;
            }
        }

        for (int i = r - s; i <= r + s; i++)
            for (int j = c - s; j <= c + s; j++)
                arr[i][j] = tmpArr[i][j];
    }
}
