import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int n, m, k;
    static int[][] board;
    static int answer;
    static Queue<int[][]> stickers = new LinkedList<>();

    // 90도 회전
    public static int[][] rotate(int[][] sticker, int r, int c) {
        int[][] newSticker = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                newSticker[i][j] = sticker[r - 1 - j][i];
            }
        }
        return newSticker;
    }

    public static boolean move(int[][] sticker, int r, int c) {
        int rSub = n - r;   // 노트북과 스티커의 세로 크기 차이
        int cSub = m - c;   // 노트북과 스티커의 가로 크기 차이
        ArrayList<Pair> list = new ArrayList<>(); // 스티커 내에서 1이 존재하는 위치 저장

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] == 1) list.add(new Pair(i, j));
            }
        }

        for (int a = 0; a <= rSub; a++) {
            for (int b = 0; b <= cSub; b++) {
                int count = 0;

                // 스티커를 붙일 수 있는지 여부 판단
                for (Pair pair : list)
                    if (board[pair.row + a][pair.col + b] == 0) count++;

                // 스티커를 붙일 수 있다면 붙이고 answer 증가 후 return true
                if (count == list.size()) {
                    for (Pair pair : list) {
                        board[pair.row + a][pair.col + b] = 1;
                    }
                    answer += list.size();
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        // k개의 스티커에 대한 정보
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[r][c];
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < c; l++)
                    sticker[j][l] = Integer.parseInt(st.nextToken());
            }
            stickers.add(sticker);
        }

        // 큐에서 스티커를 하나씩 빼서 붙여봄
        while (!stickers.isEmpty()) {
            int[][] sticker = stickers.poll();
            int rotateCount = 0;

            while (rotateCount < 4) {
                int r = sticker.length;     // 현재 스티커 행
                int c = sticker[0].length;  // 현재 스티커 열

                // 스티커가 노트북 크기에 맞지 않으면 돌림
                if (r > n || c > m) {
                    sticker = rotate(sticker, r, c);
                    rotateCount++;
                    continue;
                }

                // 스티커가 모눈종이에 들어가면 다음 스티커 확인
                if (move(sticker, r, c)) break;

                // 모눈종이에 들어가지 못하면 회전
                sticker = rotate(sticker, r, c);
                rotateCount++;
            }
        }
        System.out.println(answer);
    }
}
