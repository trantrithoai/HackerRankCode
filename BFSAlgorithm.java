import java.util.*;

public class BFSAlgorithm {
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Create the adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the adjacency list with the given edges
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u); // Since the graph is undirected
        }

        // Initialize distance array with -1 (indicating unreachable nodes)
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);

        // BFS starting from node `s`
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        distances[s] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentDistance = distances[node];

            for (int neighbor : graph.get(node)) {
                if (distances[neighbor] == -1) { // Node not visited yet
                    distances[neighbor] = currentDistance + 6; // Increment by 6 (edge weight is assumed to be 6)
                    queue.add(neighbor);
                }
            }
        }

        // Collect the result, excluding the starting node and ignoring index 0 (1-based index)
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                result.add(distances[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(1, 3),
            Arrays.asList(3, 4)
        );
        int n = 4, m = 3, s = 1;
        List<Integer> result = bfs(n, m, edges, s);
        System.out.println(result); // Expected Output: [6, 6, 12]
    }
}
