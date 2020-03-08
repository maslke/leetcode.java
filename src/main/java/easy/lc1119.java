package easy;

class lc1119 {
    public String removeVowels(String S) {
        if (S == null || S.equals("")) return S;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if ("aeiou".indexOf(c)== -1) {
                sb.append(c);
            }
        }
        return sb.toString();

    }
}