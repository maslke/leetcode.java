
public class lc929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String e = emails[i];
            String contents[] = e.split("@");
            int index = contents[0].indexOf("+");
            String email = contents[0].substring(0, index >= 0 ? index : contents[0].length())
                .replaceAll("\\.", "") + "@" + contents[1];
            set.add(email);
        }
        return set.size();
    } 
}