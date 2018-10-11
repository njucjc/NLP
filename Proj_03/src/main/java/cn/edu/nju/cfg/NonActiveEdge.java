package cn.edu.nju.cfg;

import cn.edu.nju.position.Position;

public class NonActiveEdge {

    String symbol;

    Position pos;

    public NonActiveEdge(String symbol, Position pos) {
        this.symbol = symbol;
        this.pos = pos;
    }

    public String getSymbol() {
        return symbol;
    }

    public Position getPos() {
        return this.pos;
    }
}
