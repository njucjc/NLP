package cn.edu.nju.parser;

import cn.edu.nju.cfg.Rule;
import cn.edu.nju.position.Position;

public class Edge {

    Rule rule;

    String name;

    Position pos; //current position



    int index; //current matched right part index

    Position [] rightPos;

    public Edge(Rule rule, String name, Position pos) {

        this.rule = rule;
        this.name = name;
        this.pos = pos;
        if(rule != null) {
            this.index = 0;
            this.rightPos = new Position[rule.getRightLength()];
            this.rightPos[0] = new Position(pos);
        }
    }

    public Edge(Edge edge) {

        this.rule = edge.rule;
        this.name = edge.name;
        this.pos = new Position(edge.pos);
        this.index = edge.index;

        if(rule != null) {
            this.rightPos = new Position[rule.getRightLength()];

            for (int i = 0; i <= index; i++) {
                this.rightPos[i] = new Position(edge.rightPos[i]);
            }
        }

    }



    public Position getPos() {
        return pos;
    }



    public int getIndex() {
        return index;
    }


    public void setPos(Position pos) {
        if(!isDone()) {
            index++;
            this.rightPos[index] = new Position(this.rightPos[index - 1].getEnd(), pos.getEnd());
        }

        this.pos = pos;
    }

    public boolean isDone() {

        return rule == null || index == rule.getRightLength() - 1;
    }

    public String getName() {
        return name;
    }

    public String getNext() {
        if(!isDone()) {
            return rule.getRight()[index + 1];
        }
        else {
            return null;
        }
    }

    public Rule getRule() {
        return rule;
    }

    public Position[] getRightPos() {
        return rightPos;
    }
}
