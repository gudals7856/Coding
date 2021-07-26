import java.io.*;
import java.util.*;


public class Main {

    static BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] board;
    static int n;
    static int k;
    static int[][] pieceInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int turn = 1;

        StringTokenizer NK = new StringTokenizer(br.readLine());
        n = Integer.parseInt(NK.nextToken());
        k = Integer.parseInt(NK.nextToken());
        board = new int[n*n][k+1];  // 색깔 저장 + k개의 말을 저장할 위치
        pieceInfo = new int[k][3];

        // 0:흰색, 1:빨간색, 2:파란색
        for (int i = 0; i < n; i++) {
            StringTokenizer boardStr = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i*n+j][0] = Integer.parseInt(boardStr.nextToken());
            }
        }

        // 행 번호, 열번호, 이동방향(1:오른쪽, 2:왼쪽, 3:위, 4:아래)
        for (int i = 0; i < k; i++) {
            StringTokenizer pieceStr = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                pieceInfo[i][0] = Integer.parseInt(pieceStr.nextToken());   // 행번호
                pieceInfo[i][1] = Integer.parseInt(pieceStr.nextToken());   // 열번호
                pieceInfo[i][2] = Integer.parseInt(pieceStr.nextToken());   // 말 이동방향
            }
        }

        while (turn < 1000) {
            for (int i = 0; i < k; i++) {
                changePosition(i);
            }
        }
    }

    // num : 말의 번호
    public static void changePosition(int num) {
        Boolean check = false;
        Deque<Integer> deque = new ArrayDeque<Integer>();

        // 말의 이동 방향 확인
        switch (pieceInfo[num][2]) {
            case 1: // 오른쪽
                // 이동한 말의 위치에 체스말이 있는지 확인하고 체스말 삽입
                for (int i = 0; i < k; i++) {
                    if (board[pieceInfo[num][0] * n + pieceInfo[num][1]][i] != num) {
                        board[pieceInfo[num][0] * n + pieceInfo[num][1]][i] = 0;
                        check = true;
                    }
                    pieceInfo[num][1] = pieceInfo[num][1] + 1;
                    if (board[pieceInfo[num][0] * n + pieceInfo[num][1]][i] == 0) {
                        board[pieceInfo[num][0] * n + pieceInfo[num][1]][i] = num;
                    }
                }
                break;
            case 2: // 왼쪽
                pieceInfo[num][1] = pieceInfo[num][1] - 1;
                break;
            case 3: // 위
                pieceInfo[num][0] = pieceInfo[num][0] - 1;
                break;
            case 4: // 아래
                pieceInfo[num][0] = pieceInfo[num][0] + 1;
                break;
        }
    }
}
