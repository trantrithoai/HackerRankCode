import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder s = new StringBuilder();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();

            if (a == 1) {
                // Save current state before modification
                history.push(s.toString());
                s.append(in.next());
            } else if (a == 2) {
                // Save current state before modification
                history.push(s.toString());
                int num = in.nextInt();
                s.delete(s.length() - num, s.length());
            } else if (a == 3) {
                System.out.println(s.charAt(in.nextInt() - 1));
            } else if (a == 4) {
                // Undo the last operation
                if (!history.isEmpty()) {
                    s = new StringBuilder(history.pop());
                }
            }
        }

        in.close();
    }
}
