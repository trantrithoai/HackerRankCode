public static int palindromeIndex(String s) {
    int left = 0;
    int right = s.length() - 1;
    
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            // Check if removing the left character makes it a palindrome
            if (isPalindrome(s, left + 1, right)) {
                return left;
            }
            // Check if removing the right character makes it a palindrome
            if (isPalindrome(s, left, right - 1)) {
                return right;
            }
            // If neither removal results in a palindrome
            return -1;
        }
        left++;
        right--;
    }
    
    // The string is already a palindrome
    return -1;
}

private static boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
