import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    char[][] board;
    int tr;
    int tc;
    TrieNode root = new TrieNode();
    List<String> rst = new ArrayList<>();

    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;    // will only be word if this TrieNode is leaf

        // check if this node is leaf node
        boolean isLeafNode() {
            return this.word != null;
        }

        // check if char c is in next level of current node
        boolean hasNext(char c) {
            return next[c - 'a'] != null;
        }

        // get next level TrieNode of char c
        TrieNode getNext(char c) {
            if (!hasNext(c)) {
                this.next[c - 'a'] = new TrieNode();
            }

            return next[c - 'a'];
        }
    }

    /**
     * build trie from string array
     *
     * @param words input words array
     * @return completed root node
     */
    public TrieNode buildTrie(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                curr = curr.getNext(c);
            }
            // at the end of word, fill in word in current node
            curr.word = word;
        }

        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.tr = board.length;
        this.tc = board[0].length;
        this.root = buildTrie(words);

        /**
         * bug point 2:
         * need to check every staring point
         */
        for (int row = 0; row < tr; row++) {
            for (int col = 0; col < tc; col++) {
                helper(row, col, root);
            }
        }

        return rst;
    }

    public void helper(int row, int col, TrieNode curr) {
        //check if current cell is valid
        if (oob(row, col))
            return;

        char c = board[row][col];
        // check if current cell is visited
        if (c == '$')
            return;

        // check if current char is in trie
        if (!curr.hasNext(c))
            return;

        curr = curr.getNext(c);

        // if it is word
        if (curr.isLeafNode()) {
            rst.add(curr.word);
            /**
             * remove the word from trie, for de-duplication
             */
            curr.word = null;

            /**
             * bug point: DO NOT RETURN HERE
             * ext: "benda", "benda"
             * returning here will stop DFS from searching for longer and deeper solutions
             */
        }

        // classic DFS template
        board[row][col] = '$';
        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            helper(nr, nc, curr);
        }
        board[row][col] = c;
    }

    private boolean oob(int row, int col) {
        return row < 0 || col < 0 || row >= tr || col >= tc;
    }

}