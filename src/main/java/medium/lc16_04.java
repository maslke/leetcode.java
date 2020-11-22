package medium;

public class lc16_04 {
    public String tictactoe(String[] board) {
        boolean empty = false;
        int length = board.length;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String xwin;
        String owin;
        for (int i = 0; i < length; i++) {
            sb.append("X");
            sb2.append("O");
        }
        xwin = sb.toString();
        owin = sb2.toString();

        for (int i = 0; i < board.length; i++) {
            if (board[i].equals(xwin)) {
                return "X";
            }
            if(board[i].equals(owin)) {
                return "O";
            }

            StringBuilder sb3 = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                char c = board[j].charAt(i);
                if (c == ' ') {
                    empty = true;
                    break;
                }
                sb3.append(board[j].charAt(i));
            }
            if (sb3.toString().equals(xwin)) {
                return "X";
            }
            if(sb3.toString().equals(owin)) {
                return "O";
            }
        }

        int m = 0;
        sb = new StringBuilder();
        while (m < board.length) {
            sb.append(board[m].charAt(m));
            m++;
        }
        if (sb.toString().equals(xwin)) {
            return "X";
        }
        if(sb.toString().equals(owin)) {
            return "O";
        }

        m = 0;
        int n = board.length - 1;
        sb = new StringBuilder();
        while (m < board.length) {
            sb.append(board[m].charAt(n));
            m++;
            n--;
        }
        if (sb.toString().equals(xwin)) {
            return "X";
        }
        if(sb.toString().equals(owin)) {
            return "O";
        }

        return empty ? "Pending" : "Draw";
    }
}
