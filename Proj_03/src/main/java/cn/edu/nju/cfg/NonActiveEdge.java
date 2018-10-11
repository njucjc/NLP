package cn.edu.nju.cfg;

public class NonActiveEdge {

    String symbol;

    int leftPos;

    int rightPos;

    public NonActiveEdge(String symbol, int leftPos, int rightPos) {
        this.symbol = symbol;
        this.leftPos = leftPos;
        this.rightPos = rightPos;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getLeftPos() {
        return leftPos;
    }

    public int getRightPos() {
        return rightPos;
    }
}
