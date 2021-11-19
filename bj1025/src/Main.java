import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        int answer = -1;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = str.charAt(j);
        }

        // 표를 (moveR, moveC) 만큼 이동하며 수를 만들 것이다.
        for (int moveR = -8; moveR <= 8; moveR++) {
            for (int moveC = -8; moveC <= 8; moveC++) {

                if (moveR == 0 && moveC == 0) continue;

                StringBuilder sb = new StringBuilder();
                // 표 바깥으로 벗어나지 않을 때까지 수를 붙인다.
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int r = i, c = j;
                        while (r >= 0 && r < n && c >= 0 && c < m) {
                            sb.append(board[r][c]);
                            r += moveR;
                            c += moveC;

                            int squareNum = Integer.parseInt(sb.toString());

                            // 제곱수 찾기
                            int num = 0;
                            while (num * num <= squareNum) {
                                if (num * num == squareNum)
                                    answer = Math.max(answer, squareNum);
                                num++;
                            }
                        }
                        sb.setLength(0);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
