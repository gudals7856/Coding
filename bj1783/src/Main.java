import java.io.*;
import java.util.StringTokenizer;

public class Main {

//    static class Pair {
//        int row;
//        int col;
//
//        public Pair(int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
//    static int[][] move = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}};
//    static boolean[] moveCheck = new boolean[4];
//    static int answer = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 시작위치
        if (n == 1) System.out.println(1);

        // 세로 길이가 2이면 2,3번만 가능하므로 4 이상을 넘어갈 수 없다.
        else if (n == 2) System.out.println(Math.min(4, (m + 1) / 2));

        // 가로 길이가 6이하이면 1~4번을 모두 움직일 수 없으므로 4 이상을 넘어갈 수 없다.
        // 1,4번을 계속 반복하는게 최대 개수이므로 min(4,m)
        else if (m < 7) System.out.println(Math.min(4, m));
        else System.out.println(m-2);

    }

//    private static void dfs(int count, Pair now) {
//
//        for (int i = 0; i < move.length; i++) {
//
//            int r = now.row + move[i][0];
//            int c = now.col + move[i][1];
//
//            // 체스말 인덱스가 체스판 바깥이면 종료
//            if (r < 0 && r > n - 1 || c < 0 && c > m - 1) {
//                answer = Math.max(answer, count);
//                continue;
//            }
//
//            // count가 4보다 작을 때는 이동 방법을 한번씩 다 사용해야한다.
//            if (count < 4) {
//                if (moveCheck[i]) continue;
//                else {
//                    moveCheck[i] = true;
//                    dfs(count++, new Pair(r, c));
//                    moveCheck[i] = false;
//                }
//            }
//
//            // count가 4이상일 때는 이동 방법에 상관없이 이동한다.
//            else
//                dfs(count++, new Pair(r, c));
//        }
//    }
}