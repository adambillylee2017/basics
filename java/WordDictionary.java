public class WordDictionary {
    static class Solution {
        Node root;

        public Solution() {
            this.root = new Node('.');
        }

        public void addWord(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                curr = curr.add(c);
            }
            curr.markEndOfWord();
        }

        public boolean search(String word) {
            return search(word.toCharArray(), 0, root);
        }

        public boolean search(char[] chars, int currIdx, Node curr) {
            if (curr != null && currIdx == chars.length) {
                return curr.isEndOfWord();
            } else if (curr == null) {
                return false;
            }

            char c = chars[currIdx];

            if (c == '.') {
                for (char n = 'a'; n <= 'z'; n++) {
                    boolean found = search(chars, currIdx + 1, curr.findNext(n));

                    if (found) {
                        return true;
                    }
                }

                return false;
            } else {
                return search(chars, currIdx + 1, curr.findNext(c));
            }
        }

    }

    static class Node {
        char c;
        Node[] next;
        boolean isEndOfWord = false;

        Node(char c) {
            this.c = c;
            this.next = new Node[26];
        }

        Node add(char n) {
            if (n == '.') {
                return this;
            }

            if (findNext(n) == null) {
                Node nNode = new Node(n);
                this.next[n - 'a'] = nNode;
            }
            return findNext(n);

        }

        Node findNext(char n) {
            return this.next[n - 'a'];
        }

        void markEndOfWord() {
            this.isEndOfWord = true;
        }

        boolean isEndOfWord() {
            return this.isEndOfWord;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
