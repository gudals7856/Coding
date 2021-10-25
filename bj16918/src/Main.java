import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int r, c, n;
    static char[][] board;
    static Queue<Pair> q = new LinkedList<>();

    public static void explode() {
        while (!q.isEmpty()) {
            Pair now = q.poll();
            int[][] dir = new int[][] {{1,0}, {0,-1}, {-1,0}, {0,1}};

            // 큐에 저장된 폭탄과 상하좌우 자리를 터뜨림 
            board[now.row][now.col] = '.';
            for (int i = 0; i < 4; i++) {
                if (now.row + dir[i][0] >= 0 && now.row + dir[i][0] < r && now.col + dir[i][1] >= 0 && now.col + dir[i][1] < c) {
                    board[now.row + dir[i][0]][now.col + dir[i][1]] = '.';
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int second = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);
                
                // 폭탄이 있으면 위치를 큐에 삽입
                if (board[i][j] == 'O') q.add(new Pair(i, j));
            }
        }

        while (second < n) {
            if (second == 0) {  // 0초일 때는 그대로
                second++;
                continue;
            }

            // 홀수 초일 때는 빈자리에 폭탄을 채움
            if (second % 2 == 1) {
                for (int i = 0; i < r; i++)
                    Arrays.fill(board[i], 'O');
            }

            // 짝수 초일 때는 큐에 폭발시키고 남은 폭탄들의 위치를 큐에 삽입
            else {
                explode();
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (board[i][j] == 'O') q.add(new Pair(i, j));
                    }
                }
            }
            second++;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
