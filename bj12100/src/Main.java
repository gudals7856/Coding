import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] board;
    static boolean[][] check;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move(0);
        System.out.println(max);
    }

    public static void move(int depth) {
        if (depth == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }

        int[][] boardTmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            boardTmp[i] = board[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            if (i == 0) left();
            else if (i == 1) right();
            else if (i == 2) up();
            else down();

            for (int j = 0; j < n; j++) {
                Arrays.fill(check[j], false);
            }

            move(depth + 1);

            // 함수 진행 전 원래 배열로 되돌림
            for (int j = 0; j < n; j++) {
                board[j] = boardTmp[j].clone();
            }
        }
    }

    public static void up() {
        // 맨 윗줄을 제외하고 그 아랫줄부터 위로 올려가며 확인
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) continue;

                int tmpI = i - 1, tmpJ = j;
                while (tmpI >= 0) {
                    if (tmpI == 0 && board[tmpI][tmpJ] == 0) {
                        board[tmpI][tmpJ] = board[i][j];
                        board[i][j] = 0;
                        break;
                    }
                    if (board[tmpI][tmpJ] == board[i][j]) {
                        if (check[tmpI][tmpJ]) {
                            board[tmpI + 1][tmpJ] = board[i][j];
                            board[i][j] = 0;
                            break;
                        }
                        board[tmpI][tmpJ] *= 2;
                        check[tmpI][tmpJ] = true;
                        board[i][j] = 0;
                        break;
                    }
                    if (board[tmpI][tmpJ] != 0 && board[tmpI][tmpJ] != board[i][j]) {
                        if (tmpI + 1 == i) break;
                        board[tmpI + 1][tmpJ] = board[i][j];
                        board[i][j] = 0;
                        break;
                    }
                    tmpI--;
                }
            }
        }
    }

    public static void down() {
        // 맨 아랫줄을 제외하고 그 윗줄부터 아래로 내려가며 확인
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) continue;

                int tmpI = i + 1, tmpJ = j;
                while (tmpI < n) {
                    if (tmpI == n - 1 && board[tmpI][tmpJ] == 0) {
                        board[tmpI][tmpJ] = board[i][j];
                        board[i][j] = 0;
                        break;
                    }
                    if (board[tmpI][tmpJ] == board[i][j]) {
                        if (check[tmpI][tmpJ]) {
                            board[tmpI - 1][tmpJ] = board[i][j];
                            board[i][j] = 0;
                            break;
                        }
                        board[tmpI][tmpJ] *= 2;
                        check[tmpI][tmpJ] = true;
                        board[i][j] = 0;
                        break;
                    }
                    if (board[tmpI][tmpJ] != 0 && board[tmpI][tmpJ] != board[i][j]) {
                        if (tmpI - 1 == i) break;
                        board[tmpI - 1][tmpJ] = board[i][j];
                        board[i][j] = 0;
                        break;
                    }
                    tmpI++;
                }
            }
        }
    }

    public static void left() {
        // 맨 왼쪽 줄을 제외하고 그 오른쪽 줄부터 확인
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (board[i][j] == 0) continue;

                int tmpI = i, tmpJ = j - 1;
                while (tmpJ >= 0) {
                    if (tmpJ == 0 && board[tmpI][tmpJ] == 0) {
                        board[tmpI][tmpJ] = board[i][j];
                        board[i][j] = 0;
                        break;
                    }
                    if (board[tmpI][tmpJ] == board[i][j]) {
                        if (check[tmpI][tmpJ]) {
                            board[tmpI][tmpJ + 1] = board[i][j];
                            board[i][j] = 0;
                            break;
                        }
                        board[tmpI][tmpJ] *= 2;
                        check[tmpI][tmpJ] = true;
                        board[i][j] = 0;
                        break;
                    }
                    if (board[tmpI][tmpJ] != 0 && board[tmpI][tmpJ] != board[i][j]) {
                        if (tmpJ + 1 == j) break;
                        board[tmpI][tmpJ + 1] = board[i][j];
                        board[i][j] = 0;
                        break;
                    }
                    tmpJ--;
                }
            }
        }
    }

    public static void right() {
        // 맨 오른쪽 줄을 제외하고 그 왼쪽 줄부터 확인
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (board[i][j] == 0) continue;

                int tmpI = i, tmpJ = j + 1;
                while (tmpJ < n) {
                    if (tmpJ == n - 1 && board[tmpI][tmpJ] == 0) {
                        board[tmpI][tmpJ] = board[i][j];
                        board[i][j] = 0;
                        break;
                    }
                    if (board[tmpI][tmpJ] == board[i][j]) {
                        if (check[tmpI][tmpJ]) {
                            board[tmpI][tmpJ - 1] = board[i][j];
                            board[i][j] = 0;
                            break;
                        }
                        board[tmpI][tmpJ] *= 2;
                        check[tmpI][tmpJ] = true;
                        board[i][j] = 0;
                        break;
                    }
                    if (board[tmpI][tmpJ] != 0 && board[tmpI][tmpJ] != board[i][j]) {
                        if (tmpJ - 1 == j) break;
                        board[tmpI][tmpJ - 1] = board[i][j];
                        board[i][j] = 0;
                        break;
                    }
                    tmpJ++;
                }
            }
        }
    }
}
