package medium;

import java.util.Stack;

class BrowserHistory2 {

    String[] pages;
    int currentPage;
    int totalPage;

    public BrowserHistory2(String homepage) {
        this.pages = new String[501];
        this.currentPage = 0;
        this.totalPage = 1;
        this.pages[currentPage] = homepage;
    }

    // visit操作。当前currentPage之上的所有页面需要放弃
    public void visit(String url) {
        this.pages[++this.currentPage] = url;
        this.totalPage = this.currentPage + 1;
    }

    public String back(int steps) {
        this.currentPage = this.currentPage >= steps ? this.currentPage - steps : 0;
        return this.pages[this.currentPage];
    }

    public String forward(int steps) {
        if (this.currentPage + steps >= this.totalPage) {
            this.currentPage = this.totalPage - 1;
            return this.pages[this.currentPage];
        } else {
            this.currentPage += steps;
            return this.pages[this.currentPage];
        }
    }
}

public class BrowserHistory {

    Stack<String> back;
    Stack<String> forward;
    String homepage;

    public BrowserHistory(String homepage) {
        this.back = new Stack<>();
        this.forward = new Stack<>();
        this.homepage = homepage;
    }

    public void visit(String url) {
        this.back.push(this.homepage);
        this.homepage = url;
        this.forward.clear();
    }

    public String back(int steps) {
        String url = this.homepage;
        if (back.isEmpty()) {
            return url;
        }
        forward.push(url);
        while (!back.isEmpty() && steps > 0) {
            url = back.pop();
            steps--;
            forward.push(url);
        }
        forward.pop();
        this.homepage = url;
        return url;
    }

    public String forward(int steps) {
        String url = this.homepage;
        if (forward.isEmpty()) {
            return url;
        }
        back.push(url);
        while (!forward.isEmpty() && steps > 0) {
            url = forward.pop();
            back.push(url);
            steps--;
        }
        back.pop();
        this.homepage = url;
        return url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
