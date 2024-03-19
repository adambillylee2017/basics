package utils;

import java.util.List;

public class ListArrayUtils {
    private static final String[] BRACKETS = {"\\[", "\\]"};

    // write a regex ma
    private static final String COL_DELIMITER = ",";
    private static final String ROW_DELIMITER = "],\\[";


    public static int[] toIntArr(final List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] build1D(String str) {
        for (String s : BRACKETS) {
            str = str.replaceAll(s, "");
        }

        String[] split = str.split(COL_DELIMITER);
        int[] intArr = new int[split.length];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(split[i]);
        }

        return intArr;
    }

    public static int[][] build2D(String str) {
        String[] rows = str.split(ROW_DELIMITER);
        int[][] result = new int[rows.length][];

        for (int r = 0; r < rows.length; r++) {
            int[] oneD = build1D(rows[r]);
            result[r] = oneD;
        }

        return result;
    }

    public static void prettyPrint(int[][] matrix) {
        for (int[] row : matrix) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(row[c] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
