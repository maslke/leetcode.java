package easy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class lc13602 {
    public int daysBetweenDates(String date1, String date2) {
       int days1 = days(date1);
       int days2 = days(date2);
       return Math.abs(days1 - days2);
   }

   int[] mdays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

   // days from 1900-1-0
   private int days(String d) {
       String[] ss = d.split("-");
       int year = Integer.valueOf(ss[0]);
       int month = Integer.valueOf(ss[1]);
       int day = Integer.valueOf(ss[2]);
       // years we spent, hence -1 because current year is not spent yet
       int ydelta = year - 1 - 1900;
       int dy = ydelta * 365 + ydelta / 4;// from 1900 every 4 years is leap year
       // month-1, current month is not done yet
       int dm = mdays[month - 1];
       if (isleap(year) && month - 1 >= 2) {
           dm++;
       }
       return dy + dm + day;
   }

   private boolean isleap(int year) {
       return (year % 100 != 0 && year % 4 == 0) || (year % 100 == 0 && year % 400 == 0);
   }

}


class lc1360 {
    public int daysBetweenDates(String date1, String date2) {
    
        List<Integer> p1 = getParts(date1);
        List<Integer> p2 = getParts(date2);
        
        LocalDate d1 = LocalDate.of(p1.get(0), p1.get(1), p1.get(2));
        LocalDate d2 = LocalDate.of(p2.get(0), p2.get(1), p2.get(2));
        return Math.abs((int)(d2.toEpochDay() - d1.toEpochDay()));
        
    }
    
    private List<Integer> getParts(String date) {
        List<Integer> result = new ArrayList<>();
        String[] parts= date.split("-");
        result.add(Integer.parseInt(parts[0]));
        if (parts[1].indexOf("0") == 0) {
            result.add(Integer.parseInt(parts[1].substring(1, 2)));
        } else {
            result.add(Integer.parseInt(parts[1]));
        }
        if (parts[2].indexOf("0") == 0) {
            result.add(Integer.parseInt(parts[2].substring(1, 2)));
        } else {
            result.add(Integer.parseInt(parts[2]));
        }
        return result;
    }
}