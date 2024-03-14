import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 5/10/16.
 */
public class Combinations {
    List<List<Integer>> rst;
    int n;
    int k;

    /**
     * @param n from range [1, n]
     * @param k generate combination with k numbers
     */
    public List<List<Integer>> combine(int n, int k) {
        rst = new ArrayList<>();
        this.n = n;
        this.k = k;

        dfs(new ArrayList<>(), 1);

        return rst;
    }

    public void dfs(List<Integer> list, int start) {
        // base cases
        if (list.size() == k) {
            rst.add(new ArrayList<>(list));
            return;
        }

        if (start == n + 1) {
            return;
        }

        // choices
        dfs(list, start + 1);

        list.add(start);
        dfs(list, start + 1);
        list.remove(list.size() - 1);
    }
}
