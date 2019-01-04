class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.equals("") || digits == null) return ret;
        Map<Character, String> map = new HashMap<>();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 2; i <= 6; i++) {
            map.put((char)(48 + i), letters.substring(3 * i - 6, 3 * i - 3));
        }
        map.put((char)(48 + 7), "pqrs");
        map.put((char)(48 + 8), "tuv");
        map.put((char)(48 + 9), "wxyz");
        
        String first = map.get(digits.charAt(0));
        for (int i = 0; i < first.length(); i++) {
            ret.add(first.substring(i, i + 1));
        }
        
        for (int i = 1; i < digits.length(); i++) {
            String w = map.get(digits.charAt(i));
            List<String> result = new ArrayList<>();
            for (int j = 0; j < w.length(); j++) {
                for (int m = 0; m < ret.size(); m++) {
                    result.add(ret.get(m) + w.substring(j, j + 1));
                } 
            }
            ret = result;
        }
        
        return ret;
    }
}