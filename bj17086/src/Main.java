import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair {
        int r, c, d;
        public Pair(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static int n, m;
    static int[][] board;
    static boolean[][] isChecked;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        isChecked = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int[][] dir = new int[][]{{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0}};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) continue;

                isChecked[i][j] = true;
                q.add(new Pair(i, j, 0));

                while (!q.isEmpty()) {
                    boolean flag = false;
                    int r = q.peek().r;
                    int c = q.peek().c;
                    int depth = q.peek().d;
                    q.poll();

                    for (int k = 0; k < dir.length; k++) {
                        if ((r + dir[k][0] >= 0 && r + dir[k][0] < n && c + dir[k][1] >= 0 && c + dir[k][1] < m) && !isChecked[r + dir[k][0]][c + dir[k][1]]) {
                            if (board[r + dir[k][0]][c + dir[k][1]] == 1) {
                                answer = Math.max(answer, depth + 1);
                                flag = true;
                            }
                            isChecked[r + dir[k][0]][c + dir[k][1]] = true;
                            q.add(new Pair(r + dir[k][0], c + dir[k][1], depth + 1));
                        }
                        if (flag){
                            q.clear();
                            break;
                        }
                    }
                    if (flag) break;
                }

                for (int k = 0; k < isChecked.length; k++) {
                    Arrays.fill(isChecked[k], false);
                }
            }
        }
        System.out.println(answer);
    }
}

