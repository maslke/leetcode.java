//https://leetcode.com/problems/palindrome-number/
//9. Palindrome Number
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add(0, x % 10);
            x = x / 10;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}