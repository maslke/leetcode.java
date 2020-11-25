package easy;

class lc1154 {
    public int dayOfYear(String date) {
        int[] months = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int ret = 0;
        for (int i = 0; i < month - 1; i++) {
            ret += months[i];
        }

        if (month > 2 && isLeap(year)) {
            ret += 1;
        }
        return ret + day;
    }

    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0);
    }
}