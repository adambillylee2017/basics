import java.util.*;

public class WordLadder {
    Trie trie = new Trie();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // put word list into trie
        trie.build(wordList);
        trie.add(beginWord);

        return bfs(beginWord, endWord);
    }

    int bfs(String beginWord, String endWord) {
        int ladderLength = 0;

        Queue<String> queue = new LinkedList<>();
        // mark begin word visited before push to queue
        trie.found(beginWord).markVisited();
        queue.offer(beginWord);
        int size;

        while (!queue.isEmpty()) {
            ladderLength++;

            // use size to track progression of levels
            size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) {
                    return ladderLength;
                }

                List<String> nextWords = expend(currWord);
                queue.addAll(nextWords);
            }
        }

        return 0;
    }

    List<String> expend(String word) {
        List<String> nextWords = new ArrayList<>();
        for (int idx = 0; idx < word.length(); idx++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(idx)) {
                    continue;
                }

                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(idx, c);
                String newWord = sb.toString();

                TrieNode node = trie.found(newWord);
                if (node != null) {
                    // mark visited before push to queue
                    node.markVisited();
                    nextWords.add(newWord);
                }
            }
        }

        return nextWords;
    }

    class TrieNode {
        char c;
        boolean isEndOfWord = false;
        boolean visited = false;

        Map<Character, TrieNode> next = new HashMap<>();

        TrieNode(char c) {
            this.c = c;
        }

        boolean hasNext(char c) {
            return this.next.containsKey(c);
        }

        TrieNode getNext(char c) {
            return this.next.get(c);
        }

        void markVisited() {
            this.visited = true;
        }
    }

    public class Trie {
        TrieNode root = new TrieNode(' ');

        TrieNode found(String word) {
            TrieNode curr = root;

            for (char c : word.toCharArray()) {
                if (curr.hasNext(c)) {
                    curr = curr.getNext(c);
                } else {
                    return null;
                }
            }

            if (!curr.visited && curr.isEndOfWord) {
                return curr;
            } else {
                return null;
            }

        }

        void add(String word) {
            TrieNode curr = root;

            for (char c : word.toCharArray()) {
                if (!curr.hasNext(c)) {
                    TrieNode newNode = new TrieNode(c);
                    curr.next.put(c, newNode);
                }

                curr = curr.getNext(c);
            }

            curr.isEndOfWord = true;
        }

        void build(List<String> wordList) {
            for (String word : wordList) {
                this.add(word);
            }
        }
    }

}
