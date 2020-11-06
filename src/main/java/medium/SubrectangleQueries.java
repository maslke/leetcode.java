package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/subrectangle-queries/
// leetcode-1476

public class SubrectangleQueries {

    private int[][] rectangle;
    private List<int[]> list;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        this.list = new ArrayList<>();
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        this.list.add(new int[]{row1, col1, row2, col2, newValue});
    }

    public int getValue(int row, int col) {

        for (int i = this.list.size() - 1; i >= 0; i--) {
            int[] arr = this.list.get(i);
            if (row >= arr[0] && row <= arr[2] && col >= arr[1] && col <= arr[3]) {
                return arr[4];
            }
        }

        return rectangle[row][col];
    }
}
