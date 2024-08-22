import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Main {
    public static int cookies(int k, List<Integer> A) {
        // Use a priority queue to keep the smallest elements at the front
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        int count = 0;

        // Continue while the smallest element is less than k
        while (minHeap.size() > 1 && minHeap.peek() < k) {
            // Combine the two smallest elements
            int leastSweet = minHeap.poll();
            int secondLeastSweet = minHeap.poll();
            int combinedSweetness = leastSweet + 2 * secondLeastSweet;

            // Add the new element back into the heap
            minHeap.add(combinedSweetness);
            count++;
        }

        // Check if the smallest element now meets the requirement
        if (minHeap.peek() < k) {
            return -1;
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> sweetness = Arrays.asList(1, 2, 3, 9, 10, 12);
        int result = cookies(7, sweetness);  // Output: 2
        System.out.println(result);
    }
}
