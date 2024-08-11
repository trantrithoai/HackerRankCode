import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int command = in.nextInt();
            if (command == 1) {
                q.add(in.nextInt());
            } else if (command == 2) {
                if (!q.isEmpty()) {
                    q.poll();  // dequeue the front element
                }
            } else if (command == 3) {
                if (!q.isEmpty()) {
                    System.out.println(q.peek());  // print the front element
                }
            }
        }
    }
}
