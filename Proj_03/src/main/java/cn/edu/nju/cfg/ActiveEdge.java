package cn.edu.nju.cfg;

public class ActiveEdge {

    Rule rule;

    int position;

    public ActiveEdge(Rule rule) {
        this.rule = rule;
        this.position = 0;
    }

    public boolean isDone() {
        return position == rule.getRight().length - 1;
    }
}
