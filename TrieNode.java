class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // If current character is not present, add it
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);

            // If we reach a node that is already marked as end of a word, it means
            // the current word is a prefix of a previously inserted word
            if (current.isEndOfWord) {
                return false;
            }
        }
        // If this word is a prefix of an already inserted word, return false
        if (!current.children.isEmpty()) {
            return false;
        }

        // Mark the end of this word
        current.isEndOfWord = true;
        return true;
    }
}

class Result {

    public static void noPrefix(List<String> words) {
        Trie trie = new Trie();

        for (String word : words) {
            // If inserting the word returns false, it means there is a conflict
            if (!trie.insert(word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }

        // If no conflicts were found
        System.out.println("GOOD SET");
    }
}
