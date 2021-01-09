package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/snapshot-array/
// 1146. 快照数组

public class lc1146 {

}

class SnapshotArray {

    private int len;
    private int version;
    private List<Map<Integer, Integer>> values;

    public SnapshotArray(int length) {
        len = length;
        version = 0;
        values = new ArrayList<>();
        values.add(new HashMap<>());
    }

    public void set(int index, int val) {
        values.get(version).put(index, val);
    }

    public int snap() {
        values.add(new HashMap<>(values.get(version)));
        return version++;
    }

    public int get(int index, int snap_id) {
        return values.get(snap_id).getOrDefault(index, 0);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
