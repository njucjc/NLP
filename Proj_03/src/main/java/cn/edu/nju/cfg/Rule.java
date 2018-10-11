package cn.edu.nju.cfg;

public class Rule {

    String left;

    String [] right;

    public Rule(String left, String[] right) {
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public String[] getRight() {
        return right;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(left + "->");

        for(String s : right) {
            str.append(s);
            str.append(" ");
        }

        return str.toString();
    }
}
