import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionLabelsTest {
    PartitionLabels.Solution sol = new PartitionLabels.Solution();

    @Test
    public void testPartitionLabels() {
        System.out.println(
                sol.partitionLabels("ababcbacadefegdehijhklij")
        );
    }
}