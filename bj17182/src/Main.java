import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[] check;

    public static void floyd_warshall(int mid) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // mid 정점을 지나가지 않는 경로에 대해서만 생각
                if (i != mid && j != mid) {
                    board[i][j] = Math.min(board[i][j], board[i][mid] + board[mid][j]);
                }
            }
        }
    }

    public static void search(int depth, int k, int sum) {
        // 마지막 정점에 도착했을 때 시간은 더하지 않아도 되므로 depth = n으로
        if (depth == n) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i] && i != k) {
                check[i] = true;
                sum += board[k][i];
                search(depth + 1, i, sum);   // 다음번엔 i -> ?로 가는 경우의 수 탐색
                check[i] = false;
                sum -= board[k][i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        // 플로이드워샬 알고리즘 진행
        // 1~n번째 정점을 거쳐갈 때의 최소비용을 갱신해준다.
        for (int i = 0; i < n; i++) {
            floyd_warshall(i);
        }
        
        // 모든 정점들을 방문하는 경우의 수를 완전탐색하여 최소비용을 찾는다.
        check[k] = true;    // 시작 정점은 이미 방문하였음
        search(1, k, 0);

        System.out.println(min);
    }
}
