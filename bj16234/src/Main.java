import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Pair> unionArr = new ArrayList<>();
    static int[][] land;
    static int[][] union;
    static int n;
    static int l;
    static int r;
    static int popSum;



    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        land = new int[n][n];
        union = new int[n][n];
        int count = 1;  // 연합 개수 + 1 (union배열 초기값이 0이라서 1로 초기화했음)
        int day = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    unionArr.clear();
                    popSum = 0;

                    // 아직 연합을 만들지 않은 땅에서만 진행
                    if (union[i][j] == 0) {
                        union[i][j] = count;
                        merge(i, j, count);

                        // 같은 연합끼리 인구 이동
                        if (unionArr.size() > 1) {
                            int popAvg = popSum / unionArr.size();
                            for (int k = 0; k < unionArr.size(); k++) {
                                land[unionArr.get(k).x][unionArr.get(k).y] = popAvg;
                            }
                        }
                        count++;
                    }
                }
            }

            // 인구이동이 일어나지 않으면 count가 (배열의 크기+1)일 것이므로 이동 중단
            if (count == n * n + 1)
                break;

            day++;
            count = 1;

            // 다시 연합생성 여부를 0으로 초기화
            for (int i = 0; i < n; i++) {
                Arrays.fill(union[i], 0);
            }
        }

        bw.write(day + "");
        bw.flush();
        bw.close();
    }

    public static void merge (int row, int col, int count) {
        int p = land[row][col];
        unionArr.add(new Pair(row, col));
        popSum += p;

        // 인접한 땅이 존재하고, 인구수 차이가 l과 r 사이라면
        if (col - 1 >= 0) {
            if (Math.abs(p - land[row][col - 1]) >= l && Math.abs(p - land[row][col - 1]) <= r && union[row][col - 1] == 0) {
                union[row][col - 1] = count;
                merge(row, col - 1, count);
            }
        }
        if (col + 1 < n) {
            if (Math.abs(p - land[row][col + 1]) >= l && Math.abs(p - land[row][col + 1]) <= r && union[row][col + 1] == 0) {
                union[row][col + 1] = count;
                merge(row, col + 1, count);
            }
        }
        if (row - 1 >= 0) {
            if (Math.abs(p - land[row - 1][col]) >= l && Math.abs(p - land[row - 1][col]) <= r && union[row - 1][col] == 0) {
                union[row - 1][col] = count;
                merge(row - 1, col, count);
            }
        }
        if (row + 1 < n) {
            if (Math.abs(p - land[row + 1][col]) >= l && Math.abs(p - land[row + 1][col]) <= r && union[row + 1][col] == 0) {
                union[row + 1][col] = count;
                merge(row + 1, col, count);
            }
        }
        return;
    }

}
