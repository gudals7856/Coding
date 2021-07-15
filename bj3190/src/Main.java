import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 보드의 크기 nxn
        int k = Integer.parseInt(br.readLine());  // 사과의 개수
        int X = 0;  // 현재 뱀의 위치 X 좌표
        int Y = 0;  // 현재 뱀의 위치 Y 좌표
        int time = 0;
        int[][] board = new int[n][n];        // 뱀이 위치되어있으면 1, 아니면 0
        int[][] applePos = new int[k][2];     // 사과의 위치
        Boolean eatApple = false;
        Vector<Pair> snake = new Vector<Pair>();    // 뱀이 지나온 위치 저장

        int addX = 1;   // 뱀이 늘어나는 방향 중 X축
        int addY = 0;   // 뱀이 늘어나는 방향 중 Y축

        for (int i = 0; i < k; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            applePos[i][0] = Integer.parseInt(st.nextToken()) - 1;
            applePos[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        int l = Integer.parseInt(br.readLine());
        String[][] changeDir = new String[l][2];

        for (int i = 0; i < l; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            changeDir[i][0] = st.nextToken();   // 숫자 - 이후에 숫자로 바꾸어 계산
            changeDir[i][1] = st.nextToken();   // 문자
        }

        board[0][0] = 1;

        snake.add(new Pair(0, 0));

        while (true) {      // 벽에 부딪히면 끝남

            // 뱀의 방향 변환 정보 확인
            for (int i = 0; i < l; i++) {
                if (Integer.parseInt(changeDir[i][0]) == time) {
                    // 뱀의 이동방향 전환
                    if (changeDir[i][1].equals("L")) {
                        if (addX == 1 && addY == 0) {
                            addX = 0;
                            addY = -1;
                        }
                        else if (addX == 0 && addY == 1) {
                            addX = 1;
                            addY = 0;
                        }
                        else if (addX == -1 && addY == 0) {
                            addX = 0;
                            addY = 1;
                        }
                        else if (addX == 0 && addY == -1) {
                            addX = -1;
                            addY = 0;
                        }
                    }
                    else if (changeDir[i][1].equals("D")) {
                        if (addX == 1 && addY == 0) {
                            addX = 0;
                            addY = 1;
                        } else if (addX == 0 && addY == 1) {
                            addX = -1;
                            addY = 0;
                        } else if (addX == -1 && addY == 0) {
                            addX = 0;
                            addY = -1;
                        } else if (addX == 0 && addY == -1) {
                            addX = 1;
                            addY = 0;
                        }
                    }
                }
            }
            X += addX;
            Y += addY;
            time++;

            // 사과를 먹는지 확인
            for (int i = 0; i < k; i++) {
                if (applePos[i][0] == Y && applePos[i][1] == X) {   // 현재 뱀이 사과의 위치에 있다면
                    eatApple = true;    // 사과를 먹었다고 표시해줌
                    applePos[i][0] = n;
                    applePos[i][1] = n;
                }
            }

            // 뱀이 벽에 부딪히면 끝남
            if (X >= n || X < 0 || Y >= n || Y < 0) {
                break;
            }
            // 뱀이 자기 자신에 부딪히면 끝남
            if(board[Y][X] == 1)
                break;

            board[Y][X] = 1;

            // 뱀의 새로운 위치를 저장
            snake.add(new Pair(Y, X));

            // 뱀이 사과를 먹지 않았다면
            if (eatApple == false) {
                board[snake.get(0).first][snake.get(0).second] = 0;    // 뱀의 길이를 줄여줌
                snake.remove(0);
            }
            eatApple = false;   // 사과 먹었는지 여부를 false로 바꾸어놓음
        }
        bw.write(time+"");
        bw.flush();
        bw.close();
    }
    static class Pair {
        int first, second;

        Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }
}
