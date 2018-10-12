package cn.edu.nju.position;

/**
 * Created by njucjc at 2018/10/11
 */
public class Position {
    int start, end;

    public Position(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Position(Position p) {
        this.start = p.start;
        this.end = p.end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position) {
            Position p = (Position) obj;
            return p.start == start && p.end == end;
        }
        return false;
    }
}
