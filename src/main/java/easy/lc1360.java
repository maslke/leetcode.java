package easy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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