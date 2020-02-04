package easy;

class lc392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        String s1 = s.substring(0, 1);
        int index = t.indexOf(s1);
        if (index == -1) return false;
        return isSubsequence(s.substring(1), t.substring(index + 1));
    }
}