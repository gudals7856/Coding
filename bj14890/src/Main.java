import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int l;
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int before = 0;

        // 가로 길 확인
        for (int i = 0; i < n; i++) {
            int count = 1;  // 같은 높이의 연속된 칸의 개수
            boolean flag = false;   // 이전에 현재 칸보다 높은 칸이 있었는지 여부
            boolean isPossible = false;
            for (int j = 1; j < n; j++) {
                before = board[i][j - 1];

                // 칸의 높이 차이가 2이상이면 불가능
                if (Math.abs(before - board[i][j]) >= 2) break;

                // 현재 칸이 이전 칸보다 1 높을 때
                else if (board[i][j] - before == 1) {
                    if (count >= l) {
                        if(count == 1 && l == 1 && flag) break;
                        count = 1;
                    }
                    else break;
                }

                // 현재 칸이 이전 칸보다 1 낮을 때
                else if (board[i][j] - before == -1) {
                    if (flag && count < l) break;
                    flag = true;
                    count = 1;
                }

                // 현재 칸과 이전 칸이 같은 높이일 때
                else {
                    if (l == 1 && count == 1 && flag) {
                        flag = false;
                        count = 0;
                    }

                    count++;

                    if (flag && count == l) {
                        flag = false;
                        count = 0;
                    }
                }

                if (j == n - 1) {
                    if (l == 1) isPossible = true;
                    if (!flag || count == l) isPossible = true;
                }
            }
            if (isPossible) answer++;
        }

        // 세로 길 확인
        for (int j = 0; j < n; j++) {
            int count = 1;  // 같은 높이의 연속된 칸의 개수
            boolean flag = false;   // 이전에 현재 칸보다 높은 칸이 있었는지 여부
            boolean isPossible = false;
            for (int i = 1; i < n; i++) {
                before = board[i - 1][j];

                // 칸의 높이 차이가 2이상이면 불가능
                if (Math.abs(before - board[i][j]) >= 2) break;

                // 현재 칸이 이전 칸보다 1 높을 때
                else if (board[i][j] - before == 1) {
                    if (count >= l) {
                        if(count == 1 && l == 1 && flag) break;
                        count = 1;
                    }
                    else break;
                }

                // 현재 칸이 이전 칸보다 1 낮을 때
                else if (board[i][j] - before == -1) {
                    if (flag && count < l) break;
                    flag = true;
                    count = 1;
                }

                // 현재 칸과 이전 칸이 같은 높이일 때
                else {
                    if (l == 1 && count == 1 && flag) {
                        flag = false;
                        count = 0;
                    }

                    count++;

                    if (flag && count == l) {
                        flag = false;
                        count = 0;
                    }
                }

                if (i == n - 1) {
                    if (l == 1) isPossible = true;
                    if (!flag || count == l) isPossible = true;
                }
            }
            if (isPossible) answer++;
        }

        System.out.println(answer);
    }
}
