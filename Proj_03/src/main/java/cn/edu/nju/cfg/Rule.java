package cn.edu.nju.cfg;

public class Rule {

    int no;

    String left;

    String [] right;

    int rightLength;

    public Rule(String left, String[] right, int no) {
        this.no = no;
        this.left = left;
        this.right = right;
        this.rightLength = right.length;
    }

    public String getLeft() {
        return left;
    }

    public String[] getRight() {
        return right;
    }

    public int getNo() {
        return no;
    }

    public int getRightLength() {
        return rightLength;
    }

    public String getRightByIndex(int index) {
        return right[index];
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
