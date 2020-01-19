package easy;

class lc1313 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            int a = nums[i];
            int b = nums[i + 1];
            for (int m = 1; m <= a; m++) {
                list.add(b);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}