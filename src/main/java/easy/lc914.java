package easy;

// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
// 914. X of a Kind in a Deck of Cards
class lc914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] values= new int[10001];
        for (int v : deck) {
            values[v]++;
        }
        int min = -1;
        for (int v : values) {
            if (v == 0) continue;
            int g = min == -1 ? v : gcd(v, min);
            if (g == 1) return false;
            min = g;
        }
        return true;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}