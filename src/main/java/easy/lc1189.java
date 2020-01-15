package easy;

class lc1189 {
    public int maxNumberOfBalloons(String text) {
        char[] chars = new char[26];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            chars[c - 97]++;
        }
        return Math.min(chars[0], Math.min(chars[1], Math.min(chars['n' - 'a'], Math.min(chars['l' - 'a'] / 2 , chars['o' - 'a'] / 2))));
    }
}