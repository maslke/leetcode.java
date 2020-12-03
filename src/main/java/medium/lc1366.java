package medium;

import java.util.*;

// https://leetcode-cn.com/problems/rank-teams-by-votes/
// 1366. 通过投票对团队排名

public class lc1366 {
    public String rankTeams(String[] votes) {
        if (votes.length == 1) {
            return votes[0];
        }
        int count = votes[0].length();
        int[][] chars = new int[26][count];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < votes.length; i++) {
            String vote = votes[i];
            for (int j = 0; j < vote.length(); j++) {
                int inx = vote.charAt(j) - 'A';
                set.add(inx);
                chars[inx][j]++;
            }

        }


        List<Group> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(i)) {
                list.add(new Group((char)(i + 'A'), chars[i]));
            }
        }

        list.sort((a, b) -> {
            int[] s1 = a.scores;
            int[] s2 = b.scores;
            int i = 0;
            int j = 0;
            while (i < s1.length) {
                if (s1[i] < s2[i]) {
                    return 1;
                } else if (s1[i] == s2[i]) {
                    i++;
                } else {
                    return -1;
                }
            }
            return a.name - b.name;

        });

        StringBuilder sb = new StringBuilder();
        for (Group group : list) {
            sb.append(group.name);
        }
        return sb.toString();
    }

    static class Group {
        char name;
        int[] scores;

        Group(char name, int[] scores) {
            this.name = name;
            this.scores = scores;
        }
    }
}
