import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int end, weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static int n, m, k, x;  // 도시 개수, 도로 개수, 거리 정보, 출발 도시 번호
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        boolean[] nodeCheck = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        edges = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges[start].add(new Edge(end, 1));
        }

        Queue<Edge> q = new LinkedList<>(edges[x]);
        q.add(new Edge(x, 0));

        while (!q.isEmpty()) {
            int vertex = q.peek().end;
            int weight = q.peek().weight;
            q.poll();

            if (nodeCheck[vertex]) continue;
            if (weight > k) break;

            nodeCheck[vertex] = true;
            if (dist[vertex] > weight) dist[vertex] = weight;

            for (int i = 0; i < edges[vertex].size(); i++) {
                Edge edge = edges[vertex].get(i);
                q.add(new Edge(edge.end, weight + 1));
            }
        }

        int count = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == k) {
                System.out.println(i);
                count++;
            }
        }
        if (count == 0) System.out.println(-1);
    }
}
