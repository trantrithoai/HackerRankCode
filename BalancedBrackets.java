import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return "NO";
                }
                
                char lastBracket = stack.pop();
                if ((ch == ')' && lastBracket != '(') ||
                    (ch == ']' && lastBracket != '[') ||
                    (ch == '}' && lastBracket != '{')) {
                    return "NO";
                }
            }
        }
        
        return stack.isEmpty() ? "YES" : "NO";
    }
    
    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));  // Output: YES
        System.out.println(isBalanced("{[(])}"));  // Output: NO
        System.out.println(isBalanced("{{[[(())]]}}"));  // Output: YES
    }
}
