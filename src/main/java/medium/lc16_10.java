package medium;

public class lc16_10 {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] years = new int[101];
        for (int i = 0; i < birth.length; i++) {
            for (int j = birth[i] - 1900; j <= death[i] - 1900; j++) {
                years[j]++;
            }
        }
        int max = 0;
        int year = 0;
        for (int i = 0; i < years.length; i++) {
            if (max < years[i]) {
                year = i;
                max = years[i];
            }
        }

        return year + 1900;
    }

    // better
    public int maxAliveYear2(int[] birth, int[] death) {
        int[] lives = new int[102];
        for (int i = 0; i < birth.length; i++) {
            lives[birth[i] - 1900]++;
            lives[death[i] - 1900 + 1]--;
        }

        int pev = lives[0];
        int max = pev;
        int year = 0;
        for (int i = 1; i < lives.length; i++) {
            int current = pev + lives[i];
            if (current > max) {
                max =current;
                year = i;
            }
            pev = current;
        }
        return year + 1900;
    }
}
