//https://leetcode.com/problems/zigzag-conversion/
//6. ZigZag Conversion
class Solution {
    public String convert(String s, int numRows) {
        List<List<String>> ret = new ArrayList<List<String>>();
        for (int inx = 0; inx < numRows; inx++) {
            ret.add(new ArrayList<String>());
        }
        int i = 0;
        int len = s.length();
        while (i < len) {
            for (int j = 0; j < numRows; j++) {
                if (i >= len) break;
                ret.get(j).add(s.substring(i, i + 1));
                i++;
                
            }
            for (int j = numRows - 2; j >= 1; j--) {
                if (i >= len) break;
                ret.get(j).add(s.substring(i, i + 1));
                i++;
                
            }
        }
        return convert(ret);
        
    }
    
    private String convert(List<List<String>> ret) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ret.size(); i++) {
            for (int j = 0;j < ret.get(i).size(); j++) {
                sb.append(ret.get(i).get(j));
            }
        }
        return sb.toString();
    }
}