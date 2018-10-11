package cn.edu.nju.cfg;

import cn.edu.nju.position.Position;

public class ActiveEdge {

    Rule rule;

    int index;

    Position pos;

    public ActiveEdge(Rule rule, Position pos) {
        this.rule = rule;
        this.pos = pos;
        this.index = 0;
    }

    public boolean isDone() {
        return index == rule.getRight().length - 1;
    }
}
