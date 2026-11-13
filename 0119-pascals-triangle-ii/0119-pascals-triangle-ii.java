import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 1; i <= rowIndex; i++) {

            List<Integer> prevrow = result.get(i - 1);

            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 0; j < i - 1; j++) {
                row.add(prevrow.get(j) + prevrow.get(j + 1));
            }

            row.add(1);
            result.add(row);
        }

        return result.get(rowIndex);
    }
}