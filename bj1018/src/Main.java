import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mn = br.readLine();
        int m = Integer.parseInt(mn.split(" ")[0]);
        int n = Integer.parseInt(mn.split(" ")[1]);

        String[] boardStr = new String[m];
        for(int i=0; i<m; i++)
            boardStr[i] = br.readLine();

        char[][] board = new char[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
                board[i][j] = boardStr[i].charAt(j);
        }

        int result = getmin(board, n, m);
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }

    public static int getmin(char[][] board, int n, int m) {
        int min = 64;
        int count = 0;
        int k;
        int l;
        char[][] boardCut = new char[8][8];
        char[][] black = {{'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'}
        };
        char[][] white = {{'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'}
        };

        // 체스판을 나누는 횟수만큼 반복문을 진행한다.
        for(int i=0; i<m-7; i++)
        {
            for(int j=0; j<n-7; j++)
            {
                // 8*8 체스판을 만든다
                for(k=i; k<i+8; k++)
                {
                    for(l=j; l<j+8; l++)
                        boardCut[k-i][l-j] = board[k][l];
                }

                // 다시칠해야하는 부분을 찾아낸다.
                for(int c=0; c<2; c++)	// c=0이면 white와 비교, 1이면 black과 비교
                {
                    for(int a=0; a<8; a++)
                    {
                        for(int b=0; b<8; b++)
                        {
                            if(c==0)
                            {
                                if(boardCut[a][b] != white[a][b])
                                    count++;
                            }
                            else if(c==1)
                            {
                                if(boardCut[a][b] != black[a][b])
                                    count++;
                            }
                        }
                    }
                    if(count < min)
                        min = count;
                    count = 0;
                }
            }
        }
        return min;
    }
}
