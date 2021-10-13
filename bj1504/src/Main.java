import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int end, weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int n, e;
    static ArrayList<Edge>[] edges;
    static boolean[] check;
    static int[] must = new int[2];
    static int[] weights;

    public static int dijkstra(int start, int end) {
        int min = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            int nowVertex = pq.peek().end;
            int nowWeight = pq.peek().weight;
            pq.poll();

            if (nowVertex == end) {
                min = nowWeight;
                break;
            }

            if (check[nowVertex]) continue;

            check[nowVertex] = true;

            for (int i = 0; i < edges[nowVertex].size(); i++) {
                int nextVertex = edges[nowVertex].get(i).end;
                int nextWeight = nowWeight + edges[nowVertex].get(i).weight;

                if (nextWeight < weights[nextVertex]) weights[nextVertex] = nextWeight;

                if (!check[nextVertex]) pq.add(new Edge(nextVertex, nextWeight));
            }
        }

        Arrays.fill(check, false);
        Arrays.fill(weights, Integer.MAX_VALUE);
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        check = new boolean[n + 1];

        weights = new int[n + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);

        edges = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[start].add(new Edge(end, weight));
            edges[end].add(new Edge(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        must[0] = Integer.parseInt(st.nextToken());
        must[1] = Integer.parseInt(st.nextToken());

        int d2 = dijkstra(must[0], must[1]);

        int answer = Math.min(dijkstra(1, must[0]) + d2 + dijkstra(must[1], n),
                dijkstra(1, must[1]) + d2 + dijkstra(must[0], n));

        if (answer == 0) System.out.println(-1);
        else System.out.println(answer);
    }
}
