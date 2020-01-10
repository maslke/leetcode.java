package medium;

import java.util.List;
import java.util.ArrayList;

class lc60 {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(Integer.valueOf(i));
        }
        return getPermutation(numbers, k);
    }

    private String getPermutation(List<Integer> numbers, int k) {
        int size = numbers.size();
        if (size == 0) {
            return "";
        }
        if (k == 1) {
            return getString(numbers);
        }
        if (k == count(size)) {
            return getReverseString(numbers);
        }
        while (true) {
            int count = count(size - 1);
            if (count < k) {
                int a = k / count;
                int b = k % count;
                if (b == 0) {
                    Integer p = numbers.get(a - 1);
                    numbers.remove(a - 1);
                    return String.valueOf(p) + getReverseString(numbers);
                } else {
                    Integer p = numbers.get(a);
                    numbers.remove(a);
                    return String.valueOf(p) + getPermutation(numbers, b);
                }       
            } else {
                Integer p = numbers.get(0);
                numbers.remove(0);
                return String.valueOf(p) + getPermutation(numbers, k);
            }
        }
    } 

    private int count(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private String getString(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
        }
        return sb.toString();
    }

    private String getReverseString(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            sb.append(numbers.get(i));
        }
        return sb.toString();
    }
}