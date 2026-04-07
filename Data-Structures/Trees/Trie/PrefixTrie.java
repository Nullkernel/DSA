import java.util.*;

class PrefixNode {
    PrefixNode[] children = new PrefixNode[26];
    int count;

    PrefixNode() {
        count = 0;
    }
}

public class PrefixTrie {
    PrefixNode root;

    public PrefixTrie() {
        root = new PrefixNode();
    }

    private int getValidatedIndex(char ch, int position, String input) {
        char normalized = Character.toLowerCase(ch);
        int index = normalized - 'a';
        if (index < 0 || index >= 26) {
            throw new IllegalArgumentException(
                "Invalid character '" + ch + "' at position " + position
                    + " in \"" + input + "\". Please use letters a-z only."
            );
        }
        return index;
    }

    public void insert(String word) {
        PrefixNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = getValidatedIndex(word.charAt(i), i, word);
            if (curr.children[index] == null) {
                curr.children[index] = new PrefixNode();
            }
            curr = curr.children[index];
            curr.count++;
        }
    }

    public int countPrefix(String prefix) {
        PrefixNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = getValidatedIndex(prefix.charAt(i), i, prefix);
            if (curr.children[index] == null) {
                return 0;
            }
            curr = curr.children[index];
        }
        return curr.count;
    }

    public static void main(String[] args) {
        PrefixTrie trie = new PrefixTrie();

        // Valid examples (uppercase is normalized to lowercase)
        trie.insert("Apple");
        trie.insert("application");
        trie.insert("app");
        System.out.println("countPrefix(app): " + trie.countPrefix("app"));
        System.out.println("countPrefix(AP): " + trie.countPrefix("AP"));

        // Invalid example
        try {
            trie.insert("ab#c");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid example error: " + e.getMessage());
        }
    }
}
